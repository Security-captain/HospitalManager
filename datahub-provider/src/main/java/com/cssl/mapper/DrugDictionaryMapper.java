package com.cssl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cssl.pojo.DrugDictionary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrugDictionaryMapper extends BaseMapper<DrugDictionary> {
    List<DrugDictionaryMapper> findAllDrugDictionary(DrugDictionary sdrugdictionary);
}
