package net.realmofuz.xyraithlib.types;

import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.title.Title;
import net.realmofuz.xyraithlib.Utils;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
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

    public void setHealth(float health) {
        if(entity instanceof LivingEntity) {
            ((LivingEntity) entity).setHealth(health);
        }
    }
    public void heal(float health) {
        if(entity instanceof LivingEntity) {
            ((LivingEntity) entity).setHealth(((LivingEntity) entity).getHealth() + health);
        }
    }
    public void damage(float damage) {
        if(entity instanceof LivingEntity) {
            ((LivingEntity) entity).setHealth(((LivingEntity) entity).getHealth() - damage);
        }
    }
    public double getHealth(float health) {
        if(entity instanceof LivingEntity) {
            return ((LivingEntity) entity).getHealth();
        }
        return 0.0;
    }

    public void setMaxHealth(float maxHealth) {
        if(entity instanceof LivingEntity) {
            ((LivingEntity) entity).setMaxHealth(maxHealth);
        }
    }
    public double getMaxHealth(float maxHealth) {
        if(entity instanceof LivingEntity) {
            return ((LivingEntity) entity).getMaxHealth();
        }
        return 0.0;
    }

    public void setFood(int food) {
        if(entity instanceof Player) {
            ((Player) entity).setFoodLevel(food);
        }
    }
    public int getFood() {
        if(entity instanceof Player) {
            return ((Player) entity).getFoodLevel();
        }
        return 0;
    }

    public void setSaturation(float saturation) {
        if(entity instanceof Player) {
            ((Player) entity).setSaturation(saturation);
        }
    }

    public float getSaturation(float saturation) {
        if(entity instanceof Player) {
            return ((Player) entity).getSaturation();
        }
        return 0.0f;
    }
}
