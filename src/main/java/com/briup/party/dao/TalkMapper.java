package com.briup.party.dao;

import com.briup.party.bean.table.Talk;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TalkMapper {
    int deleteByPrimaryKey(Short id);

    int insert(Talk record);

    int insertSelective(Talk record);

    Talk selectByPrimaryKey(Short id);

    int updateByPrimaryKeySelective(Talk record);

    int updateByPrimaryKey(Talk record);

    List<Talk> findByUserIdArray(List<Short> list);

    List<Talk> findByUserId(Short id);
}