package net.realmofuz.xyraithlib.actions;

import net.realmofuz.xyraithlib.lambdas.LocationLambda;
import net.realmofuz.xyraithlib.types.Location;

public class Loops {
    public static void forBlockInGrid(Location corner1, Location corner2, LocationLambda lambda, ) {
        for(var x = corner1.getX(); x<=corner2.getX(); x++) {
            for(var z = corner1.getZ(); z<=corner2.getZ(); z++) {
                for(var y = corner1.getY(); y<=corner2.getY(); y++) {
                    lambda.run(new Location(corner1.getBukkitWorld(), x, y, z, 0, 0));
                }
            }
        }
    }

    public static void forLine(Location[] locations, float step, LocationLambda lambda) {
        int index = 0;
        for(Location location : locations) {
            index++;
        }
    }
}
