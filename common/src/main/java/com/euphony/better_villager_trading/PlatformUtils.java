package com.euphony.better_villager_trading;

import dev.architectury.injectables.annotations.ExpectPlatform;

import java.nio.file.Path;

public interface PlatformUtils {
    @ExpectPlatform
    static Path getConfigPath() {
        throw new AssertionError();
    };
}
