package ru.geekbrains.java_three.Lesson_4.homework;

public class task1 {
    static volatile char symvol = 'A';
    static Object monitor = new Object();

    static class WaitNotifyClass implements Runnable {
        private char currentLetter;
        private char nextLetter;

        public WaitNotifyClass(char currentLetter, char nextLetter) {
            this.currentLetter = currentLetter;
            this.nextLetter = nextLetter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                synchronized (monitor) {
                    try {
                        while (symvol != currentLetter)
                            monitor.wait();
                        System.out.print(currentLetter);
                        symvol = nextLetter;
                        monitor.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("Task1");
        new Thread(new WaitNotifyClass('A', 'B')).start();
        new Thread(new WaitNotifyClass('B', 'C')).start();
        new Thread(new WaitNotifyClass('C', 'A')).start();
    }
}
