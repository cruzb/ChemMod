package com.bradcruz.chemmod.item.crop;

import com.bradcruz.chemmod.Main;
import com.bradcruz.chemmod.block.ModBlocks;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemSeedBrainfungus extends ItemSeeds {

    public ItemSeedBrainfungus(String name) {
        super(ModBlocks.cropBrainFungus, Blocks.STONE);
        setUnlocalizedName(Main.MODPREFIX + name);
        setRegistryName(name);

        MinecraftForge.addGrassSeed(new ItemStack(this), 8);

        setCreativeTab(Main.creativeTab);
    }


    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));

    }
}
