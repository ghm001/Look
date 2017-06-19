package com.look.app.share.service;

import com.look.app.share.model.share;

import java.util.List;

/**
 * Created by gaohongming on 2017/4/24.
 */
public interface shareService {
    void saveShare(share sh);

    List<share> getSomeShare(int id);

    void deleteOneShare(int id);

    List<share> getUserShare(int id);

    List<share> getTop10();
}
