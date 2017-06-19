package com.look.app.proposal.service;

import com.look.app.proposal.model.opinion;
import com.look.utils.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by gaohongming on 2017/5/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")

public class opinionServiceImplTest {
    @Resource
    opinionService opiniona;
    @Test
    public void insertInfo() throws Exception {

    }

    @Test
    public void getAllOffer() throws Exception {
           List<opinion> list=opiniona.getAllOffer();
        for (int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i).toString());
        }
        System.out.println(JsonUtil.listJson(list));
    }

}