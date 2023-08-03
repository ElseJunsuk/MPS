package com.anotherspectrum.smps.api.item.type;

public enum ItemType {

    ARMOR("방어구", true),
    WEAPON("무기", true),
    CHARM("부적", true),
    DROPS("전리품", false),
    TITLE("칭호", true),
    RUNE("룬", true),
    RING("반지", true),
    USE("사용", false),
    DUMMY("기타", false);

    private String name;
    private boolean isEquipment;

    ItemType(String name, boolean isEquipment) {
        this.name = name;
        this.isEquipment = isEquipment;
    }

    public String getName() {
        return name;
    }

    public boolean isEquipment() {
        return isEquipment;
    }
}
