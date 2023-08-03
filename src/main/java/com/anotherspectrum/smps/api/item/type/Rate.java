package com.anotherspectrum.smps.api.item.type;

public enum Rate {

    SENION(1),
    TERION(2),
    EDION(3),
    NEWON(4),
    TIA(5),
    NONE(6);

    private final int priority;

    Rate(int priority) {
        this.priority = priority;
    }

    /**
     * 전자와 후자의 등급 순위를 비교하여
     * 둘 중 더 높은 등급을 반환합니다.
     *
     * @param target 전자
     * @param equals 후자
     * @return 더 높은 등급
     */
    public static Rate comparison(Rate target, Rate equals) {
        Rate rate = null;
        if (target.getPriority() > equals.getPriority()) {
            rate = target;
        }
        return rate;
    }

    public int getPriority() {
        return priority;
    }
}
