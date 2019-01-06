package com.bradcruz.chemmod.block.machine.mixer.slot;

import com.bradcruz.chemmod.block.machine.mixer.TileEntityMachineMixer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotMachineMixerFuel extends Slot {

    public SlotMachineMixerFuel(IInventory inventory, int index, int x,int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return TileEntityMachineMixer.isItemFuel(stack);
    }

    @Override
    public int getItemStackLimit(ItemStack stack) {
        return super.getItemStackLimit(stack);
    }
}
