package com.anotherspectrum.smps;

import co.aikar.commands.PaperCommandManager;
import com.anotherspectrum.anotherlibrary.AnotherLibrary;
import com.anotherspectrum.anotherlibrary.utils.StringUtil;
import com.anotherspectrum.smps.api.channel.Channel;
import com.anotherspectrum.smps.api.item.Item;
import com.anotherspectrum.smps.api.item.manager.ItemCache;
import com.anotherspectrum.smps.api.monster.manager.MonsterDB;
import com.anotherspectrum.smps.api.player.manager.PlayerCache;
import com.anotherspectrum.smps.commands.ContentCommands;
import com.anotherspectrum.smps.commands.EquipmentCommand;
import com.anotherspectrum.smps.commands.PacketCommand;
import com.anotherspectrum.smps.commands.TitleCommand;
import com.anotherspectrum.smps.database.DatabaseConnect;
import com.anotherspectrum.smps.file.Equations;
import com.anotherspectrum.smps.listeners.event.EventHandler;
import com.anotherspectrum.smps.listeners.packet.EntityPacket;
import com.anotherspectrum.smps.listeners.packet.ServerListPingPacket;
import com.anotherspectrum.smps.util.HealthBar;
import com.anotherspectrum.smps.util.Logger;
import com.anotherspectrum.smps.util.logtypes.LT;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import me.filoghost.holographicdisplays.api.HolographicDisplaysAPI;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.apache.commons.lang.StringUtils;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.mariuszgromada.math.mxparser.License;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <b>Sententia Server</b> 매니지먼트 시스템입니다.
 * 해당 클래스는 다양한 컨텐츠, 시스템과의 상호작용을 이룹니다.
 */
public final class MPS extends JavaPlugin {

    private static MPS instance;
    private AnotherLibrary anotherLibrary;
    private PaperCommandManager paperCommandManager;
    private PlayerCache playerCache;
    private ItemCache itemCache;
    private MonsterDB monsterCache;
    private DatabaseConnect databaseConnect;
    private ProtocolManager protocolManager;

    /**
     * 해당 필드는 모든 클래스가 로드된 후인 제일 마지막에 로드됩니다.
     * 따라서 해당 인스턴스보다 우선 호출 시 외부 클래스에서 호출 시
     * Priority에 따라 오류가 발생할 수 있습니다.
     */
    private EntityPacket entityPacket;
    private Equations equations;

    private BukkitAudiences bukkitAudiences;

    private HolographicDisplaysAPI holographicDisplaysAPI;

    @Override
    public void onEnable() {
        /* STATIC MAIN CLASS FIELD */
        instance = this;

        {
            this.bukkitAudiences = BukkitAudiences.create(this);
        } // Create Audience

        {
            /* Non-Commercial Use Confirmation */
            License.iConfirmNonCommercialUse("Lee JunSuk");

            /* Verification if use type has been already confirmed */
            License.checkIfUseTypeConfirmed();

            /* Checking use type confirmation message */
            License.getUseTypeConfirmationMessage();
        } // mXparser License

        /* HOOKING LIBS */
        this.anotherLibrary = new AnotherLibrary(this);
        this.paperCommandManager = new PaperCommandManager(this);

        /* LOAD MAIN CONFIG */
        loadConfig();

        /* HOOKING LIBS */
        loadLibraries();

        /* CONNECTING DATABASE */
        Logger.nt(" ");
        final ReentrantLock lock = new ReentrantLock();
        lock.lock();
        try {
            this.databaseConnect = new DatabaseConnect(this);
            this.databaseConnect.connect();
            this.itemCache = new ItemCache(this);
            this.playerCache = new PlayerCache(this);
            this.monsterCache = new MonsterDB(this);
        } finally {
            lock.unlock();
        }
        Logger.nt(" ");

        /* REGISTER EVENTS */
        new EventHandler(this);
        if (getConfig().getBoolean("events.battle.bossBarHealth.alwaysSelfBar") || getConfig().getBoolean("events.battle.bossBarHealth.enemy.enabled"))
            HealthBar.updateAll();
        EventHandler.startHealthBarSelfAlways(this);

        /* ANY REGISTRY */
        registerChannels();
        registerCommands();
        registerPackets();

        Objects.requireNonNull(getServer().getWorld("world")).getEntities().forEach(Entity::remove);
        getServer().getScheduler().scheduleSyncDelayedTask(this, this::displayBanner, 40L);
        playersDataSaveToDatabaseTurningTime();
    }

    private void loadLibraries() {

        if (HookingManager.useHolographicDisplays()) {
            this.holographicDisplaysAPI = HolographicDisplaysAPI.get(this);
            Logger.log(LT.LIBRARY, "'HolographicDisplays' 플러그인을 로드했습니다.");
        }

    }

    private void playersDataSaveToDatabaseTurningTime() {
        getServer().getScheduler().scheduleSyncRepeatingTask(this, () -> {
            if (!getServer().getOnlinePlayers().isEmpty()) {
                getServer().getOnlinePlayers().forEach(v -> playerCache.savePlayerDataToDatabase(v));
                Logger.log(LT.DATABASE, "서버에 접속중인 플레이어 " + Logger.GREEN + getServer().getOnlinePlayers().size() + Logger.RESET + "명의 데이터를 PlayerDB에 저장했습니다.");
            }
        }, 0L, 12000L);
    }

    private void displayBanner() {
        Logger.nt("\n" + StringUtils.repeat("\n", 40) + "                                                                                                                                                                                                 \n" +
                "                                         #######                                                                                                #####   ##    ##       ##### ##       #######    \n" +
                "                                       /       ###                                                               #                           ######  /#### #####    ######  /###    /       ###  \n" +
                "                                      /         ##                           #                           #      ###                         /#   /  /  ##### ##### /#   /  /  ###  /         ##  \n" +
                "                                      ##        #                           ##                          ##       #                         /    /  /   # ##  # ## /    /  /    ### ##        #   \n" +
                "                                       ###                                  ##                          ##                                     /  /    #     #        /  /      ##  ###          \n" +
                "                                      ## ###           /##  ###  /###     ######## /##  ###  /###     ######## ###       /###                 ## ##    #     #       ## ##      ## ## ###        \n" +
                "                                       ### ###        / ###  ###/ #### / ######## / ###  ###/ #### / ########   ###     / ###  /              ## ##    #     #       ## ##      ##  ### ###      \n" +
                "                                         ### ###     /   ###  ##   ###/     ##   /   ###  ##   ###/     ##       ##    /   ###/               ## ##    #     #     /### ##      /     ### ###    \n" +
                "                                           ### /##  ##    ### ##    ##      ##  ##    ### ##    ##      ##       ##   ##    ##                ## ##    #     #    / ### ##     /        ### /##  \n" +
                "                                             #/ /## ########  ##    ##      ##  ########  ##    ##      ##       ##   ##    ##                ## ##    #     ##      ## ######/           #/ /## \n" +
                "                                              #/ ## #######   ##    ##      ##  #######   ##    ##      ##       ##   ##    ##                #  ##    #     ##      ## ######             #/ ## \n" +
                "                                               # /  ##        ##    ##      ##  ##        ##    ##      ##       ##   ##    ##                   /     #      ##     ## ##                  # /  \n" +
                "                                     /##        /   ####    / ##    ##      ##  ####    / ##    ##      ##       ##   ##    /#    #          /##/      #      ##     ## ##        /##        /   \n" +
                "                                    /  ########/     ######/  ###   ###     ##   ######/  ###   ###     ##       ### / ####/ ##  ###        /  #####           ##    ## ##       /  ########/    \n" +
                "                                   /     #####        #####    ###   ###     ##   #####    ###   ###     ##       ##/   ###   ##  #        /     ##             ##   ## ##      /     #####      \n" +
                "                                   |                                                                                                       #                   ###   #  /       |                \n" +
                "                                    \\)                                                                                                      ##                  ###    /         \\)              \n" +
                "                                                                                                                                                                 #####/                          \n" +
                "                                                                                                                                                                   ###                           \n" +
                "                                             Main author. Else_JunSuk\n" + StringUtils.repeat("\n", 21));

    }

    @Override
    public void onDisable() {
        // Cause = PLUGIN
        HealthBar.removeAll();
        getServer().getOnlinePlayers().forEach(v -> v.kick(StringUtil.format("<red><b>[ Sententia ]</b>").appendNewline().append(StringUtil.format("<white>현재 서버 리부팅 중 입니다!")), PlayerKickEvent.Cause.PLUGIN));
    }

    private void registerCommands() {
        new ContentCommands(this);
        paperCommandManager.registerCommand(new TitleCommand(this));
        paperCommandManager.registerCommand(new PacketCommand(this));
        paperCommandManager.registerCommand(new EquipmentCommand(this));
    }

    private void registerChannels() {
        ConfigurationSection iDSection = getConfig().getConfigurationSection("channel.channels");
        if (iDSection != null) {
            iDSection.getKeys(false).forEach(id -> {
                final String v = "channel.channels." + id;
                int maxMemberSize = getConfig().getInt(v + ".maxMemberSize");
                if (maxMemberSize < 1) {
                    maxMemberSize = Channel.DEF_MAX_MEMBER_SIZE;
                    Logger.log(LT.CHANNEL, "채널 (" + id + ") : " + Logger.RED + "maxMemberSize는 1보다 작을 수 없습니다! (신규 설정값: " + Channel.DEF_MAX_MEMBER_SIZE + ")");
                }
                boolean enableWhiteList = getConfig().getBoolean(v + ".enableWhiteList");
                Channel channel = new Channel(Integer.parseInt(id), maxMemberSize, enableWhiteList);
                if (enableWhiteList) {
                    List<String> whiteList = getConfig().getStringList(v + ".whiteList");
                    if (!whiteList.isEmpty())
                        channel.setWhiteList(whiteList.stream().filter(f -> f.length() > 25).map(UUID::fromString).toList());
                }
                if (getConfig().getStringList(v + ".blackList").size() != 1)
                    channel.setBlackList(getConfig().getStringList(v + ".blackList").stream().filter(f -> f.length() > 25).map(UUID::fromString).toList());
                Channel.CHANNELS.put(Integer.parseInt(id), channel);
                Logger.log(LT.CHANNEL, "채널 (" + id + ") 을(를) 로드했습니다.");
            });
        }
    }

    private void registerPackets() {
        if (getServer().getPluginManager().getPlugin("ProtocolLib") != null) {
            this.protocolManager = ProtocolLibrary.getProtocolManager();
            this.entityPacket = new EntityPacket(this, EntityPacket.Policy.BLACKLIST);
//            protocolManager.addPacketListener(new EntityBreakPacket(this));
            protocolManager.addPacketListener(new ServerListPingPacket(this));
//        protocolManager.addPacketListener(new TabListPacket(this));
        } else Logger.exc(LT.PACKET, "ProtocolLib이 로드되지 않았습니다!");
    }

    public static MPS getInstance() {
        return instance;
    }

    private void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        try {
            InputStream is = getResource("config.yml");
            if (is != null) {
                YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(is));
                ConfigurationSection config = defConfig.getConfigurationSection("");
                if (config != null) {
                    for (String key : config.getKeys(true)) {
                        if (!getConfig().contains(key)) {
                            getConfig().set(key, defConfig.get(key));
                            Logger.log(LT.CONFIGURATION, Logger.YELLOW + "메인 구성 파일에서 (" + key + ") 이(가) 존재하지 않아 추가되었습니다! (" + defConfig.get(key) + ")");
                        }
                    }
                }
                saveConfig();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.equations = new Equations(this);
    }

    private void registerAndUpdateForItems(Item... items) {

    }

    public HolographicDisplaysAPI getHolographicDisplaysAPI() {
        return holographicDisplaysAPI;
    }

    public ProtocolManager getProtocolManager() {
        return protocolManager;
    }

    public Equations getEquations() {
        return equations;
    }

    public EntityPacket getEntityPacket() {
        return entityPacket;
    }

    public PaperCommandManager getPaperCommandManager() {
        return paperCommandManager;
    }

    public AnotherLibrary getAnotherLibrary() {
        return anotherLibrary;
    }

    public PlayerCache getPlayerCache() {
        return playerCache;
    }

    public ItemCache getItemCache() {
        return itemCache;
    }

    public MonsterDB getMonsterCache() {
        return monsterCache;
    }

    public DatabaseConnect getDatabaseConnect() {
        return databaseConnect;
    }

    public BukkitAudiences getBukkitAudiences() {
        return bukkitAudiences;
    }
}
