package com.anotherspectrum.smps.api.match;

import com.anotherspectrum.smps.api.match.type.MatchType;
import com.anotherspectrum.smps.api.player.SPlayer;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public interface MatchMaking {

    Queue<MatchMaking> MATCHES = new LinkedList<>();

    MatchType getMatchType();

    SPlayer[] getPlayers();

    int getMaximumPlayerSize();

    // SETTERS

    MatchMaking setMatchType(MatchType matchType);

    MatchMaking setPlayers(SPlayer[] players);

    MatchMaking setPlayers(List<SPlayer> players);

    MatchMaking setMaximumPlayerSize(int size);

    default void start() {

    }

}
