package com.bradcruz.chemmod.block;

import com.bradcruz.chemmod.Main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBase extends Block {

    private String name;

    public BlockBase(String name, Material material) {
        super(material);
        this.name = name;

        setUnlocalizedName(Main.MODPREFIX + name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.MATERIALS);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
