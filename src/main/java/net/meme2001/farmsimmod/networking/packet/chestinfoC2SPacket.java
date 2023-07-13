package net.meme2001.farmsimmod.networking.packet;

import net.meme2001.farmsimmod.item.Moditems;
import net.minecraft.ChatFormatting;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraftforge.network.NetworkEvent;

import java.util.ArrayList;
import java.util.Properties;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class chestinfoC2SPacket {


    boolean age = true;
    ArrayList<ItemStack> food = new ArrayList<>();


    private static final String MESSAGE_IS_Rotten = "message.farmsimmod.isRotten";


    public chestinfoC2SPacket() {

    }

    public chestinfoC2SPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }


    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // HERE WE ARE ON THE SERVER!
            ServerPlayer serverPlayerer = context.getSender();
            ServerLevel serverLevel = context.getSender().getLevel();
            Inventory in = context.getSender().getInventory();

            if (haschest(serverPlayerer, serverLevel, 2)) {

                serverPlayerer.sendSystemMessage(Component.translatable(MESSAGE_IS_Rotten).withStyle(ChatFormatting.DARK_PURPLE));
                if(serverPlayerer.containerMenu.getItems().equals(Moditems.TOMATEOS)) {

                    System.out.println("Found");
                }


            }


        });

        return true;
    }

    private boolean haschest(ServerPlayer player, Level level, int sixe) {
        return level.getBlockStates(player.getBoundingBox().inflate(sixe))
                .filter(state -> state.is(Blocks.CHEST)).toArray().length > 0;


    }
}
