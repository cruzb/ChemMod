package com.bradcruz.chemmod.block.machine.boiler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerMachineBoiler extends Container {
    private final TileEntityMachineBoiler tileEntity;
    private int cookTime, totalCooktime, burnTime, currentBurntime;

    public ContainerMachineBoiler(InventoryPlayer player, TileEntityMachineBoiler tileEntity) {
        this.tileEntity = tileEntity;
        IItemHandler handler = tileEntity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

        this.addSlotToContainer(new SlotItemHandler(handler, 0, 56, 17));
        this.addSlotToContainer(new SlotItemHandler(handler, 1, 56, 53));
        this.addSlotToContainer(new SlotItemHandler(handler, 2, 33, 35));
        this.addSlotToContainer(new SlotItemHandler(handler, 3, 116, 35));

        //inventory
        for(int y = 0; y < 3; y++) {
            for(int x = 0 ; x < 9; x++) {
                this.addSlotToContainer(new Slot(player, 9 + x + y*9, 8 + x*18, 84 + y*18));
            }
        }
        for(int x = 0; x < 9; x++) {
            this.addSlotToContainer(new Slot(player, x, 8 + x*18, 142));
        }
    }


    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for(int i = 0; i < this.listeners.size(); i++) {
            IContainerListener listener = this.listeners.get(i);

            if(this.cookTime != this.tileEntity.getField(2))
                listener.sendWindowProperty(this, 2, this.tileEntity.getField(2));
            if(this.burnTime != this.tileEntity.getField(0))
                listener.sendWindowProperty(this, 0, this.tileEntity.getField(0));
            if(this.currentBurntime != this.tileEntity.getField(1))
                listener.sendWindowProperty(this, 1, this.tileEntity.getField(1));
            if(this.totalCooktime != this.tileEntity.getField(3))
                listener.sendWindowProperty(this, 3, this.tileEntity.getField(3));
        }

        this.cookTime = this.tileEntity.getField(2);
        this.burnTime = this.tileEntity.getField(0);
        this.currentBurntime = this.tileEntity.getField(1);
        this.totalCooktime = this.tileEntity.getField(3);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data) {
        this.tileEntity.setField(id, data);
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return this.tileEntity.isUsableByPlayer(player);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int index) {
        ItemStack stack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if(slot != null && slot.getHasStack()) {
            ItemStack stack1 = slot.getStack();
            stack = stack1.copy();

            if(index == 3) {
                if(!this.mergeItemStack(stack1, 4, 40, true))
                    return ItemStack.EMPTY;
                slot.onSlotChange(stack1, stack);
            }
            else if(index != 2 && index != 1 && index != 0) {
                Slot slot1 = this.inventorySlots.get(index + 1);
                if(!RecipesMachineBoiler.getInstance().getMachineBoilerResult(stack1, slot1.getStack()).isEmpty()) {
                    if(!this.mergeItemStack(stack1, 0, 2, false))
                        return ItemStack.EMPTY;
                    else if(TileEntityMachineBoiler.isItemFuel(stack1))
                        if(!this.mergeItemStack(stack1, 2, 3, false)) return ItemStack.EMPTY;
                        else if(index >= 4 && index < 31)
                            if(!this.mergeItemStack(stack1, 31, 40, false)) return ItemStack.EMPTY;
                            else if(index >= 31 && index < 40 && !this.mergeItemStack(stack1, 4, 31, false))
                                return ItemStack.EMPTY;
                }
            }
            else if(!this.mergeItemStack(stack1, 4, 40, false))
                return ItemStack.EMPTY;
            if(stack1.isEmpty())
                slot.putStack(ItemStack.EMPTY);
            else slot.onSlotChanged();
            if(stack1.getCount() == stack.getCount()) return ItemStack.EMPTY;
            slot.onTake(player, stack1);
        }
        return stack;
    }
}
