package com.euphony.better_villager_trading.fabric.client;

import com.euphony.better_villager_trading.event.TradingHudEvent;
import com.euphony.better_villager_trading.renderer.TradingHudRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

public final class BetterVillagerTradingFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_WORLD_TICK.register(TradingHudEvent::clientLevelPost);
        HudRenderCallback.EVENT.register(TradingHudRenderer::renderHud);
    }
}
