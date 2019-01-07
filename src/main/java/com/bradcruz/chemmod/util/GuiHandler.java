package com.bradcruz.chemmod.util;

import com.bradcruz.chemmod.ModGUIs;
import com.bradcruz.chemmod.block.machine.boiler.ContainerMachineBoiler;
import com.bradcruz.chemmod.block.machine.boiler.GuiMachineBoiler;
import com.bradcruz.chemmod.block.machine.boiler.TileEntityMachineBoiler;
import com.bradcruz.chemmod.block.machine.mixer.ContainerMachineMixer;
import com.bradcruz.chemmod.block.machine.mixer.GuiMachineMixer;
import com.bradcruz.chemmod.block.machine.mixer.TileEntityMachineMixer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;

public class GuiHandler implements IGuiHandler {

    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == ModGUIs.GUI_BOILER)
            return new ContainerMachineBoiler(player.inventory, (TileEntityMachineBoiler)world.getTileEntity(new BlockPos(x,y,z)));
        else if(ID == ModGUIs.GUI_MIXER)
            return new ContainerMachineMixer(player.inventory, (TileEntityMachineMixer)world.getTileEntity(new BlockPos(x,y,z)));
        return null;
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == ModGUIs.GUI_BOILER)
            return new GuiMachineBoiler(player.inventory, (TileEntityMachineBoiler)world.getTileEntity(new BlockPos(x,y,z)));
        else if(ID == ModGUIs.GUI_MIXER)
            return new GuiMachineMixer(player.inventory, (TileEntityMachineMixer)world.getTileEntity(new BlockPos(x,y,z)));
        return null;
    }
}
