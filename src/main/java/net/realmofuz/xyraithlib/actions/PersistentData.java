package net.realmofuz.xyraithlib.actions;

import net.realmofuz.xyraithlib.XyraithLib;

import java.util.HashMap;

public class PersistentData {
    static HashMap<String, Object> data = new HashMap<>();

    public static void serialize() {
        var folder = XyraithLib.instance.getDataFolder();
        var path = folder.getAbsolutePath() + "persistentData.xrd";
    }

    public static void deserialize() {

    }
}
