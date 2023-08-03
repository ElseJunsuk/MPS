package com.anotherspectrum.smps.api.item.type;

public enum PotentialList {

    ADD_DEF_IGNORE("강타", false, Equipment.WEAPON),
    ADD_OPEN_FIELD_DAMAGE("자연 추가 데미지", false, Equipment.WEAPON),
    ADD_OPEN_FIELD_BOSS_ATK_DAMAGE("자연의 주인 추가 데미지", false, Equipment.WEAPON),

    ADD_CRITICAL("치명타 확률", true, Equipment.CHESTPLATE),
    ADD_CRITICAL_DAMAGE("치명타 데미지", true, Equipment.CHESTPLATE),

    ADD_ELEMENT_PLUS_DAMAGE("속성 추가 데미지", false),

    ADD_CONVERSATION("흥정", true, Equipment.HELMET),

    ADD_SEN_DROP_PERCENTAGE("센 획득률", true),
    ADD_ITEM_DROP_PERCENTAGE("전리품 획득률", true);

    private String name;
    private boolean isPercentage;
    private Equipment[] onlyEquipment;

    PotentialList(String name, boolean isPercentage) {
        this.name = name;
        this.isPercentage = isPercentage;
        this.onlyEquipment = new Equipment[]{Equipment.NONE};
    }

    PotentialList(String name, boolean isPercentage, Equipment... onlyEquipment) {
        this.name = name;
        this.isPercentage = isPercentage;
        this.onlyEquipment = onlyEquipment;
    }

    public String getPerName(int value) {
        return "+ " + value + (isPercentage ? "% " : " ") + name;
    }

    public String getName() {
        return name;
    }

    public boolean isPercentage() {
        return isPercentage;
    }

    public Equipment[] getOnlyEquipment() {
        return onlyEquipment;
    }
}
