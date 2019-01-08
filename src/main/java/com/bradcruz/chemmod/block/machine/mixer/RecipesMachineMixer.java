package com.bradcruz.chemmod.block.machine.mixer;

import com.bradcruz.chemmod.block.machine.RecipesMachineBase;
import com.bradcruz.chemmod.item.ModItems;

import com.bradcruz.chemmod.util.interfaces.IRecipeFactory;
import net.minecraft.item.ItemStack;

public class RecipesMachineMixer extends RecipesMachineBase implements IRecipeFactory {

    private static final RecipesMachineMixer INSTANCE = new RecipesMachineMixer();


    public static RecipesMachineMixer getInstance() {
        return INSTANCE;
    }

    private RecipesMachineMixer() {
        addRecipe(new ItemStack(ModItems.acid), new ItemStack(ModItems.hubflower), new ItemStack(ModItems.jet), 5f);
    }

}
