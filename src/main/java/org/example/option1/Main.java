package org.example.option1;

public class Main {
    public static void main(String[] args) {
        Vector vector1 = new Vector(3, 4, 5);
        Vector vector2 = new Vector(1, 2, 3);

        System.out.println("Вектор 1: " + vector1);
        System.out.println("Вектор 2: " + vector2);

        System.out.println("Вектор 1 - X: " + vector1.getX() + ", Y: " + vector1.getY() + ", Z: " + vector1.getZ());
        System.out.println("Вектор 2 - X: " + vector2.getX() + ", Y: " + vector2.getY() + ", Z: " + vector2.getZ());

        System.out.println("Длина Вектора 1: " + VectorUtils.getLength(vector1));
        System.out.println("Длина Вектора 2: " + VectorUtils.getLength(vector2));

        double scalarProduct = VectorUtils.multiplyScalar(vector1, vector2);
        System.out.println("Скалярное произведение Вектора 1 и Вектора 2: " + scalarProduct);

        Vector sumVector = VectorUtils.sum(vector1, vector2);
        System.out.println("Сумма Вектора 1 и Вектора 2: " + sumVector);

        Vector subtractVector = VectorUtils.subtract(vector1, vector2);
        System.out.println("Вычитание Вектора 2 из Вектора 1: " + subtractVector);

        Vector crossProductVector = VectorUtils.multiplyVector(vector1, vector2);
        System.out.println("Векторное произведение Вектора 1 и Вектора 2: " + crossProductVector);

        try {
            double angle = VectorUtils.getAngleTo(vector1, vector2);
            System.out.println("Косинус угла между Вектором 1 и Вектором 2: " + Math.cos(angle));
            System.out.println("Угол в радианах: " + angle);
            System.out.println("Угол в градусах: " + Math.toDegrees(angle));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        int arraySize = 5;
        Vector[] randomVectors = VectorGenerator.generateArray(arraySize);
        System.out.println("Сгенерированный массив случайных векторов:");
        for (Vector v : randomVectors) {
            System.out.println(v);
        }
    }
}
