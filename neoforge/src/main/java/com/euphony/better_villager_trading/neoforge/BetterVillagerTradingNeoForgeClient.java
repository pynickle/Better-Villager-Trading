package com.euphony.better_villager_trading.neoforge;

import com.euphony.better_villager_trading.BetterVillagerTrading;
import com.euphony.better_villager_trading.event.TradingHudEvent;
import com.euphony.better_villager_trading.renderer.TradingHudRenderer;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RenderGuiEvent;

@EventBusSubscriber(Dist.CLIENT)
@Mod(value = BetterVillagerTrading.MOD_ID, dist = Dist.CLIENT)
public class BetterVillagerTradingNeoForgeClient {
    public BetterVillagerTradingNeoForgeClient() {

    }

    @SubscribeEvent
    public static void post(ClientTickEvent.Post event) {
        TradingHudEvent.clientLevelPost(Minecraft.getInstance().level);
    }

    @SubscribeEvent
    public static void render(RenderGuiEvent.Post event) {
        TradingHudRenderer.renderHud(event.getGuiGraphics(), event.getPartialTick());
    }
}
