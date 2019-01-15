package com.bradcruz.chemmod.block.machine.centrifuge;

import com.bradcruz.chemmod.block.machine.RecipesMachineBase;
import com.bradcruz.chemmod.util.interfaces.IRecipeFactory;

public class RecipesMachineCentrifuge extends RecipesMachineBase implements IRecipeFactory {

    private static final RecipesMachineCentrifuge INSTANCE = new RecipesMachineCentrifuge();


    public static RecipesMachineCentrifuge getInstance() {
        return INSTANCE;
    }

    private RecipesMachineCentrifuge() {
        //addRecipe(new ItemStack(ModItems.acid), new ItemStack(ModItems.hubflower), new ItemStack(ModItems.jet), 5f);
    }
}
