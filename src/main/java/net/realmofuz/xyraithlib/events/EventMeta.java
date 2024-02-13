package net.realmofuz.xyraithlib.events;

import net.realmofuz.xyraithlib.types.Location;
import net.realmofuz.xyraithlib.types.SingleSelection;
import org.bukkit.Material;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockEvent;
import org.bukkit.event.player.PlayerEvent;

import java.util.Optional;

public class EventMeta {
    Event event;

    public EventMeta(Event event) {
        this.event = event;
    }

    /**
     * Cancels the event if possible.
     */
    public void cancelEvent() {
        if(event instanceof Cancellable) {
            ((Cancellable) event).setCancelled(true);
        }
    }

    /**
     * Uncancels the event if possible.
     */
    public void uncancelEvent() {
        if(event instanceof Cancellable) {
            ((Cancellable) event).setCancelled(false);
        }
    }

    /**
     * Sets whether this event is cancelled or not if possible.
     * @param b True if cancelled, false if not.
     */
    public void setCancelled(boolean b) {
        if(event instanceof Cancellable) {
            ((Cancellable) event).setCancelled(b);
        }
    }

    /**
     * Gets the player involved in this event.
     * Returns an empty optional if the event is not a PlayerEvent.
     * @return A selection containing the player involved in the event.
     */
    public Optional<SingleSelection> getPlayer() {
        if(event instanceof PlayerEvent) {
            return Optional.of(new SingleSelection(((PlayerEvent) event).getPlayer()));
        }
        return Optional.empty();
    }

    /**
     * Gets the location of the block involved in this event.
     * Returns an empty optional if the event is not a BlockEvent.
     * @return The location of the block involved in the event.
     */
    public Optional<Location> getBlockLocation() {
        if(event instanceof BlockEvent) {
            return Optional.of(new Location(((BlockEvent) event).getBlock().getLocation()));
        }
        return Optional.empty();
    }

    /**
     * Gets the material of the block involved in this event.
     * Returns an empty optional if the event is not a BlockEvent.
     * @return The material of the block involved in the event.
     */
    public Optional<Material> getBlockMaterial() {
        if(event instanceof BlockEvent) {
            return Optional.of(((BlockEvent) event).getBlock().getType());
        }
        return Optional.empty();
    }
}
