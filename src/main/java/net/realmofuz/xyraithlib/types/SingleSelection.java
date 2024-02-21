package net.realmofuz.xyraithlib.types;

import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.title.Title;
import net.realmofuz.xyraithlib.Utils;
import net.realmofuz.xyraithlib.actions.EntityDataStorage;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_20_R3.entity.CraftPlayer;
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

    public void showBossbar(String name, float progress, BossBar.Color color, BossBar.Overlay overlay) {
        entity.showBossBar(BossBar.bossBar(
                Utils.deserialize(name),
                progress,
                color,
                overlay
        ));
    }

    public void displayBlock(Location location, Material material) {
        if(entity instanceof Player) {
            ((Player) entity).sendBlockChange(location.toBukkitLocation(), material.createBlockData());
        }
    }

    public void displayBlockDamage(Location location, int damage) {
        if(entity instanceof Player) {
            ((Player) entity).sendBlockDamage(location.toBukkitLocation(), damage);
        }
    }

    public void playSound(Location location, Sound sound) {
        if(entity instanceof Player) {
            ((Player) entity).playSound(location.toBukkitLocation(), sound, 2.0f, 1.0f);
        }
    }

    public void playSound(Location location, Sound sound, float volume) {
        if(entity instanceof Player) {
            ((Player) entity).playSound(location.toBukkitLocation(), sound, volume, 1.0f);
        }
    }

    public void playSound(Location location, Sound sound, float volume, float pitch) {
        if(entity instanceof Player) {
            ((Player) entity).playSound(location.toBukkitLocation(), sound, volume, pitch);
        }
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

    public void playParticle(Particle particle, Location location) {
        if(entity instanceof Player) {
            particle.render(location, (Player) entity);
        }
    }

    public Location getLocation() {
        return new Location(entity.getLocation());
    }

    public Location getEyeLocation() {
        return new Location(entity.getLocation()).shiftY(1.8f);
    }

    public void setTag(String key, Object value) {
        EntityDataStorage.set(entity.getUniqueId(), value);
    }

    public Object getTag(String key) {
        return EntityDataStorage.get(entity.getUniqueId());
    }
}
