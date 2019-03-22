package com.briup.party.dao;

import com.briup.party.bean.table.OfftenMeettingArray;
import org.springframework.stereotype.Repository;

@Repository
public interface OfftenMeettingArrayMapper {
    int deleteByPrimaryKey(Short id);

    int insert(OfftenMeettingArray record);

    int insertSelective(OfftenMeettingArray record);

    OfftenMeettingArray selectByPrimaryKey(Short id);

    int updateByPrimaryKeySelective(OfftenMeettingArray record);

    int updateByPrimaryKey(OfftenMeettingArray record);
}