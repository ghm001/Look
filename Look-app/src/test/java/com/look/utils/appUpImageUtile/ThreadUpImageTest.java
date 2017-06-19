package com.look.utils.appUpImageUtile;

import com.look.utils.utilTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by gaohongming on 2017/5/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
public class ThreadUpImageTest {

    @Test
    public void get()
    {
        utilTest.get("%苹果%");
    }
}