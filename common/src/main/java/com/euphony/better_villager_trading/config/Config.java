package com.euphony.better_villager_trading.config;

import com.euphony.better_villager_trading.BetterVillagerTrading;
import com.euphony.better_villager_trading.PlatformUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;

import static com.euphony.better_villager_trading.BetterVillagerTrading.config;

public class Config {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path PATH = PlatformUtils.getConfigPath().resolve(BetterVillagerTrading.MOD_ID + ".json");

    public boolean enableTradingHud = true;
    public boolean renderRealCostDirectly = true;
    public boolean enableFastTrading = true;
    public boolean enableAltKey = true;
    public boolean enableDisplayRemainingSales = true;

    private Config() {}

    public static Config create() {
        config = new Config();
        load();
        return config;
    }

    public static void load() {
        if (Files.notExists(PATH)) {
            save();
        } else try {
            config = GSON.fromJson(Files.readString(PATH), Config.class);
        } catch (Exception e) {
            BetterVillagerTrading.LOGGER.error("Couldn't load config file: ", e);
        }
    }

    public static void save() {
        try {
            Files.write(PATH, Collections.singleton(GSON.toJson(config)));
        } catch (Exception e) {
            BetterVillagerTrading.LOGGER.error("Couldn't save config file: ", e);
        }
    }
}
