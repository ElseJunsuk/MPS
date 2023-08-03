package com.anotherspectrum.smps.api.item;

import com.anotherspectrum.smps.api.Serializable;
import com.anotherspectrum.smps.api.item.type.PotentialList;

import java.util.Map;

public interface Potential extends Serializable<Potential> {

    // GETTERS

    Map<PotentialList, Number> getPotentials();

    boolean hasPotential();

    // SETTERS

    Potential addPotentials(PotentialList potential, Number value);

}
