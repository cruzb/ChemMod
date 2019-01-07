package com.bradcruz.chemmod.block.machine.mixer;

import com.bradcruz.chemmod.Main;
import com.bradcruz.chemmod.ModGUIs;
import com.bradcruz.chemmod.block.ModBlocks;
import com.bradcruz.chemmod.block.machine.BlockMachineBase;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class BlockMachineMixer extends BlockMachineBase {

    public BlockMachineMixer(String name) {
        super(name, Material.IRON);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING, ACTIVE);
    }


    //GUI stuff
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(!world.isRemote)
            player.openGui(Main.instance, ModGUIs.GUI_MIXER, world, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }

    //Tile Enitty Stuff
    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileEntityMachineMixer();
    }

    public static void setState(boolean active, World world, BlockPos pos) {
        IBlockState state = world.getBlockState(pos);
        TileEntity tileEntity = world.getTileEntity(pos);

        //add light here?

        /*if(active) {
            world.setBlockState(pos, ModBlocks.mixer.getDefaultState()
                    .withProperty(FACING, state.getValue(FACING))
                    .withProperty(ACTIVE, true), 3);
        }
        else {*/
            world.setBlockState(pos, ModBlocks.mixer.getDefaultState()
                    .withProperty(FACING, state.getValue(FACING))
                    .withProperty(ACTIVE, active), 3);
       // }

        if(tileEntity != null) {
            tileEntity.validate();
            world.setTileEntity(pos, tileEntity);
        }
    }
}