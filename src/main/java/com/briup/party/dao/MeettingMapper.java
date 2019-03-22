package com.briup.party.dao;

import com.briup.party.bean.table.Meetting;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MeettingMapper {
    int deleteByPrimaryKey(Short id);

    int insert(Meetting record);

    int insertSelective(Meetting record);

    Meetting selectByPrimaryKey(Short id);

    int updateByPrimaryKeySelective(Meetting record);

    int updateByPrimaryKey(Meetting record);

    List<Meetting> findByUserIdArray(List<Short> list);

    List<Meetting> findByUserId(Short id);
}