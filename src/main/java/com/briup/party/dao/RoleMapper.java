package com.briup.party.dao;

import com.briup.party.bean.table.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper {
    int deleteByPrimaryKey(Short id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Short id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}