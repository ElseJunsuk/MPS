package com.anotherspectrum.smps.api.item;

import com.anotherspectrum.smps.api.player.SPlayer;

public interface SoulBinding {

    SPlayer get();

    void set(SPlayer sPlayer);
    void remove();

}
