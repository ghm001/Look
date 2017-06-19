package com.look.app.share.service;

import com.look.app.share.dao.shareDao;
import com.look.app.share.model.share;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gaohongming on 2017/4/24.
 */
@Service
public class shareServiceImpl implements shareService {
    @Resource
    shareDao sharedao;

    @Override
    public void saveShare(share sh) {
           sharedao.saveShare(sh);
    }

    @Override
    public List<share> getSomeShare(int id) {
        return sharedao.getSomeShare(id);
    }

    @Override
    public void deleteOneShare(int id) {
        sharedao.deleteOneShare(id);
    }

    @Override
    public List<share> getUserShare(int id) {
       return sharedao.getUserShare(id);

    }

    @Override
    public List<share> getTop10() {
        return sharedao.getTop10();
    }
}
