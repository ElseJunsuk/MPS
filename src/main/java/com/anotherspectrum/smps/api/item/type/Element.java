package com.anotherspectrum.smps.api.item.type;

public enum Element {

    NONE("무", "#BBB0B0"),
    FIRE("불", "#BB4435"),
    WIND("바람", "#39BB76"),
    WATER("물", "#0C8CBB"),
    EARTH("대지", "#BB8018"),
    LIGHTNING("전기", "#BABB00"),
    BRIGHTNESS("빛", "white"),
    DARKNESS("어둠", "#5D3F8E");

    private final String name;
    private final String symbolColor;

    Element(String name, String symbolColor) {
        this.name = name;
        this.symbolColor = symbolColor;
    }

    public String getName() {
        return name;
    }

    public String getSymbolColor() {
        return symbolColor;
    }
}
