package com.cssl.service.impl;

import com.cssl.dao.LiaoItemDao;
import com.cssl.pojo.Litem;
import com.cssl.service.LiaoItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jalon
 * @date 2020-12-7 11:52
 */
@Service
@Transactional
public class LiaoItemServiceImpl implements LiaoItemService {

    @Resource
    private LiaoItemDao liaoItemDao;

    @Override
    public List<Litem> selItems(Litem litem) {
        return liaoItemDao.selItems(litem);
    }
}
