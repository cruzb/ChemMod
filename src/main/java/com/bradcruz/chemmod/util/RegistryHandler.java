package com.bradcruz.chemmod.util;

import com.bradcruz.chemmod.Main;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RegistryHandler {

    public static void preinit() {
        //biomes and worldgen
    }

    public static void init() {
        //sound reistry
        NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
    }

    public static void postinit() {

    }
}
