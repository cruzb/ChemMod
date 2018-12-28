package com.bradcruz.chemmod.item;

import com.bradcruz.chemmod.item.chem.ItemChemBuffout;
import com.bradcruz.chemmod.item.chem.ItemChemMedx;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class ModItems {

    public static ItemBase ingotCopper = new ItemBase("ingot_copper");

    public static ItemChemBuffout buffout = new ItemChemBuffout("chem_buffout");
    public static ItemChemMedx medx = new ItemChemMedx("chem_medx");

    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(ingotCopper);
        event.getRegistry().register(buffout);
        event.getRegistry().register(medx);
    }


    @SideOnly(Side.CLIENT)
    public static void initModels() {
        ingotCopper.initModel();
        buffout.initModel();
        medx.initModel();
    }
}
