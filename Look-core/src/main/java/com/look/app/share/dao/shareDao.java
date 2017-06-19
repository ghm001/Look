package com.look.app.share.dao;

import com.look.app.share.model.share;
import com.look.utils.annotation.MyBatisScan;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by gaohongming on 2017/4/24.
 */
@MyBatisScan
@Repository
public interface shareDao {
    void saveShare(share sh);

    List<share> getSomeShare(int id);

    void deleteOneShare(int id);

    List<share> getUserShare(int id);

    List<share> getTop10();
}
