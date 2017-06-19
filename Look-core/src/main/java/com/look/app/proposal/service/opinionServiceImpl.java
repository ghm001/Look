package com.look.app.proposal.service;

import com.look.app.proposal.dao.opinionDao;
import com.look.app.proposal.model.opinion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gaohongming on 2017/4/21.
 */
@Service
public class opinionServiceImpl implements opinionService {
   @Resource
    opinionDao opiniondao;


    public int insertInfo(opinion opn) {
        return opiniondao.insertInfo(opn);
    }

    @Override
    public List<opinion> getAllOffer() {
        return opiniondao.getAllOffer();
    }
}
