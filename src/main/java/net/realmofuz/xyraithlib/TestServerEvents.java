package net.realmofuz.xyraithlib;

import net.realmofuz.xyraithlib.actions.SelectEntity;
import net.realmofuz.xyraithlib.events.EventMeta;
import net.realmofuz.xyraithlib.events.ServerEvents;
import net.realmofuz.xyraithlib.scheduler.Task;
import net.realmofuz.xyraithlib.types.Item;
import org.bukkit.Material;

public class TestServerEvents implements ServerEvents {
    @Override
    public void serverStart() {
        new Task(task -> {
            SelectEntity.allPlayers().forEach(selection -> {
                System.out.println("Task running!!!");
                selection.sendActionBar(
                        "<red>100/100 HP     <green>0 Defense     <aqua>100/100 Mana"
                );
            });
            task.pushToQueue(1);
        }).pushToQueue(0);
    }

    @Override
    public void serverStop() {

    }

    @Override
    public void playerJoin(EventMeta event) {


    }

    @Override
    public void playerLeave(EventMeta event) {

    }

    @Override
    public void playerLeftClick(EventMeta event) {

    }

    @Override
    public void playerRightClick(EventMeta event) {

    }

    @Override
    public void playerSwapHands(EventMeta event) {

    }

    @Override
    public void playerPickupItem(EventMeta event) {

    }

    @Override
    public void playerConsumeItem(EventMeta event) {

    }

    @Override
    public void playerClickEntity(EventMeta event) {

    }

    @Override
    public void playerQuit(EventMeta event) {

    }

    @Override
    public void playerPreprocessCommand(EventMeta event) {

    }
}
