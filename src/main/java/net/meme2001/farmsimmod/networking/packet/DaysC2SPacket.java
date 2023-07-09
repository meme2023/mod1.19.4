package net.meme2001.farmsimmod.networking.packet;


import com.mojang.authlib.minecraft.client.MinecraftClient;
import net.meme2001.farmsimmod.item.Moditems;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.network.NetworkEvent;

import java.util.ArrayList;
import java.util.function.Supplier;



public class DaysC2SPacket {
    boolean age = true;
    ArrayList<ItemStack> food = new ArrayList<>();



    private static final String MESSAGE_IS_Rotten = "message.farmsimmod.isRotten";


    public DaysC2SPacket() {

    }

    public DaysC2SPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // HERE WE ARE ON THE SERVER!
            ServerPlayer player = context.getSender();
            ServerLevel level = context.getSender().getLevel();
            Inventory in = context.getSender().getInventory();
            AbstractContainerMenu fir= context.getSender().containerMenu;



            if (player.getInventory().contains(new ItemStack(Moditems.TOMATEOS.get()))&&age==true) {
                player.getInventory().add((new ItemStack(Moditems.STRAWBERRY_SEED.get())));
                int i=  player.getInventory().findSlotMatchingItem(new ItemStack(Moditems.TOMATEOS.get()));
                player.getInventory().removeItemNoUpdate(i);
                age=false;


            }

        });

        return true;
    }



}



