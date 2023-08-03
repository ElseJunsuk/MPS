package com.anotherspectrum.smps.api.player;

import com.anotherspectrum.smps.api.item.Item;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

/**
 * 플레이어가 '착용 중인' 아이템을 불러옵니다.
 */
public interface Equipment {

    // GETTERS

    /**
     * 해당 플레이어가 착용중인 모든 아이템을 불러옵니다.
     *
     * @return Array {@link Item}
     */
    Item[] getEquipmentItems();

    /**
     * 해당 플레이어가 착용중인 특정 부위의 아이템을 불러옵니다.
     *
     * @return {@link Item}
     */
    Item getEquipmentItem(com.anotherspectrum.smps.api.item.type.Equipment equipment);

    // SETTERS

    /**
     * 해당 플레이어의 장비를 설정합니다.
     *
     * @param id        ItemDB에 등록된 {@link Item} 아이템의 ID (null 인 경우 해당 슬롯이 비워짐.)
     * @param equipment 설정 부위
     */
    void setEquipmentItem(@Nullable String id, com.anotherspectrum.smps.api.item.type.Equipment equipment);

}
