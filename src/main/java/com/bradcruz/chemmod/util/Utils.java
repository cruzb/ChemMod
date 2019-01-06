package com.bradcruz.chemmod.util;

import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;

public class Utils {
    public static AxisAlignedBB AABBfromVecs(Vec3d v1, Vec3d v2) {
        return new AxisAlignedBB(v1.x, v1.y, v1.z, v2.x, v2.y, v2.z);
    }

    public static int clamp(int num, int min, int max) {
        return num < min ? min : (num > max ? max : num);
    }

    public static double clamp(double num, double min, double max) {
        return num < min ? min : (num > max ? max : num);
    }

    public static float clamp(float num, float min, float max) {
        return num < min ? min : (num > max ? max : num);
    }

    public static short clamp(short num, short min, short max) {
        return num < min ? min : (num > max ? max : num);
    }
}
