package ru.geekbrains.java_three.Lesson_1.homework;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

//    Написать метод, который меняет два элемента массива местами.
//    (массив может быть любого ссылочного типа);
    public static void change(Object[] arr, int i, int j) {
        System.out.println("Before: "+Arrays.toString(arr));
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        System.out.println("After: "+Arrays.toString(arr));
    }

//    Написать метод, который преобразует массив в ArrayList;
    public static <T> ArrayList<T> convert(T[] arr) {
        return new ArrayList<T>(Arrays.asList(arr));
    }

    public static void main(String[] args) {
        System.out.println("Первое задание");
        Integer ar1[] = {1, 2, 3, 4, 5, 6, 7};
        String ar2[] = {"A", "B", "C"} ;
        change(ar1,1,4);
        change(ar2,0,2);
    }
}
