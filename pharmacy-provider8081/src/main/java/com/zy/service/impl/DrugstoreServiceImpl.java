package com.zy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zy.dao.DrugstoreDao;
import com.cssl.pojo.Drugstore;
import com.zy.service.DrugstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DrugstoreServiceImpl extends ServiceImpl<DrugstoreDao, Drugstore> implements DrugstoreService {

    @Autowired
    private DrugstoreDao dd;

    @Override
    public List<Map<String, Object>> selectInsufficient(int page,int limit) {
        return dd.selectInsufficient(page,limit);
    }

    @Override
    public List<Map<String, Object>> selectGuoQi(int page,int limit) {
        return dd.selectGuoQi(page,limit);
    }

    @Override
    public int selectNum(String name) {
        return dd.selectNum(name);
    }

    @Override
    public int updateDrugstore(String drugstorenum, String batch) {
        return dd.updateDrugstore(drugstorenum,batch);
    }

    @Override
    public int updrugstore(Drugstore drugstore) {
        return dd.updrugstore(drugstore);
    }
}
