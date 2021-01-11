package com.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.mapper.DrugDictionaryMapper;
import com.cssl.pojo.DrugDictionary;
import com.cssl.service.DrugDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugDictionaryServiceImpl extends ServiceImpl<DrugDictionaryMapper, DrugDictionary> implements DrugDictionaryService {

    @Autowired
    private DrugDictionaryMapper drugDictionaryMapper;

    @Override
    public List<DrugDictionaryMapper> findAllDrugDictionary(DrugDictionary drugdictionary) {
        return drugDictionaryMapper.findAllDrugDictionary(drugdictionary);
    }
}
