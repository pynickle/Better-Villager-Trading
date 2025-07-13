package com.euphony.better_villager_trading.neoforge;

import com.euphony.better_villager_trading.PlatformUtils;
import net.neoforged.fml.loading.FMLPaths;

import java.nio.file.Path;

public class PlatformUtilsImpl implements PlatformUtils {
    public static Path getConfigPath() {
        return FMLPaths.CONFIGDIR.get();
    }
}
