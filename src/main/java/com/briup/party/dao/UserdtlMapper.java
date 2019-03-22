package com.briup.party.dao;

import com.briup.party.bean.table.Userdtl;
import org.springframework.stereotype.Repository;

@Repository
public interface UserdtlMapper {
    int deleteByPrimaryKey(Short id);

    int insert(Userdtl record);

    int insertSelective(Userdtl record);

    Userdtl selectByPrimaryKey(Short id);

    int updateByPrimaryKeySelective(Userdtl record);

    int updateByPrimaryKey(Userdtl record);
}