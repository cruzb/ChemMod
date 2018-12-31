package com.bradcruz.chemmod.item;

import com.bradcruz.chemmod.Main;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBase extends Item {

    private String name;

    public ItemBase(String name) {
        this.name = name;

        setUnlocalizedName(Main.MODPREFIX + name);
        setRegistryName(name);
        setCreativeTab(Main.creativeTab);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));

    }
}
