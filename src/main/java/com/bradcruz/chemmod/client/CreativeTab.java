package com.bradcruz.chemmod.client;

import com.bradcruz.chemmod.Main;
import com.bradcruz.chemmod.item.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTab extends CreativeTabs {

    public CreativeTab(){
        super(Main.MODID);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModItems.nukacola);
    }
}
