package ru.geekbrains.java_three.Lesson_3.homework;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {public static void main(String[] args) {
    try {
        task1();
        task2();
        task3();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    // 1. Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль
    public static void task1() throws IOException {
        BufferedInputStream fis = new BufferedInputStream(new FileInputStream("d:/test_1.txt"));
        ByteArrayOutputStream fos = new ByteArrayOutputStream();
        int x;
        while ((x = fis.read()) != -1) {
            fos.write(x);
        }
        fis.close();
        byte[] b = fos.toByteArray();
        System.out.println(Arrays.toString(b));
        fos.close();
    }

    // 2. Последовательно сшить 5 файлов в один (файлы примерно 100 байт)
    public static void task2() throws IOException {
        long a = System.currentTimeMillis();

        ArrayList<InputStream> al = new ArrayList<>();
        al.add(new FileInputStream("d:/test2_1.txt"));
        al.add(new FileInputStream("d:/test2_2.txt"));
        al.add(new FileInputStream("d:/test2_3.txt"));
        al.add(new FileInputStream("d:/test2_4.txt"));
        al.add(new FileInputStream("d:/test2_5.txt"));

        BufferedInputStream fin = new BufferedInputStream(new SequenceInputStream(Collections.enumeration(al)));
        BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream("d:/out.txt"));
        int x;
        while ((x = fin.read()) != -1) {
            fos.write(x);
        }
        fin.close();
        System.out.println(fos.toString());
        fos.close();

        System.out.println(System.currentTimeMillis() - a);
    }

    // 3. Написать консольное приложение, которое умеет постранично читать текстовые файлы
    public static void task3() throws IOException {
        final int SIZE = 1800;
        RandomAccessFile raf = new RandomAccessFile("d:/test3.txt", "r");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите страницу: ");
        int p = sc.nextInt() - 1;
        raf.seek(p * SIZE);
        byte[] page = new byte[1800];
        raf.read(page);
        System.out.println(new String(page));
        raf.close();
    }
}
