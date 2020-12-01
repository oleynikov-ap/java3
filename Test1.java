package ru.geekbrains.java_three.Lesson_6.homework;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

public class Test1 {
    @RunWith(Parameterized.class)
    public class Task1Test {
        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {1, 6, 5, 4, 2, 3, 3},
                    {2, 3, 3},
                    {2, 3, 4},
                    {4, 3, 7, 5, 4, 4, 3, 2},
                    {3, 2},
                    {1, 6, 4, 2, 3},
                    {4, 3, 7, 5, 4},
            });
        }

        private int[] in;
        private int[] out;

        public Task1Test(int[] in, int[] out) {
            this.in = in;
            this.out = out;
        }

        private Task1 task1;

        @Before
        public void startTest() {
            task1 = new Task1();
        }

        @Test
        public void testAfterLast4() {
            Assert.assertArrayEquals(out, Task1.AfterLast4(in));
        }

        @Test(expected = RuntimeException.class)
        public void testAfterLast4Ex() {
            Task1.AfterLast4(new int[]{0, 3, 7, 5, 0, 0, 3, 2});
        }
    }
}
