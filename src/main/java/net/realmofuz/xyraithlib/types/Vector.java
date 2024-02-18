package net.realmofuz.xyraithlib.types;

public class Vector {
    double x = 0.0;
    double y = 0.0;
    double z = 0.0;

    public Vector(org.bukkit.util.Vector vector) {
        this.x = vector.getX();
        this.y = vector.getY();
        this.z = vector.getZ();
    }

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector add(Vector other) {
        this.x += other.x;
        this.y += other.y;
        this.z += other.z;
        return this;
    }

    public Vector subtract(Vector other) {
        this.x -= other.x;
        this.y -= other.y;
        this.z -= other.z;
        return this;
    }

    public Vector multiply(float other) {
        this.x *= other;
        this.y *= other;
        this.z *= other;
        return this;
    }

    public Vector normalize() {
        var magnitude = this.getMagnitude();
        this.x /= magnitude;
        this.y /= magnitude;
        this.z /= magnitude;
        return this;
    }

    public double getMagnitude() {
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
    }

    public double getMagnitudeSquared() {
        return Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }
}
