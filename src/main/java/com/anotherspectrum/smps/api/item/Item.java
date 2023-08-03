package com.anotherspectrum.smps.api.item;

import com.anotherspectrum.anotherlibrary.menu.ItemCreator;
import com.anotherspectrum.anotherlibrary.utils.StringUtil;
import com.anotherspectrum.smps.MPS;
import com.anotherspectrum.smps.api.item.type.Element;
import com.anotherspectrum.smps.api.item.type.Equipment;
import com.anotherspectrum.smps.api.item.type.ItemType;
import com.anotherspectrum.smps.api.item.type.Rate;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

/**
 * 서버의 아이템 제작에 관련된 인터페이스입니다.
 */
public interface Item {

    // GETTERS

    String id();

    /**
     * @return 해당 아이템의 착용 부위 ({@link Equipment} 참조)
     */
    Equipment getEquipment();

    /**
     * @return 해당 아이템의 등급 ({@link Rate} 참조)
     */
    Rate getRate();

    /**
     * @return 해당 아이템의 잠재능력 ({@link Potential} 참조)
     */
    Potential getPotential();

    /**
     * @return 해당 아이템의 스킬 ({@link Skill} 참조)
     */
    Skill getSkill();

    /**
     * @return 해당 아이템에 부여된 속성 ({@link Element} 참조)
     */
    Element getElement();

    /**
     * @return 해당 아이템이 강화된 횟수
     */
    Integer getGradeNumber();

    /**
     * @return 해당 아이템의 설정 이름
     */
    String getItemName();

    /**
     * @return 해당 아이템의 설정 설명 (로어)
     */
    String getDescription();

    /**
     * @return 해당 아이템의 리소스 ID
     */
    int getResourceId();

    /**
     * @return 해당 아이템의 상점 판매 시 가격
     */
    Long getPrice();

    /**
     * @return 해당 아이템 사용 가능 레벨 제한
     */
    Long getLevelLimit();

    /**
     * @return 해당 아이템에 인첸트 효과가 부여되어 있는가
     */
    boolean isGlowing();

    /**
     * @return 해당 아이템이 유저간 거래가 가능한 아이템인가
     */
    boolean isTradeAllowed();

    /**
     * @return 아이템의 {@link ItemType} 타입
     */
    ItemType getItemType();

    /**
     * @return 아이템의 {@link Material} 타입
     */
    Material getItemMaterial();

    /**
     * @return 아이템의 귀속 상세 ({@link SoulBinding} 참조)
     */
    SoulBinding soulBinding();

    // SETTERS

    Item setItemName(String name);

    Item setDescription(String description);

    Item setResourceId(int id);

    Item setPrice(Long price);

    Item setLevelLimit(Long levelLimit);

    Item setGlowing(boolean b);

    Item setTradeAllowed(boolean b);

    Item setItemType(ItemType itemType);

    Item setItemMaterial(Material material);

    Item setSoulBinding(SoulBinding soulBinding);

    Item setEquipment(Equipment equipment);

    Item setRate(Rate rate);

    Item setPotential(Potential potential);

    Item setSkill(Skill skill);

    Item setElement(Element element);

    Item setGradeNumber(Integer gradeNumber);

    /**
     * 만들어진 {@link Item} 아이템을 {@link ItemStack} 으로 형변환 합니다.
     *
     * @return {@link org.bukkit.persistence.PersistentDataContainer} 가 추가된 {@link ItemStack}
     */
    default ItemStack toItemStack() {
        return toItemStack(1);
    }

    /**
     * 만들어진 {@link Item} 아이템을 {@link ItemStack} 으로 형변환 합니다.
     *
     * @param amount 반환할 {@link ItemStack} 아이템 갯수
     * @return {@link org.bukkit.persistence.PersistentDataContainer} 가 추가된 {@link ItemStack}
     */
    default ItemStack toItemStack(int amount) {
        ItemStack itemStack = ItemCreator.create(getItemMaterial(), amount, StringUtil.format(getItemName()),
                StringUtil.ellipsis(getDescription().split("\n")), true, false);
        ItemMeta meta = itemStack.getItemMeta();
        meta.getPersistentDataContainer().set(new NamespacedKey(MPS.getInstance(), "itemId"), PersistentDataType.STRING, id());
        meta.getPersistentDataContainer().set(new NamespacedKey(MPS.getInstance(), "equip_"), PersistentDataType.STRING, getEquipment().name());
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    @Override
    String toString();

}
