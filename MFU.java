package ru.geekbrains.java_three.Lesson_4.homework;

public class MFU {
    Object print = new Object();
    Object scan = new Object();

    public void print(String doc, int n) {
        synchronized (print) {
            System.out.println("Начинается печать документа: " + doc);
            for (int i = 1; i <= n; i++) {
                System.out.println("PRINT: Страница " + i + " документа " + doc + " печатается...");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Печать документа " + doc + " завершена.");
    }

    public void scan(String doc, int n) {
        synchronized (scan) {
            System.out.println("Начинается сканирование документа: " + doc);
            for (int i = 1; i <= n; i++) {
                System.out.println("SCAN: Страница " + i + " документа " + doc + " сканируется...");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Сканирование документа " + doc + " завершено.");
    }
    public void xerox(String doc, int n) {
        synchronized (scan) {
            System.out.println("Начинается ксерокопия. ");
            for (int i = 1; i <= n; i++) {
                System.out.println("XEROX: Страница " + i + " сканируется...");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        synchronized (print) {
            for (int i = 1; i <= n; i++) {
                System.out.println("XEROX: Страница " + i + " печатается...");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Ксерокопирование завершено.");
    }

    public static void main(String[] args) {
        MFU mfu = new MFU();
        new Thread(() -> mfu.scan("A", 4)).start();
        new Thread(() -> mfu.print("В", 4)).start();
        new Thread(() -> mfu.xerox("С", 7)).start();
    }
}