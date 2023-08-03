package com.anotherspectrum.smps.api.player;

import com.anotherspectrum.smps.api.player.type.ExpBoost;
import com.anotherspectrum.smps.api.player.type.Stats;

public interface Status {

    // GETTERS

    Long getLevel();
    Long getMaxExp();
    Long getCurrentExp();

    Integer getStatPoint();
    Integer getSpecificStatPoint(Stats stats);

    // SETTERS

    Status setLevel(Long amount);
    void setMaxExp(Long amount);
    Status setCurrentExp(Long amount);

    Status setStatPoint(Integer amount);
    void setSpecificStatPoint(Stats stats, Integer amount);

    // DEFAULT METHODS

    void applyBoost(ExpBoost expBoost);

    void removeBoost(ExpBoost expBoost);

    default Integer addSpecificStatPoint(Stats stats, Integer value) {
        setSpecificStatPoint(stats, getSpecificStatPoint(stats) + value);
        return getSpecificStatPoint(stats);
    }

    default Integer subtractSpecificStatPoint(Stats stats, Integer value) {
        setSpecificStatPoint(stats, getSpecificStatPoint(stats) - value);
        return getSpecificStatPoint(stats);
    }

    default Integer addStatPoint(Integer value) {
        setStatPoint(getStatPoint() + value);
        return getStatPoint();
    }

    default Integer subtractStatPoint(Integer value) {
        setStatPoint(getStatPoint() - value);
        return getStatPoint();
    }

    default Long addCurrentExp(Long value) {
        setCurrentExp(getCurrentExp() + value);
        return getCurrentExp();
    }

    default Long subtractCurrentExp(Long value) {
        setCurrentExp(getCurrentExp() - value);
        return getCurrentExp();
    }

    default Long addLevel(Long value) {
        setLevel(getLevel() + value);
        return getLevel();
    }

    default Long subtractLevel(Long value) {
        setLevel(getLevel() - value);
        return getLevel();
    }

}
