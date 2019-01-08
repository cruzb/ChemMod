package com.bradcruz.chemmod.block.machine.boiler;

import com.bradcruz.chemmod.block.machine.RecipesMachineBase;
import com.bradcruz.chemmod.item.ModItems;
import com.bradcruz.chemmod.util.interfaces.IRecipeFactory;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;


public class RecipesMachineBoiler extends RecipesMachineBase implements IRecipeFactory {

    private static final RecipesMachineBoiler INSTANCE = new RecipesMachineBoiler();

    public static RecipesMachineBoiler getInstance() {
        return INSTANCE;
    }

    private RecipesMachineBoiler() {
        addRecipe(new ItemStack(Items.WATER_BUCKET), new ItemStack(Items.ROTTEN_FLESH), new ItemStack(ModItems.blood), 5f);
        addRecipe(new ItemStack(Items.WATER_BUCKET), new ItemStack(Items.SPIDER_EYE), new ItemStack(ModItems.acid), 5f);
    }

}
