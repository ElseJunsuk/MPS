package com.anotherspectrum.smps.api.player;

public interface Option {

    // GETTERS

    boolean isOptionChatTitleEnabled();

    boolean isOptionChatRankEnabled();

    boolean isOptionChatRankToScoreEnabled();

    String getOptionChatColor();

    // SETTERS

    Option setOptionChatTitleEnabled(boolean b);

    Option setOptionChatRankEnabled(boolean b);

    Option setOptionChatRankToScoreEnabled(boolean b);

    Option setOptionChatColor(String color);

    @Override
    String toString();

}
