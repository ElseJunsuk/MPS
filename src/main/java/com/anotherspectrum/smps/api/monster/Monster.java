package com.anotherspectrum.smps.api.monster;

import com.anotherspectrum.anotherlibrary.utils.StringUtil;
import com.anotherspectrum.smps.MPS;
import com.anotherspectrum.smps.api.item.Item;
import com.anotherspectrum.smps.api.item.type.Element;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.persistence.PersistentDataType;

public interface Monster {

    String id();

    // GETTERS

    Double getMaxHealth();

    EntityType getEntityType();

    Long getLevel();

    String getDisplayName();

    String getDescription();

    Element getElement();

    /**
     * index에 따른 착용 부위는 다음과 같습니다.:
     * <li>0 - Off hand</li>
     * <li>1 - Main hand</li>
     * <li>2 - Helmet</li>
     * <li>3 - Chestplate</li>
     * <li>4 - Leggings</li>
     * <li>5 - Boots</li>
     *
     * @return 몬스터가 착용중인 아이템 {@link Item}[]
     */
    Item[] getEquipments();

    Drop getDrops();

    boolean isGlowing();

    boolean isBaby();

    // And, potion effects ... more etc.

    // SETTERS

    void setEntityType(EntityType entityType);

    void setLevel(Long level);

    void setDisplayName(String name);

    void setDescription(String description);

    void setElement(Element element);

    void setEquipments(Item[] items);

    void setDrops(Drop drop);

    void setGlowing(boolean glowing);

    void setBaby(boolean b);

    /**
     * 만들어진 {@link Monster} 몬스터를 서버의 {@link Entity} 로 스폰합니다.
     *
     * @param world    타겟 월드
     * @param location 스폰 {@link Location}
     * @return {@link Entity}
     */
    default Entity spawnEntity(World world, Location location) {
        Entity entity = world.spawnEntity(location, getEntityType());
        final NamespacedKey idNamespacedKey = new NamespacedKey(MPS.getInstance(), "monsterId");
        if (entity instanceof LivingEntity livingEntity) {
            livingEntity.getPersistentDataContainer().set(idNamespacedKey, PersistentDataType.STRING, id());
            livingEntity.customName(StringUtil.format(getDisplayName()));
            livingEntity.setCustomNameVisible(true);
            livingEntity.setCollidable(false);
            return livingEntity;
        }
        entity.getPersistentDataContainer().set(idNamespacedKey, PersistentDataType.STRING, id());
        return entity;
    }

}
