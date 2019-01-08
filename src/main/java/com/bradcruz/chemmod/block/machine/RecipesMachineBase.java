package com.bradcruz.chemmod.block.machine;

import com.bradcruz.chemmod.block.machine.mixer.RecipesMachineMixer;
import com.bradcruz.chemmod.item.ModItems;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import net.minecraft.item.ItemStack;

import java.util.Map;

public class RecipesMachineBase {

    //protected static final RecipesMachineBase INSTANCE = new RecipesMachineBase();
    protected final Table<ItemStack, ItemStack, ItemStack> recipeList = HashBasedTable.<ItemStack, ItemStack, ItemStack>create();
    protected final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();

    //public static RecipesMachineBase getInstance() {
    //    return INSTANCE;
    //}

    public RecipesMachineBase() {
        //addMachineMixerRecipe(new ItemStack(ModItems.acid), new ItemStack(ModItems.hubflower), new ItemStack(ModItems.jet), 5f);
    }




    public void addRecipe(ItemStack input1, ItemStack input2, ItemStack result, float experience) {
        if(getResult(input1, input2) != ItemStack.EMPTY) return;
        this.recipeList.put(input1, input2, result);
        this.experienceList.put(result, Float.valueOf(experience));
    }


    public ItemStack getResult(ItemStack input1, ItemStack input2) {
        for(Map.Entry<ItemStack, Map<ItemStack, ItemStack>> entry : this.recipeList.columnMap().entrySet()) {
            if(this.compareItemStacks(input1, (ItemStack)entry.getKey())) {
                for(Map.Entry<ItemStack, ItemStack> ent: entry.getValue().entrySet()) {
                    if(this.compareItemStacks(input2, (ItemStack)ent.getKey()))
                        return (ItemStack)ent.getValue();
                }
            }
        }
        return ItemStack.EMPTY;
    }

    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2) {
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }

    public Table<ItemStack, ItemStack, ItemStack> getRecipeList() {
        return this.recipeList;
    }

    public float getRecipeExperience(ItemStack stack) {
        for(Map.Entry<ItemStack, Float> entry : this.experienceList.entrySet()) {
            if(this.compareItemStacks(stack, (ItemStack)entry.getKey()))
                return ((Float)entry.getValue()).floatValue();
        }
        return 0f;
    }
}
