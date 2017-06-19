package com.look.app.proposal.service;

import com.look.app.proposal.model.opinion;

import java.util.List;

/**
 * Created by gaohongming on 2017/4/21.
 */
public interface opinionService {
    int insertInfo(opinion opn);

    List<opinion> getAllOffer();
}
