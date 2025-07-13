package com.euphony.better_villager_trading.utils;

import com.euphony.better_villager_trading.BetterVillagerTrading;
import net.minecraft.resources.ResourceLocation;

import java.util.Locale;

public class Utils {
    public static ResourceLocation prefix(String name) {
        return ResourceLocation.fromNamespaceAndPath(BetterVillagerTrading.MOD_ID, name.toLowerCase(Locale.ROOT));
    }
}
