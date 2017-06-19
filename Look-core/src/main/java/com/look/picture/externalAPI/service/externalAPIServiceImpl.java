package com.look.picture.externalAPI.service;

import com.look.picture.externalAPI.dao.externalAPIDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by gaohongming on 2017/5/25.
 */
@Service
public class externalAPIServiceImpl implements externalAPIService {
    @Resource
    externalAPIDao   externalapidao;
}
