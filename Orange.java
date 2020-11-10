package ru.geekbrains.java_three.Lesson_1.homework;

public class Orange extends Fruit {
    public Orange() {
        super(1.5f);
    }

    @Override
    public Fruit newInstance() {
        return new Orange();
    }
}