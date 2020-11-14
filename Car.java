package ru.geekbrains.java_three.Lesson_5.homework;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static ru.geekbrains.java_three.Lesson_5.homework.Main.TUNNEL_CARS;

public class Car implements Runnable {
    private static int CARS_COUNT;

    private Race race;
    private int speed;
    private String name;
    private Semaphore smp ;
    private CountDownLatch[] cdl;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CountDownLatch[] cdl, Semaphore smp) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.cdl = cdl;
        this.smp = smp;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            cdl[0].countDown();
            cdl[0].await();
            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }
            checkWinner(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private synchronized void checkWinner(Car c) {
        this.cdl[1].countDown();
        if (this.cdl[1].getCount() == CARS_COUNT - 1){
            try {
                this.cdl[1].await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(c.name + " - WIN");
        }
    }
}