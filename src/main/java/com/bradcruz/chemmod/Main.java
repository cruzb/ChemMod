package com.bradcruz.chemmod;

import com.bradcruz.chemmod.client.CreativeTab;
import com.bradcruz.chemmod.proxy.CommonProxy;
import com.bradcruz.chemmod.recipe.ModRecipes;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.MODVERSION, dependencies = "required-after:forge@[11.16.0.1865,)", useMetadata = true)
public class Main {

    public static final String MODID = "chemmod";
    public static final String MODNAME = "Chems";
    public static final String MODVERSION= "0.0.1";
    public static final String MODPREFIX = "chemmod.";

    @SidedProxy(clientSide = "com.bradcruz.chemmod.proxy.ClientProxy", serverSide = "com.bradcruz.chemmod.proxy.ServerProxy")
    public static CommonProxy proxy;

    public static final CreativeTab creativeTab = new CreativeTab();

    @Mod.Instance
    public static Main instance;

   // public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
     //   logger = event.getModLog();
        proxy.preInit(event);System.out.println("HddEY");System.out.println("HffdEY");System.out.println("HdfdEY");System.out.println("HEYfdf");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
        ModRecipes.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}