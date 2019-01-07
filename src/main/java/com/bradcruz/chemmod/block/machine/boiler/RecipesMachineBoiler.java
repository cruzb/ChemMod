package com.bradcruz.chemmod.block.machine.boiler;

import com.bradcruz.chemmod.item.ModItems;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import java.util.Map;

public class RecipesMachineBoiler {
    private static final RecipesMachineBoiler INSTANCE = new RecipesMachineBoiler();
    private final Table<ItemStack, ItemStack, ItemStack> recipeList = HashBasedTable.<ItemStack, ItemStack, ItemStack>create();
    private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();

    public static RecipesMachineBoiler getInstance() {
        return INSTANCE;
    }

    private RecipesMachineBoiler() {
        addMachineBoilerRecipe(new ItemStack(Items.WATER_BUCKET), new ItemStack(Items.ROTTEN_FLESH), new ItemStack(ModItems.blood), 5f);
    }




    public void addMachineBoilerRecipe(ItemStack input1, ItemStack input2, ItemStack result, float experience) {
        if(getMachineBoilerResult(input1, input2) != ItemStack.EMPTY) return;
        this.recipeList.put(input1, input2, result);
        this.experienceList.put(result, Float.valueOf(experience));
    }


    public ItemStack getMachineBoilerResult(ItemStack input1, ItemStack input2) {
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
