package net.meme2001.farmsimmod;

import net.meme2001.farmsimmod.item.Moditems;
import net.meme2001.farmsimmod.networking.ModPacket;
import net.meme2001.farmsimmod.networking.packet.DaysC2SPacket;
import net.meme2001.farmsimmod.networking.packet.chestinfoC2SPacket;
import net.minecraft.client.gui.screens.inventory.ContainerScreen;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.event.ContainerScreenEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = Farmsimmod.MODID)

    public static class ForgeEvents {
        BlockPos b = new BlockPos(1, 1, 1);


        @SubscribeEvent
        public static void onLivingHurt(LevelEvent event) {

            if (event.getLevel() instanceof Level level) {
                long day = level.getDayTime() % 72002;
                long l = level.getLevelData().getDayTime() % 72000;
                day *= 3;


                if (day > 72000) {


                    ModPacket.SendToSever(new DaysC2SPacket());


                } else {
                    event.setCanceled(true);
                    event.isCanceled();

                }
            }
        }




        }




        }




