package com.bradcruz.chemmod.item.chem;

import com.bradcruz.chemmod.item.ItemBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.client.event.sound.SoundEvent;

public class ItemChemMedx extends ItemBase {

    private String name;
    private SoundEvent sound;
    private SoundCategory soundCategory;
    private int stackSize = 8;
    private float volume = 0.5f;
    private float pitch = 0.8f;



    public ItemChemMedx(String name) {
        super(name);
        this.name = name;

        //setCreativeTab();

        this.maxStackSize = stackSize;
    }

    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        ItemStack itemstack = player.getHeldItem(hand);

        if(!player.capabilities.isCreativeMode) {
            itemstack.shrink(1);
        }

        //world.playSound(());
        player.getCooldownTracker().setCooldown(this, 20);

        //do stuff to player
        if(!world.isRemote) {
            DoChemEffect(player, itemstack);
        }

        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }

    private void DoChemEffect(EntityPlayer player, ItemStack itemstack) {
        //med-x does +25 dmg resist +250 poison resist
        player.curePotionEffects(itemstack);
        player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 6000, 2));
        player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 10, 3));


    }


}
