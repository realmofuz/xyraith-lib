package net.realmofuz.xyraithlib.actions;

import net.realmofuz.xyraithlib.types.Selection;
import net.realmofuz.xyraithlib.types.SingleSelection;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

public final class SelectEntity {
    public static Selection fromUuid(UUID uuid) {
        var entities = new ArrayList<Entity>();
        for(var world : Bukkit.getWorlds()) {
            for(var entity : world.getEntities()) {
                if(entity.getUniqueId().equals(uuid)) {
                    entities.add(entity);
                }
            }
        }
        return new Selection(entities);
    }

    public static Selection fromName(String name) {
        var entities = new ArrayList<Entity>();
        for(var world : Bukkit.getWorlds()) {
            for(var entity : world.getEntities()) {
                if(entity.getName().equals(name)) {
                    entities.add(entity);
                }
            }
        }
        return new Selection(entities);
    }

    public static Selection allPlayers() {
        var entities = new ArrayList<Entity>();
        for(var world : Bukkit.getWorlds()) {
            for(var entity : world.getEntities()) {
                if(entity instanceof Player)
                    entities.add(entity);
            }
        }
        return new Selection(entities);
    }

    public static Selection allEntities() {
        var entities = new ArrayList<Entity>();
        for(var world : Bukkit.getWorlds()) {
            entities.addAll(world.getEntities());
        }
        return new Selection(entities);
    }
}
