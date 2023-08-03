package com.anotherspectrum.smps.api.player.type;

import java.util.Locale;

public enum Stats {

    HP("체력", 0),
    ATK("공격력", 1),
    INT("지력", 2),
    DEF("방어력", 3),
    DPI("방어율 무시", 4),
    CRC("크리티컬 확률", 5),
    CRD("크리티컬 데미지", 6),
    AGI("민첩", 7),
    BOSS_ATK("보스 공격력", 8);

    private String name;

    private int id;

    Stats(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return name().toLowerCase(Locale.ROOT);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
