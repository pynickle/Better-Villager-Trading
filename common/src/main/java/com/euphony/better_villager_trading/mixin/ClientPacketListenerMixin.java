package com.euphony.better_villager_trading.mixin;

import com.euphony.better_villager_trading.event.TradingHudEvent;
import com.euphony.better_villager_trading.utils.data.MerchantInfo;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.network.protocol.game.ClientboundMerchantOffersPacket;
import net.minecraft.network.protocol.game.ClientboundOpenScreenPacket;
import net.minecraft.network.protocol.game.ServerboundContainerClosePacket;
import net.minecraft.world.inventory.MenuType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.euphony.better_villager_trading.BetterVillagerTrading.config;

/**
 * 客户端数据包监听器混入类，用于处理交易相关的数据包
 */
@Mixin(ClientPacketListener.class)
public class ClientPacketListenerMixin {

    /**
     * 处理商人交易报价数据包
     * @param packet 商人交易报价数据包
     * @param ci 回调信息
     */
    @Inject(at = @At("HEAD"), method = "handleMerchantOffers", cancellable = true)
    public void onHandleMerchantOffers(ClientboundMerchantOffersPacket packet, CallbackInfo ci) {
        if(!config.enableTradingHud) return;

        MerchantInfo.getInstance().setOffers(packet.getOffers());

        if (!TradingHudEvent.isWindowOpen()) {
            ci.cancel();
        }
    }

    /**
     * 处理打开界面数据包
     * @param packet 打开界面数据包
     * @param ci 回调信息
     */
    @Inject(at = @At("HEAD"), method = "handleOpenScreen", cancellable = true)
    public void onHandleOpenScreen(ClientboundOpenScreenPacket packet, CallbackInfo ci) {
        if(!config.enableTradingHud) return;

        if (!TradingHudEvent.isWindowOpen() && packet.getType() == MenuType.MERCHANT) {
            ci.cancel();
            better_villager_trading$closeContainer(packet.getContainerId());
        }
    }

    /**
     * 关闭容器
     * @param containerId 容器ID
     */
    @Unique
    private void better_villager_trading$closeContainer(int containerId) {
        if (!config.enableTradingHud) return;

        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player != null) {
            minecraft.player.connection.send(new ServerboundContainerClosePacket(containerId));
        }
    }
}
