package com.bradcruz.chemmod.block.crop;

import com.bradcruz.chemmod.Main;
import com.bradcruz.chemmod.item.ModItems;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BlockCropHubflower extends BlockCrops {

    private String name;

    public BlockCropHubflower(String name) {
        setUnlocalizedName(Main.MODPREFIX + name);
        setRegistryName(name);

        setCreativeTab(Main.creativeTab);
    }


    @Override
    protected Item getSeed() {
        return ModItems.seedHubflower;
    }

    @Override
    protected Item getCrop() {
        return ModItems.hubflower;
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public void getDrops(net.minecraft.util.NonNullList<ItemStack> drops, net.minecraft.world.IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        Random rand = world instanceof World ? ((World)world).rand : new Random();
        int countCrop = 0;
        int countSeed = 0;

        if(((Integer)state.getValue(AGE)) >= 7) {
            countCrop = 1 + rand.nextInt(3) + (fortune > 0 ? rand.nextInt(fortune + 1) : 0);
            countSeed = 1 + rand.nextInt(2);
        }
        else if(((Integer)state.getValue(AGE)) >= 3)
            countSeed = 1;

        for(int i = 0; i < countCrop; i++)
            drops.add(new ItemStack(ModItems.hubflower));
        for(int i = 0; i < countSeed; i++)
            drops.add(new ItemStack(ModItems.seedHubflower));

    }
}
