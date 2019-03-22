package com.briup.party.dao;

import com.briup.party.bean.table.Useretd;
import org.springframework.stereotype.Repository;

@Repository
public interface UseretdMapper {
    int deleteByPrimaryKey(Short id);

    int insert(Useretd record);

    int insertSelective(Useretd record);

    Useretd selectByPrimaryKey(Short id);

    int updateByPrimaryKeySelective(Useretd record);

    int updateByPrimaryKey(Useretd record);
}