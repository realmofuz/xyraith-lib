package net.realmofuz.xyraithlib.actions;

import net.realmofuz.xyraithlib.types.Item;
import net.realmofuz.xyraithlib.types.Location;
import net.realmofuz.xyraithlib.types.Selection;
import net.realmofuz.xyraithlib.types.SingleSelection;
import org.bukkit.TreeType;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.EntityType;

public class WorldActions {
    public void setBlock(Location loc, Item item) {
        loc.getBukkitWorld().setBlockData(loc.toBukkitLocation(), item.toBukkitItemStack().getType().createBlockData());
    }

    public void setRegion(Location c1, Location c2, Item item) {
        for(double x = c1.getX(); x<c2.getX(); x++) {
            for(double y = c1.getY(); x<c2.getY(); y++) {
                for(double z = c1.getZ(); x<c2.getZ(); z++) {
                    var loc = new Location(c1.getBukkitWorld(), x, y, z);
                    setBlock(loc, item);
                }
            }
        }
    }

    public SingleSelection spawnEntity(Location loc, EntityType type) {
        var ent = loc.getBukkitWorld().spawnEntity(loc.toBukkitLocation(), type);
        return new SingleSelection(ent);
    }

    public void generateTree(Location loc, TreeType type) {
        loc.getBukkitWorld().generateTree(loc.toBukkitLocation(), type);
    }
}
