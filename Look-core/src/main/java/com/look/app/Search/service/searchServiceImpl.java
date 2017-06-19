package com.look.app.Search.service;

import com.look.app.Search.dao.searchDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by gaohongming on 2017/6/15.
 */
@Service
public class searchServiceImpl implements searchService {
    @Resource
    searchDao searchdao;
}
