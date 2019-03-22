package com.briup.party.dao;

import com.briup.party.bean.table.Object;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObjectMapper {
    int deleteByPrimaryKey(Short id);

    int insert(Object record);

    int insertSelective(Object record);

    Object selectByPrimaryKey(Short id);

    int updateByPrimaryKeySelective(Object record);

    int updateByPrimaryKey(Object record);

    List<Object> findByUserIdArray(List<Short> list);

    List<Object> findByUserId(Short id);
}