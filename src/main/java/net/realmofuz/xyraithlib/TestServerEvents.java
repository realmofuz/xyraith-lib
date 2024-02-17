package net.realmofuz.xyraithlib;

import net.realmofuz.xyraithlib.actions.SelectEntity;
import net.realmofuz.xyraithlib.events.EventMeta;
import net.realmofuz.xyraithlib.events.ServerEvents;
import net.realmofuz.xyraithlib.scheduler.Task;
import net.realmofuz.xyraithlib.types.Item;
import net.realmofuz.xyraithlib.types.Particle;
import net.realmofuz.xyraithlib.types.ParticleType;
import org.bukkit.Material;

import java.nio.file.attribute.UserPrincipalLookupService;

public class TestServerEvents implements ServerEvents {
    @Override
    public void serverStart() {
        Task.pushTask(task -> {
            SelectEntity.allPlayers().forEach(selection -> {
                selection.playParticle(
                        new Particle(ParticleType.CRIT_MAGIC).setSpeed(0),
                        selection.getEyeLocation().shiftForward(5)
                );

                System.out.println(selection.getEyeLocation());
                System.out.println(selection.getEyeLocation().shiftForward(5));
            });
            task.repeat(1);
        });
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
