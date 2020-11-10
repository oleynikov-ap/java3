package ru.geekbrains.java_three.Lesson_1.homework;

public class Apple extends Fruit {
    public Apple() {
        super(1f);
    }

    @Override
    public Fruit newInstance() {
        return new Apple();
    }
}
