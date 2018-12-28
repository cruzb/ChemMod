package com.bradcruz.chemmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {
    public static BlockBase oreCopper = new BlockBase("ore_copper", Material.ROCK);


    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(oreCopper);
    }

    public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemBlock(oreCopper).setRegistryName(oreCopper.getRegistryName()));
    }


    @SideOnly(Side.CLIENT)
    public static void initModels() {
        oreCopper.initModel();
    }
}
