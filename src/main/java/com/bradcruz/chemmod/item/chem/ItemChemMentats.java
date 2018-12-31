package com.bradcruz.chemmod.item.chem;

import com.bradcruz.chemmod.item.ItemBase;
import com.bradcruz.chemmod.util.Utils;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.List;

@Mod.EventBusSubscriber
public class ItemChemMentats extends ItemBase/* implements ITickable */{

    private String name;
    private SoundEvent sound;
    private SoundCategory soundCategory;
    private int stackSize = 8;
    private int duration = 2000;
    private float volume = 0.5f;
    private float pitch = 0.8f;


    private World world = null;
    private EntityPlayer player = null;
    private boolean isActive = false;
    private long startTime = 0;


    public ItemChemMentats(String name) {
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
            ///this.world = world;
            ///this.player = player;
            DoChemEffect(player, itemstack);
        }

        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }

    private void DoChemEffect(EntityPlayer player, ItemStack itemstack) {
        //med-x does +2 int +2 percep
        player.addPotionEffect(new PotionEffect(MobEffects.GLOWING, duration, 1));
        player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, duration, 1));
        player.addPotionEffect(new PotionEffect(MobEffects.LUCK, duration, 0));
        player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 100, 3));

        List<EntityLivingBase> entities = world.getEntitiesWithinAABB(EntityLivingBase.class, Utils.AABBfromVecs(
                this.player.getPositionVector().subtract(12,12,12),
                this.player.getPositionVector().addVector(12,12,12)));
        for(EntityLivingBase e : entities) {
            e.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 1200));
        }

        ///isActive = true;
        ///startTime = world.getTotalWorldTime();
    }

    //fix this later
/*
    @SubscribeEvent
    public void update(TickEvent.PlayerTickEvent event) {
        long time = 0;
        if(world != null) time = world.getTotalWorldTime();
        System.out.println("HEY");
        if(isActive && (time == startTime + duration))
            isActive = false;
        if(isActive){
            if(time % 20 == 0) {
                List<EntityLivingBase> entities = world.getEntitiesWithinAABB(EntityLivingBase.class, Utils.AABBfromVecs(
                        this.player.getPositionVector().subtract(12,12,12),
                        this.player.getPositionVector().addVector(12,12,12)));
                for(EntityLivingBase e : entities) {
                    e.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 20));
                }
            }
        }
    }*/
}
