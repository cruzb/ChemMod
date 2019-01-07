package com.bradcruz.chemmod.item;

import com.bradcruz.chemmod.item.chem.*;
import com.bradcruz.chemmod.item.component.ItemAcid;
import com.bradcruz.chemmod.item.component.ItemBlood;
import com.bradcruz.chemmod.item.crop.ItemBrainfungus;
import com.bradcruz.chemmod.item.crop.ItemHubflower;
import com.bradcruz.chemmod.item.crop.ItemSeedBrainfungus;
import com.bradcruz.chemmod.item.crop.ItemSeedHubflower;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class ModItems {
    //
    public static final ItemBase ingotCopper = new ItemBase("ingot_copper");

    //////crops
    public static ItemHubflower hubflower = new ItemHubflower("hubflower");
    public static ItemSeedHubflower seedHubflower = new ItemSeedHubflower("seed_hubflower");
    //
    public static ItemBrainfungus brainFungus = new ItemBrainfungus("brainfungus");
    public static ItemSeedBrainfungus seedBrainFungus = new ItemSeedBrainfungus("seed_brainfungus");


    //components
    public static ItemAcid acid = new ItemAcid("acid");
    public static ItemBlood blood = new ItemBlood("blood");


    public static ItemChemBuffout buffout = new ItemChemBuffout("chem_buffout");
    public static ItemChemJet jet = new ItemChemJet("chem_jet");
    public static ItemChemMedx medx = new ItemChemMedx("chem_medx");
    public static ItemChemMentats mentats = new ItemChemMentats("chem_mentats");
    public static ItemChemNukacola nukacola = new ItemChemNukacola("chem_nukacola");
    public static ItemChemPsycho psycho = new ItemChemPsycho("chem_psycho");

    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(ingotCopper,
                                        //crops
                                        hubflower,
                                        seedHubflower,
                                        brainFungus,
                                        seedBrainFungus,
                                        //component
                                        acid,
                                        blood,
                                        //chems
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
        //
        hubflower.initModel();
        seedHubflower.initModel();
        brainFungus.initModel();
        seedBrainFungus.initModel();
        //
        acid.initModel();
        blood.initModel();
        //
        buffout.initModel();
        jet.initModel();
        medx.initModel();
        mentats.initModel();
        nukacola.initModel();
        psycho.initModel();
    }
}
