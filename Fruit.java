package ru.geekbrains.java_three.Lesson_1.homework;

public abstract class Fruit {
    protected float weight;

    public abstract Fruit newInstance();

    public Fruit(float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return weight;
    }
}