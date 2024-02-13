package net.realmofuz.xyraithlib.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.*;

public class EventSender implements Listener {
    @EventHandler
    public void playerJoin(PlayerJoinEvent e) {
        ServerEventsManager.serverEventsInstance.playerJoin(new EventMeta(e));
    }

    @EventHandler
    public void playerQuit(PlayerQuitEvent e) {
        ServerEventsManager.serverEventsInstance.playerQuit(new EventMeta(e));
    }

    @EventHandler
    public void playerPickupItem(PlayerAttemptPickupItemEvent e) {
        ServerEventsManager.serverEventsInstance.playerPickupItem(new EventMeta(e));
    }

    @EventHandler
    public void playerClickEntity(PlayerInteractEntityEvent e) {
        ServerEventsManager.serverEventsInstance.playerClickEntity(new EventMeta(e));
    }

    @EventHandler
    public void playerConsumeItem(PlayerItemConsumeEvent e) {
        ServerEventsManager.serverEventsInstance.playerConsumeItem(new EventMeta(e));
    }

    @EventHandler
    public void playerSwapHands(PlayerSwapHandItemsEvent e) {
        ServerEventsManager.serverEventsInstance.playerSwapHands(new EventMeta(e));
    }

    @EventHandler
    public void playerPreprocessCommand(PlayerCommandPreprocessEvent e) {
        ServerEventsManager.serverEventsInstance.playerPreprocessCommand(new EventMeta(e));
    }

    @EventHandler
    public void playerInteract(PlayerInteractEvent e) {
        if(e.getAction() == Action.LEFT_CLICK_AIR
        || e.getAction() == Action.LEFT_CLICK_BLOCK) {
            ServerEventsManager.serverEventsInstance.playerLeftClick(new EventMeta(e));
        }

        if(e.getAction() == Action.RIGHT_CLICK_AIR
                || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            ServerEventsManager.serverEventsInstance.playerRightClick(new EventMeta(e));
        }
    }
}
