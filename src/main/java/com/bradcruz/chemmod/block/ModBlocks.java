package com.bradcruz.chemmod.block;

import com.bradcruz.chemmod.block.crop.BlockCropBrainFungus;
import com.bradcruz.chemmod.block.crop.BlockCropHubflower;
import com.bradcruz.chemmod.block.machine.boiler.BlockMachineBoiler;
import com.bradcruz.chemmod.block.machine.boiler.TileEntityMachineBoiler;
import com.bradcruz.chemmod.block.machine.centrifuge.BlockMachineCentrifuge;
import com.bradcruz.chemmod.block.machine.composter.BlockMachineComposter;
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
    public static BlockMachineMixer mixer = new BlockMachineMixer("machine_mixer");
    public static BlockMachineBoiler boiler = new BlockMachineBoiler("machine_boiler");
    public static BlockMachineComposter composter = new BlockMachineComposter("machine_composter");
    public static BlockMachineCentrifuge centrifuge = new BlockMachineCentrifuge("machine_centrifuge");

    public static final BlockCropHubflower cropHubflower = new BlockCropHubflower("crop_hubflower");
    public static final BlockCropBrainFungus cropBrainFungus = new BlockCropBrainFungus("crop_brainfungus");



    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(oreCopper,
                                        mixer,
                                        boiler,
                                        composter,
                                        centrifuge,
                                        cropHubflower,
                                        cropBrainFungus
                                        );
        registerTileEntities();
    }

    public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(new ItemBlock(oreCopper).setRegistryName(oreCopper.getRegistryName()),
                                        new ItemBlock(mixer).setRegistryName(mixer.getRegistryName()),
                                        new ItemBlock(boiler).setRegistryName(boiler.getRegistryName()),
                                        new ItemBlock(composter).setRegistryName(composter.getRegistryName()),
                                        new ItemBlock(centrifuge).setRegistryName(centrifuge.getRegistryName())
                                        //new ItemBlock(cropHubflower).setRegistryName(cropHubflower.getRegistryName()),
                                        //new ItemBlock(cropBrainFungus).setRegistryName(cropBrainFungus.getRegistryName())
                                        );
    }


    private static void registerTileEntities() {
        GameRegistry.registerTileEntity(TileEntityMachineMixer.class, "machine_mixer");
        GameRegistry.registerTileEntity(TileEntityMachineBoiler.class, "machine_boiler");
    }


    @SideOnly(Side.CLIENT)
    public static void initModels() {
        oreCopper.initModel();
        mixer.initModel();
        boiler.initModel();
        composter.initModel();
        centrifuge.initModel();
        cropHubflower.initModel();
        cropBrainFungus.initModel();
    }
}
