package com.euphony.better_villager_trading.fabric;

import com.euphony.better_villager_trading.BetterVillagerTrading;
import net.fabricmc.api.ModInitializer;

public final class BetterVillagerTradingFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        BetterVillagerTrading.init();
    }
}
