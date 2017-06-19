package com.look.app.proposal.dao;

import com.look.app.proposal.model.opinion;
import com.look.utils.annotation.MyBatisScan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gaohongming on 2017/4/21.
 */
@MyBatisScan
@Repository
public interface opinionDao {
    int insertInfo(opinion opn);

    List<opinion> getAllOffer();
}
