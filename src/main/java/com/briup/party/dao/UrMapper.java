package com.briup.party.dao;

import com.briup.party.bean.table.Ur;
import org.springframework.stereotype.Repository;

@Repository
public interface UrMapper {
    int deleteByPrimaryKey(Short id);

    int insert(Ur record);

    int insertSelective(Ur record);

    Ur selectByPrimaryKey(Short id);

    int updateByPrimaryKeySelective(Ur record);

    int updateByPrimaryKey(Ur record);

    void deleteByUserId(Short userId);
}