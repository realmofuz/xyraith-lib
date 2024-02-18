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

    public Location shift(double x, double y, double z) {
        this.x += x;
        this.y += y;
        this.z += z;
        return this;
    }

    public Location shift(Vector vector) {
        this.x += vector.getX();
        this.y += vector.getY();
        this.z += vector.getZ();
        return this;
    }

    public Location shift(double x, double y, double z, float pitch, float yaw) {
        this.x += x;
        this.y += y;
        this.z += z;
        this.pitch += pitch;
        this.yaw += yaw;
        return this;
    }


    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    public float getPitch() {
        return this.pitch;
    }

    public float getYaw() {
        return this.yaw;
    }

    public World getBukkitWorld() {
        return this.world;
    }

    public Vector getDirection() {
        var vxz = -Math.cos(Math.toRadians(this.pitch));
        var vy = -Math.sin(Math.toRadians(this.pitch));
        var vx = -vxz * Math.sin(Math.toRadians(this.yaw));
        var vz = vxz * Math.cos(Math.toRadians(this.yaw));
        return new Vector(vx, vy, vz);
    }

    public Location setDirection(Vector vector) {
        var x = vector.getX();
        var z = vector.getZ();

        if(x == 0 && z == 0) {
            if(vector.getY() > 0) {
                this.pitch = -90;
            } else {
                this.pitch = 90;
            }
            return this;
        }

        this.yaw = (float) Math.toDegrees((Math.atan2(-x, z) + Math.TAU) % Math.TAU);
        this.pitch = (float) Math.toDegrees(Math.atan(-vector.getY() / (Math.sqrt(Math.pow(x, 2) + Math.pow(z, 2)))));
        return this;
    }

    public Location shiftForward(float shift) {
        return this.shift(this.getDirection().multiply(shift));
    }

    public Location faceLocation(Location other) {
        return this.setDirection(other.toVector().subtract(this.toVector()));
    }

    public Location clone() {
        return new Location(this.world, this.x, this.y, this.z, this.pitch, this.yaw);
    }

    public String toString() {
        return "[" + this.x + ", " + this.y + ", " + this.z + ", " + this.pitch + ", " + this.yaw + "]";
    }

    public Vector toVector() {
        return new Vector(this.x, this.y, this.z);
    }
}
