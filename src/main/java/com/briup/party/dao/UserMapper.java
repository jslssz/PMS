package com.briup.party.dao;

import com.briup.party.bean.table.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Short id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Short id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    String getPassword(String username);

    String getName(String username);

    Short findIdByUsername(String username);
}