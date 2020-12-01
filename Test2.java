package ru.geekbrains.java_three.Lesson_6.homework;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

public class Test2 {
    @RunWith(Parameterized.class)
    public class Task2Test {
        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {{1, 1, 4, 4, 4, 1, 4, 1}, true},
                    {{1, 1, 4, 4, 4, 1, 4, 1}, false},
                    {{8, 8, 7, 7, 7, 3, 5, 1}, true},
                    {{8, 8, 7, 7, 7, 3, 5, 1}, false},
                    {{1, 4, 8, 7}, true},
                    {{1, 4, 8, 7}, false}
            });
        }
        private int[] in;
        private boolean out;

        public Task2Test(int[] in, boolean out) {
            this.in = in;
            this.out = out;
        }

        private Task2 task2;

        @Before
        public void startTest() {
            task2 = new Task2();
        }

        @Test
        public void testOnly1And4() {
            Assert.assertEquals(Task2.Only1And4(in), out);
        }
}
