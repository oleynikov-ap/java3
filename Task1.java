package ru.geekbrains.java_three.Lesson_6.homework;

public class Task1 {

    public static int[] AfterLast4(int[] arr) throws RuntimeException {
        int n = arr.length - 1;
        while (n >= 0 && arr[n] != 4) n--;
        if (n < 0) {
            int[] arrOut = new int[arr.length - n - 1];
            System.arraycopy(arr, n + 1, arrOut, 0, arr.length - n - 1);
            return arrOut;
        } else {
            throw new RuntimeException("4 не найдена");
        }
    }
}
