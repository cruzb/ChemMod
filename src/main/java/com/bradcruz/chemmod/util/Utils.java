package com.bradcruz.chemmod.util;

import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;

public class Utils {
    public static AxisAlignedBB AABBfromVecs(Vec3d v1, Vec3d v2) {
        return new AxisAlignedBB(v1.x, v1.y, v1.z, v2.x, v2.y, v2.z);
    }
}
