package org.example.option1;

public class VectorGenerator {
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
