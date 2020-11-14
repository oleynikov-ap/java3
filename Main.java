package ru.geekbrains.java_three.Lesson_5.homework;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static final int CARS_COUNT = 4;
    public static final int TUNNEL_CARS = CARS_COUNT/2;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Semaphore smp = new Semaphore(TUNNEL_CARS);
        CountDownLatch[] cdl = new CountDownLatch[2];
        cdl[0] = new CountDownLatch(CARS_COUNT);
        cdl[1] = new CountDownLatch(CARS_COUNT);
        Race race = new Race(new Road(60), new Tunnel(smp), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), cdl, smp);
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        try {
            cdl[0].await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        cdl[1].await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}
