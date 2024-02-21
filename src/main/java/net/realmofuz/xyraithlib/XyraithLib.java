package net.realmofuz.xyraithlib;

import net.realmofuz.xyraithlib.actions.PersistentData;
import net.realmofuz.xyraithlib.events.EventSender;
import net.realmofuz.xyraithlib.configs.ServerConfig;
import net.realmofuz.xyraithlib.events.ServerEventsManager;
import net.realmofuz.xyraithlib.scheduler.TaskQueue;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class XyraithLib extends JavaPlugin {

    public static XyraithLib instance;
    public static ServerConfig serverConfig;
    @Override
    public void onEnable() {
        instance = this;


        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(
                this,
                TaskQueue::attemptTasks,
                0, 1
        );

        Bukkit.getServer().getPluginManager().registerEvents(new EventSender(), this);
        ServerEventsManager.setServerEventsInstance(new TestServerEvents());

        PersistentData.deserialize();
        System.out.println("Enabled!");

        ServerEventsManager.serverEventsInstance.serverStart();


    }

    @Override
    public void onDisable() {
        PersistentData.serialize();
        TaskQueue.clearTasks();
        ServerEventsManager.serverEventsInstance.serverStop();
    }
}
