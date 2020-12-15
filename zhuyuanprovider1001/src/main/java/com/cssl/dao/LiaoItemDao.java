package com.cssl.dao;

import com.cssl.pojo.Litem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author jalon
 * @date 2020-12-7 11:54
 */
@Mapper
public interface LiaoItemDao {

    List<Litem> selItems(Litem litem);

}
