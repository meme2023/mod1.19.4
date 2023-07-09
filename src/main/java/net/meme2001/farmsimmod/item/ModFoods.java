package net.meme2001.farmsimmod.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class ModFoods  {
    public static final FoodProperties TOMTEO = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.2F).build();
    public static final FoodProperties Strewberry = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.2F).build();

    public static final FoodProperties ROTTEN_TOMTEO = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.2F).effect(new MobEffectInstance(MobEffects.POISON, 400, 2), 0.6F).effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 400, 2), 0.6F).build();



}
