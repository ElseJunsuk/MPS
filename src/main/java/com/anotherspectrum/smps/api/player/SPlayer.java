package com.anotherspectrum.smps.api.player;

import com.anotherspectrum.smps.api.channel.Channel;
import com.anotherspectrum.smps.api.item.Item;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Date;

/**
 * Sententia 플레이어의 데이터 인터페이스입니다.
 * 해당 클래스의 구현부는 공개되지 않습니다.
 * <p>
 * DB에 등록된 플레이어의 스테이터스, 화폐, 장비 등을 관리할 수 있습니다.
 */
public interface SPlayer extends Status, Economy, Equipment {

    // GETTER

    String getLastLogIn();

    String getLastLogOut();

    Location getLastLocation();

    Channel getChannel();

    Match getMatch();

    void giveItem(Item item, int amount);

    boolean checkItem(Item item);

    Player getPlayer();

    Option getOptions();

    // SETTER

    void setLastLogin(Date date);

    void setLastLogOut(Date date);

    void setLastLogin(String date);

    void setLastLogOut(String date);

    void setLastLocation(Location location);

    void setMatch(Match match);

    // Additional

    boolean isBanned();

    void ban(String reason);

    void ban(String reason, Date time);

    String getBanReason();

    String getBanTime();

    // OPTIONS

    void setOption(Option option);

    // TO STRING

    @Override
    String toString();

    /**
     * 해당 플레이어의 데이터가 유효한지 확인합니다.
     *
     * @param sPlayer 타겟 플레이어
     * @return 유효하면 true, 유효하지 않으면 false
     */
    static boolean isValid(SPlayer sPlayer) {
        return sPlayer != null;
    }

}
