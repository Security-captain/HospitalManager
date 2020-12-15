package com.cssl.service.impl;

import com.cssl.dao.LiaoPayDao;
import com.cssl.pojo.Lrecord;
import com.cssl.pojo.Pay;
import com.cssl.pojo.Register;
import com.cssl.service.LiaoPayService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jalon
 * @date 2020-12-7 11:53
 */
@Service
@Transactional
public class LiaoPayServiceImpl implements LiaoPayService {

    @Resource
    private LiaoPayDao liaoPayDao;

    @Override
    public int updPay(Register register) {
        return liaoPayDao.updPay(register);
    }

    @Override
    public int addPay(Register register) {
        return liaoPayDao.addPay(register);
    }

    @Override
    public List<Pay> selPays(Register register) {
        return liaoPayDao.selPays(register);
    }

    @Override
    public List<Lrecord> selSurplus(Lrecord lrecord) {
        return liaoPayDao.selSurplus(lrecord);
    }

}
