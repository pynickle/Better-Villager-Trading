package com.euphony.better_villager_trading.fabric;

import com.euphony.better_villager_trading.PlatformUtils;
import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

public class PlatformUtilsImpl implements PlatformUtils {
    public static Path getConfigPath() {
        return FabricLoader.getInstance().getConfigDir();
    }
}
