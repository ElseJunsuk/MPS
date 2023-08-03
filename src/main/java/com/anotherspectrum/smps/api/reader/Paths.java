package com.anotherspectrum.smps.api.reader;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.Locale;

public enum Paths {

    MONSTER_INFORMATION_NAME(String.class),
    MONSTER_INFORMATION_DESCRIPTION(String.class),
    MONSTER_BOSS_ENABLED(boolean.class),
    MONSTER_LOOT_ITEMS(String.class, true),
    MONSTER_SPAWN_MAXCOUNTLIMIT(int.class),
    MONSTER_SPAWN_SPAWNCOUNT(int.class),
    MONSTER_SPAWN_SPAWING_CLEARED(boolean.class),
    MONSTER_SPAWN_SPAWING_DELAY(long.class),
    MONSTER_SPAWN_LOCATIONS(String.class, true),
    MONSTER_STATUS_LEVEL(long.class),
    MONSTER_STATUS_STATS_TOTALATK(long.class),
    MONSTER_STATUS_STATS_DEFENSIVE(long.class),
    MONSTER_STATUS_STATS_MAXHEALTH(double.class),
    MONSTER_STATUS_STATS_ATKDEFENSIVEIGNORE(double.class),
    MONSTER_STATUS_STATS_ATKSPEED(double.class),
    MONSTER_STATUS_STATS_MAGIC_TOTALMAGICATK(long.class),
    MONSTER_STATUS_STATS_ELEMENTS_BINDING(String.class, true),
    MONSTER_STATUS_STATS_ELEMENTS_ELEMENTDEFENSES(String.class, true),
    MONSTER_STATUS_STATS_ELEMENTS_ELEMENTPOINT(String.class, true),
    MONSTER_STATUS_STATS_EFFECTS_POTIONEFFECTS(String.class, true),
    MONSTER_STATUS_STATS_DETAILS_MOVEMENTSPEED(double.class),
    MONSTER_ATTACK_SPAWN(double.class),
    MONSTER_ATTACK_ATTACKRANGE(double.class),
    MONSTER_SKILLS_SPAWN(String.class, true),
    MONSTER_SKILLS_SCHEDULER(String.class, true);

    private String path = this.name().substring(this.name().indexOf("_") + 1).replace("_", ".").toLowerCase(Locale.ROOT);

    private Class<?> clazz;
    private boolean isList;

    Paths(Class<?> clazz) {
        this.clazz = clazz;
        this.isList = false;
    }

    Paths(Class<?> clazz, boolean isList) {
        this.clazz = clazz;
        this.isList = isList;
    }

    public String getPath() {
        return path;
    }

    public Object cast(FileConfiguration config) {
        if (isList)
            return config.getList(path);
        return config.get(path, clazz);
    }

    public boolean isList() {
        return isList;
    }
}
