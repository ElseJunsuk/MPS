package com.anotherspectrum.smps.api.match.type;

public enum MatchType {

    ONE_ONE("1 VS 1", 2),
    TWO_TWO("2 VS 2", 4),

    MANY("다중 전투", -1);

    private String name;

    private int maximumPlayer;

    /**
     * 해당 열거형 클래스에 객체를 정의합니다.
     *
     * @param name 매치 이름
     * @param maximumPlayer 최대 수용 플레이어 (-1의 경우, 제한이 없음.)
     */
    MatchType(String name, int maximumPlayer) {
        this.name = name;
        this.maximumPlayer = maximumPlayer;
    }

    public String getName() {
        return name;
    }

    public int getMaximumPlayer() {
        return maximumPlayer;
    }
}
