package com.xdynamics;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test_file() {

        File file = new File("C:\\Users\\Administrator\\Desktop\\Mix\\test2.jpg");

        System.out.printf("path: %s, \n name: %s, \n size: %s", file.getAbsolutePath(), file.getName(), file.length());

    }


}