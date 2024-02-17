package net.realmofuz.xyraithlib.types;

import org.bukkit.Bukkit;
import org.bukkit.World;

public final class Location {
    double x = 0.0;
    double y = 0.0;
    double z = 0.0;
    float pitch = 0.0f;
    float yaw = 0.0f;
    World world;

    public org.bukkit.Location toBukkitLocation() {
        return new org.bukkit.Location(world, x, y, z, pitch, yaw);
    }

    public Location(double x, double y, double z) {
        this.world = Bukkit.getWorld("world");
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Location(double x, double y, double z, float pitch, float yaw) {
        this.world = Bukkit.getWorld("world");
        this.x = x;
        this.y = y;
        this.z = z;
        this.pitch = pitch;
        this.yaw = yaw;
    }

    public Location(org.bukkit.Location location) {
        this.x = location.x();
        this.y = location.y();
        this.z = location.z();
        this.pitch = location.getPitch();
        this.yaw = location.getYaw();
        this.world = location.getWorld();
    }

    public Location(World world, double x, double y, double z) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Location(World world, double x, double y, double z, float pitch, float yaw) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
        this.pitch = pitch;
        this.yaw = yaw;
    }

    public Location shiftX(float shift) {
        this.x += shift;
        return this;
    }

    public Location shiftY(float shift) {
        this.y += shift;
        return this;
    }

    public Location shiftZ(float shift) {
        this.z += shift;
        return this;
    }

    public Location shiftPitch(float shift) {
        this.pitch += shift;
        return this;
    }

    public Location shiftYaw(float shift) {
        this.yaw += shift;
        return this;
    }

    public Location shiftForward(float shift) {
        var vxz = -Math.cos(Math.toRadians(this.pitch));
        var vy = -Math.sin(Math.toRadians(this.pitch));
        var vx = -vxz * Math.sin(Math.toRadians(this.yaw));
        var vz = vxz * Math.cos(Math.toRadians(this.yaw));

        vx *= shift;
        vy *= shift;
        vz *= shift;

        this.x -= vx;
        this.y += vy;
        this.z -= vz;

        return this;
    }

    public Location clone() {
        return new Location(this.world, this.x, this.y, this.z, this.pitch, this.yaw);
    }

    public String toString() {
        return "[" + this.x + ", " + this.y + ", " + this.z + ", " + this.pitch + ", " + this.yaw + "]";
    }
}
