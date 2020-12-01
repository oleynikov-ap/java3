package ru.geekbrains.java_three.Lesson_6.homework;

public class Task2 {
    public static boolean Only1And4(int[] arr) {
        boolean i1 = false, i4 = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) i1 = true;
            else if (arr[i] == 4) i4 = true;
        }
        return i1 && i4;
    }
}
