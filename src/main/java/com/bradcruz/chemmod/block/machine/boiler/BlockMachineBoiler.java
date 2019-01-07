package com.bradcruz.chemmod.block.machine.boiler;

import com.bradcruz.chemmod.Main;
import com.bradcruz.chemmod.ModGUIs;
import com.bradcruz.chemmod.block.ModBlocks;
import com.bradcruz.chemmod.block.machine.BlockMachineBase;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockMachineBoiler extends BlockMachineBase {

    public BlockMachineBoiler(String name) {
        super(name, Material.IRON);
    }


    //GUI stuff
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(!world.isRemote)
            player.openGui(Main.instance, ModGUIs.GUI_BOILER, world, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }

    //Tile Enitty Stuff
    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileEntityMachineBoiler();
    }

    public static void setState(boolean active, World world, BlockPos pos) {
        IBlockState state = world.getBlockState(pos);
        TileEntity tileEntity = world.getTileEntity(pos);

        //add light here?

        /*if(active) {
            world.setBlockState(pos, ModBlocks.boiler.getDefaultState()
                    .withProperty(FACING, state.getValue(FACING))
                    .withProperty(ACTIVE, true), 3);
        }
        else {*/
            world.setBlockState(pos, ModBlocks.boiler.getDefaultState()
                    .withProperty(FACING, state.getValue(FACING))
                    .withProperty(ACTIVE, active), 3);
        //}

        if(tileEntity != null) {
            tileEntity.validate();
            world.setTileEntity(pos, tileEntity);
        }
    }
}
