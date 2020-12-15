package com.cssl.service.impl;

import com.cssl.dao.LiaoDrugDao;
import com.cssl.pojo.Lpharmacy;
import com.cssl.pojo.Lrecord;
import com.cssl.service.LiaoDrugService;
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
public class LiaoDrugServiceImpl implements LiaoDrugService {

    @Resource
    private LiaoDrugDao liaoDrugDao;

    @Override
    public List<Lpharmacy> selDrug(Lpharmacy lpharmacy) {
        return liaoDrugDao.selDrug(lpharmacy);
    }

    @Override
    public List<Lrecord> selDrugs(Lrecord lrecord) {
        return liaoDrugDao.selDrugs(lrecord);
    }

    @Override
    public int addDrug(Lrecord lrecord) {
        return liaoDrugDao.addDrug(lrecord);
    }

    @Override
    public int updDrug(Lrecord lrecord) {
        return liaoDrugDao.updDrug(lrecord);
    }

    @Override
    public int delDrug(Lrecord lrecord) {
        return liaoDrugDao.delDrug(lrecord);
    }

    @Override
    public int updDrugs(Lrecord lrecord) {
        return liaoDrugDao.updDrugs(lrecord);
    }

    @Override
    public int updNum(Lrecord lrecord) {
        return liaoDrugDao.updNum(lrecord);
    }

    @Override
    public int upd(Lrecord lrecord) {
        return liaoDrugDao.upd(lrecord);
    }
}
