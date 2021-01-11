package com.cssl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cssl.mapper.DrugDictionaryMapper;
import com.cssl.pojo.DrugDictionary;

import java.util.List;

public interface DrugDictionaryService extends IService<DrugDictionary> {
    List<DrugDictionaryMapper> findAllDrugDictionary(DrugDictionary drugdictionary);
}
