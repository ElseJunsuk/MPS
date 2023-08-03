package com.anotherspectrum.smps.api.match.type;

public enum Rank {

    NONE("없음", 0),

    IBMUN("입문생", 1, 100),
    GYUNSUP("견습생", 2, 250),
    SUKRYUN("숙련자", 3, 500),

    TUSA("투사", 4, 800),
    JANGGUN("장군", 5, 1100),

    SHINSUNG("신성", 6, 1500),
    MYUNGWANG("명왕", 7, 2000);

    private String name;

    private int priority;

    private int requireScore;

    Rank(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    Rank(String name, int priority, int requireScore) {
        this.name = name;
        this.priority = priority;
        this.requireScore = requireScore;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public int getRequireScore() {
        return requireScore;
    }
}
