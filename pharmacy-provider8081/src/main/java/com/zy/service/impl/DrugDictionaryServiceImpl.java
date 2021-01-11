package com.zy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.pojo.DrugDictionary;
import com.zy.dao.DrugDictionaryDao;
import com.zy.service.DrugDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DrugDictionaryServiceImpl extends ServiceImpl<DrugDictionaryDao, DrugDictionary> implements DrugDictionaryService {

    @Autowired
    private DrugDictionaryDao dd;

    @Override
    public List<Map<String, Object>> selectDrugDictionary(String name) {
        return dd.selectDrugDictionary(name);
    }
}
