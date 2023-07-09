package net.meme2001.farmsimmod.item;

import net.meme2001.farmsimmod.Farmsimmod;
import net.meme2001.farmsimmod.block.ModBlock;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;

public class Moditems extends Foods {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Farmsimmod.MODID);
    public static final RegistryObject<Item> TOMATEOS = ITEMS.register("tomateo",() -> new Item(new Item.Properties().food(ModFoods.TOMTEO)));
    public static final RegistryObject<Item> Strewberry = ITEMS.register("strewberry",() -> new Item(new Item.Properties().food(ModFoods.Strewberry)));
    public static final RegistryObject<Item> TOMATEO_SEED  = ITEMS.register("tomateo_seed",() -> new ItemNameBlockItem(ModBlock.TOMATEAO_CROP.get(),new Item.Properties()));
    public static final RegistryObject<Item> WOODEN_FRIDGE = ITEMS.register("wooden_fridge",() -> new ItemNameBlockItem(ModBlock.WOODEN_FRIDAGE .get(),new Item.Properties()));
    public static final RegistryObject<Item> STRAWBERRY_SEED  = ITEMS.register("strawberry_seed",() -> new ItemNameBlockItem(ModBlock.STRAWBERRY_CROP.get(),new Item.Properties()));
    public static final RegistryObject<Item> ROTTEN_TOMATEOS = ITEMS.register("rotten_tomateo",() -> new Item(new Item.Properties().food(ModFoods.ROTTEN_TOMTEO)));




    public static void register (IEventBus eventBus){
        ITEMS.register(eventBus);

    }






}
