package com.bradcruz.chemmod.block;

import com.bradcruz.chemmod.block.crop.BlockCropBrainFungus;
import com.bradcruz.chemmod.block.crop.BlockCropHubflower;
import com.bradcruz.chemmod.block.machine.brewer.BlockMachineBrewer;
import com.bradcruz.chemmod.block.machine.mixer.BlockMachineMixer;
import com.bradcruz.chemmod.block.machine.mixer.TileEntityMachineMixer;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {
    public static BlockBase oreCopper = new BlockBase("ore_copper", Material.ROCK);

    //public static BlockChemTable chemTable = new BlockChemTable("chem_table");
    public static BlockMachineBrewer brewer = new BlockMachineBrewer("machine_brewer");
    public static BlockMachineMixer mixer = new BlockMachineMixer("machine_mixer");

    public static final BlockCropHubflower cropHubflower = new BlockCropHubflower("crop_hubflower");
    public static final BlockCropBrainFungus cropBrainFungus = new BlockCropBrainFungus("crop_brainfungus");



    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(oreCopper,
                                        brewer,
                                        mixer,
                                        cropHubflower,
                                        cropBrainFungus
                                        );
        registerTileEntities();
    }

    public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(new ItemBlock(oreCopper).setRegistryName(oreCopper.getRegistryName()),
                                        new ItemBlock(brewer).setRegistryName(brewer.getRegistryName()),
                                        new ItemBlock(mixer).setRegistryName(mixer.getRegistryName())
                                        //new ItemBlock(cropHubflower).setRegistryName(cropHubflower.getRegistryName()),
                                        //new ItemBlock(cropBrainFungus).setRegistryName(cropBrainFungus.getRegistryName())
                                        );
    }


    private static void registerTileEntities() {
        GameRegistry.registerTileEntity(TileEntityMachineMixer.class, "machine_mixer");
    }


    @SideOnly(Side.CLIENT)
    public static void initModels() {
        oreCopper.initModel();
        brewer.initModel();
        mixer.initModel();
        cropHubflower.initModel();
        cropBrainFungus.initModel();
    }
}
