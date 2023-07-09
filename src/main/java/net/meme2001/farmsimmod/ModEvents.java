package net.meme2001.farmsimmod;

import net.meme2001.farmsimmod.block.ModBlock;
import net.meme2001.farmsimmod.block.entity.ModBlokEntity;
import net.meme2001.farmsimmod.item.Moditems;
import net.meme2001.farmsimmod.networking.ModPacket;
import net.meme2001.farmsimmod.networking.packet.DaysC2SPacket;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockEventData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.player.PlayerContainerEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.awt.event.ContainerEvent;
import java.util.Set;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = Farmsimmod.MODID)

    public static class ForgeEvents {
        @SubscribeEvent
        public static void onLivingHurt(LevelEvent event) {

                if (event.getLevel()instanceof Level level) {
                    long day =level.getDayTime()%72002;
                    long l = level.getLevelData().getDayTime() % 72000;
                    day*=3;


                    if(day>72000) {


                        ModPacket.SendToSever(new DaysC2SPacket());


                    }
                    else
                        event.isCanceled();

                }
            }
            @SubscribeEvent
        public static void frige(PlayerContainerEvent event) {


            if(event.getEntity().containerMenu != null) {
                if(event.getContainer().getItems().contains(Moditems.TOMATEOS.get())){
                    event.getEntity().getLevel().getLevelData();

                    event.getContainer().getItems().contains(Moditems.TOMATEOS.get());
                    ModPacket.SendToSever(new DaysC2SPacket());


                }

            }

        }
        }

        }

