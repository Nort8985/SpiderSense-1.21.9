package com.nort8985.spidersense;

import net.minecraft.entity.mob.MobEntity;
import java.util.ArrayList;
import java.util.List;

public class MonsterHighlighter {
    public static int duration = -1;
    public static List<MobEntity> list = new ArrayList<>();
    public static MobEntity closestMob = null;
    public static double closestDistance = Double.MAX_VALUE;
}
