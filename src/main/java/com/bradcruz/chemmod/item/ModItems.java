package com.bradcruz.chemmod.item;

import com.bradcruz.chemmod.item.chem.*;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;


public class ModItems {

    public static ItemBase ingotCopper = new ItemBase("ingot_copper");

    public static ItemChemBuffout buffout = new ItemChemBuffout("chem_buffout");
    public static ItemChemJet jet = new ItemChemJet("chem_jet");
    public static ItemChemMedx medx = new ItemChemMedx("chem_medx");
    public static ItemChemMentats mentats = new ItemChemMentats("chem_mentats");
    public static ItemChemNukacola nukacola = new ItemChemNukacola("chem_nukacola");
    public static ItemChemPsycho psycho = new ItemChemPsycho("chem_psycho");

    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(ingotCopper,
                                        buffout,
                                        jet,
                                        medx,
                                        mentats,
                                        nukacola,
                                        psycho
                                    );
    }


    @SideOnly(Side.CLIENT)
    public static void initModels() {
        ingotCopper.initModel();
        buffout.initModel();
        jet.initModel();
        medx.initModel();
        mentats.initModel();
        nukacola.initModel();
        psycho.initModel();
    }
}
