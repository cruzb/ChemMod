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

    public static BlockChemTable chemTable = new BlockChemTable();


    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(oreCopper,
                                        chemTable
                                        );
    }

    public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(new ItemBlock(oreCopper).setRegistryName(oreCopper.getRegistryName()),
                                        new ItemBlock(chemTable).setRegistryName(chemTable.getRegistryName())
                                        );
    }


    @SideOnly(Side.CLIENT)
    public static void initModels() {
        oreCopper.initModel();
        chemTable.initModel();
    }
}
