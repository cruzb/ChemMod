package com.bradcruz.chemmod.block.machine.mixer;

import com.bradcruz.chemmod.block.machine.TileEntityMachineBase;
import net.minecraft.item.*;
import net.minecraft.util.ITickable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;

public class TileEntityMachineMixer extends TileEntityMachineBase implements ITickable {

    @Override
    public ITextComponent getDisplayName() {
        return this.hasCustomName() ? new TextComponentString(this.customName) : new TextComponentTranslation("container.machine_mixer");
    }


    public void update() {
        if(this.isActive()) {
            --this.burnTime;
            BlockMachineMixer.setState(true, world, pos);
        }
        else if (!this.isActive() && !world.isRemote) {
            BlockMachineMixer.setState(false, world, pos);
        }


        ItemStack[] inputs = new ItemStack[] {handler.getStackInSlot(0), handler.getStackInSlot(1)};
        ItemStack fuel = this.handler.getStackInSlot(2);

        if(this.isActive() || !fuel.isEmpty() && !this.handler.getStackInSlot(0).isEmpty() || this.handler.getStackInSlot(1).isEmpty()) {
            if(!this.isActive() && this.canSmelt()) {
                this.burnTime = getItemBurnTime(fuel);
                this.currentBurnTime = burnTime;

                if(this.isActive() && !fuel.isEmpty()) {
                    Item item = fuel.getItem();
                    fuel.shrink(1);

                    if(fuel.isEmpty()) {
                        ItemStack item1 = item.getContainerItem(fuel);
                        this.handler.setStackInSlot(2, item1);
                    }
                }
            }
        }

        if(this.isActive() && this.canSmelt() && cookTime > 0) {
            cookTime++;
            if(cookTime == totalCookTime) {
                inputs[0].shrink(1);
                inputs[1].shrink(1);
                if(handler.getStackInSlot(3).getCount() > 0) {
                    handler.getStackInSlot(3).grow(1);
                }
                else {
                    handler.insertItem(3, smelting, false);
                }

                smelting = ItemStack.EMPTY;
                cookTime = 0;
                return;
            }
        }
        else {
            if(this.canSmelt() && this.isActive()) {
                ItemStack output = RecipesMachineMixer.getInstance().getResult(inputs[0], inputs[1]);
                if(!output.isEmpty()) {
                    smelting = output;
                    cookTime++;
                    //inputs[0].shrink(1);
                    //inputs[1].shrink(1);
                    handler.setStackInSlot(0, inputs[0]);
                    handler.setStackInSlot(1, inputs[1]);
                }
            }

            else if(this.isActive() && !this.canSmelt()) {
                cookTime = 0;
            }
        }
    }

    private boolean canSmelt() {
        if(((ItemStack)this.handler.getStackInSlot(0)).isEmpty() || ((ItemStack)this.handler.getStackInSlot(1)).isEmpty()) return false;
        else {
            ItemStack result = RecipesMachineMixer.getInstance().getResult((ItemStack)this.handler.getStackInSlot(0), (ItemStack)this.handler.getStackInSlot(1));
            if(result.isEmpty()) return false;
            else {
                ItemStack output = (ItemStack)this.handler.getStackInSlot(3);
                if(output.isEmpty()) return true;
                if(!output.isItemEqual(result)) return false;
                int res = output.getCount() + result.getCount();
                return res <= 64 && res <= output.getMaxStackSize();
            }
        }
    }


}