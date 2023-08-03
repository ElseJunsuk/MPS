package com.anotherspectrum.smps.api.player;

import com.anotherspectrum.smps.api.match.type.Rank;

public interface Match {

    // GETTERS

    Rank getRank();

    int getRankScore();

    // SETTERS

    void setRank(Rank rank);

    void setRankScore(int score);

    @Override
    String toString();

}
