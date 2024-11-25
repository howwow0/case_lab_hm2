package org.example.option1;

public class VectorUtils {

    public static double getLength(Vector vector) {
        return Math.sqrt(Math.pow(vector.getX(), 2) + Math.pow(vector.getY(), 2) + Math.pow(vector.getZ(), 2));
    }

    public static double multiplyScalar(Vector vector1, Vector vector2) {
        return vector1.getX() * vector2.getX() + vector1.getY() * vector2.getY() + vector1.getZ() * vector2.getZ();
    }

    public static double getAngleTo(Vector vector1, Vector vector2) {
        double length1 = getLength(vector1);
        double length2 = getLength(vector2);

        if (length1 == 0 || length2 == 0) {
            throw new RuntimeException("Векторы должны быть ненулевыми");
        }

        double cosTheta = multiplyScalar(vector1, vector2) / (length1 * length2);
        return Math.acos(Math.min(1.0, Math.max(-1.0, cosTheta)));
    }

    public static Vector sum(Vector vector1, Vector vector2) {
        return new Vector(vector1.getX() + vector2.getX(), vector1.getY() + vector2.getY(), vector1.getZ() + vector2.getZ());
    }

    public static Vector subtract(Vector vector1, Vector vector2) {
        return new Vector(vector1.getX() - vector2.getX(), vector1.getY() - vector2.getY(), vector1.getZ() - vector2.getZ());
    }

    public static Vector multiplyVector(Vector vector1, Vector vector2) {
        return new Vector(
                vector1.getY() * vector2.getZ() - vector1.getZ() * vector2.getY(),
                vector1.getZ() * vector2.getX() - vector1.getX() * vector2.getZ(),
                vector1.getX() * vector2.getY() - vector1.getY() * vector2.getX());
    }
}
