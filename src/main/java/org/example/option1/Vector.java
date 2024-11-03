package org.example.option1;

public final class Vector {
    private final int x, y, z;

    public Vector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    public double getLength() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }

    public double multiplyScalar(Vector vector) {
        return this.getX() * vector.getX() + this.getY() * vector.getY() + this.getZ() * vector.getZ();
    }

    public Vector sum(Vector vector) {
        return new Vector(this.getX() + vector.getX(), this.getY() + vector.getY(), this.getZ() + vector.getZ());
    }

    public Vector subtract(Vector vector) {
        return new Vector(this.getX() - vector.getX(), this.getY() - vector.getY(), this.getZ() - vector.getZ());
    }

    public Vector multiplyVector(Vector vector) {
        return new Vector(
                this.getY() * vector.getZ() - this.getZ() * vector.getY(),
                this.getZ() * vector.getX() - this.getX() * vector.getZ(),
                this.getX() * vector.getY() - this.getY() * vector.getX());
    }

    public double getAngleTo(Vector vector) {
        if(this.getLength() == 0 || vector.getLength() == 0)
            throw new RuntimeException("Векторы должны быть ненулевыми");
        double cosTheta = this.multiplyScalar(vector) / (this.getLength() * vector.getLength());
        return Math.acos(Math.min(1.0, Math.max(-1.0, cosTheta)));
    }

    public static Vector[] generateArray(int arraySize) {
        Vector[] vectors = new Vector[arraySize];
        for (int i = 0; i < arraySize; i++) {
            vectors[i] = new Vector(
                    (int) Math.floor(Math.random() * arraySize),
                    (int) Math.floor(Math.random() * arraySize),
                    (int) Math.floor(Math.random() * arraySize));
        }
        return vectors;
    }
}
