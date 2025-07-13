package com.euphony.better_villager_trading;

import com.euphony.better_villager_trading.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class BetterVillagerTrading {
    public static final String MOD_ID = "better_villager_trading";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static Config config = Config.create();

    public static void init() {
        // Write common init code here.
    }
}
