package com.bradcruz.chemmod.recipe;

import com.bradcruz.chemmod.item.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

    //some recipes are in json format and do not appear here

    public static void init() {
        initPotionRecipes();
        initSmeltingRecipes();
        initCustomRecipes();
    }

    private static void initPotionRecipes() {

    }

    private static void initSmeltingRecipes() {
        GameRegistry.addSmelting(Items.ROTTEN_FLESH, new ItemStack(ModItems.acid), 0.5f);
    }

    private static void initCustomRecipes() {

    }
}
