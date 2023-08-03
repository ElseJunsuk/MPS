package com.anotherspectrum.smps.api.player.type;

@Deprecated
public enum Title {

    NONE("없음"),

    SEED("새싹", "당신의 무한한 성장을 기대합니다.", -1L),
    LOADER("개척자", "", -1L),
    TRAVELER("여행가", "", -1L),
    HUNTER("사냥꾼", "", -1L),

    LIGHT("빛", "", 50L),
    VETERAN("베테랑", "", 50L),
    COLLECTOR("수집가", "", 50L),

    KILLER("학살", "", 100L),
    REVOLUTION("혁명", "", 100L),
    DESTINY("운명", "", 100L)
    ;

    private String name;
    private String description;
    private Long levelLimit;

    Title(String name) {
        this.name = name;
    }

    Title(String name, String description, Long levelLimit) {
        this.name = name;
        this.description = description;
        this.levelLimit = levelLimit;
    }

    public String getName() {
        return name;
    }
}
