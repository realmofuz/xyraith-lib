package net.realmofuz.xyraithlib.types;

import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.title.Title;
import net.realmofuz.xyraithlib.Utils;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.time.Duration;

public final class SingleSelection {
    Entity entity;

    public SingleSelection(Entity entity) {
        this.entity = entity;
    }

    public void sendMessage(String string) {
        if (entity instanceof Player) {
            entity.sendMessage(Utils.deserialize(string));
        }
    }

    public void sendActionBar(String string) {
        if (entity instanceof Player) {
            entity.sendActionBar(Utils.deserialize(string));
        }
    }

    public void sendBossBar(String name, float progress, BossBar.Color color, BossBar.Overlay overlay) {
        if (entity instanceof Player) {
            entity.showBossBar(BossBar.bossBar(Utils.deserialize(name), progress, color, overlay));
        }
    }

    public void showTitle(String title, String subtitle) {
        entity.showTitle(Title.title(
                Utils.deserialize(title),
                Utils.deserialize(subtitle),
                Title.DEFAULT_TIMES
        ));
    }

    public void showTitle(String title, String subtitle, int fadeIn, int stay, int fadeOut) {
        entity.showTitle(Title.title(
                Utils.deserialize(title),
                Utils.deserialize(subtitle),
                Title.Times.times(Duration.ofSeconds(fadeIn), Duration.ofSeconds(stay), Duration.ofSeconds(fadeOut))
        ));
    }
}
