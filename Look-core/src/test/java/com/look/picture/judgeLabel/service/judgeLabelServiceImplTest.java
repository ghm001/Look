package com.look.picture.judgeLabel.service;

import com.look.picture.judgeLabel.model.judgetable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by gaohongming on 2017/5/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
public class judgeLabelServiceImplTest {
    @Resource
    judgeLabelService judgeservice;
    @Test
    public void saveLabelAtFirst() throws Exception {

      /*  judgetable  j=new judgetable();
        judgeservice.saveLabelAtFirst(j);
        System.out.println(j.getId());*/
    }

}