package net.realmofuz.xyraithlib.types;

import org.bukkit.block.data.type.Bed;
import org.bukkit.entity.Player;

public class Particle {
    ParticleType particleType;
    int amount = 1;
    int spreadX = 0;
    int spreadY = 0;
    int spreadZ = 0;
    int speed = 0;

    protected void render(Location location, Player player) {
        player.spawnParticle(
                particleType.particleTypeToBukkitParticle(),
                location.toBukkitLocation(),
                amount,
                spreadX,
                spreadY,
                spreadZ,
                speed
        );
    }

    public Particle(ParticleType particleType) {
        this.particleType = particleType;
    }

    public Particle setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public Particle setSpreadX(int spreadX) {
        this.spreadX = spreadX;
        return this;
    }

    public Particle setSpreadY(int spreadY) {
        this.spreadY = spreadY;
        return this;
    }

    public Particle setSpreadZ(int spreadZ) {
        this.spreadZ = spreadZ;
        return this;
    }

    public Particle setSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    public int getAmount() {
        return this.amount;
    }

    public int getSpreadX() {
        return this.spreadX;
    }

    public int getSpreadY() {
        return this.spreadY;
    }

    public int getSpreadZ() {
        return this.spreadZ;
    }


}
