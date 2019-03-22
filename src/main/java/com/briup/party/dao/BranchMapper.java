package com.briup.party.dao;

import com.briup.party.bean.table.Branch;
import com.briup.party.bean.table.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchMapper {
    int deleteByPrimaryKey(Short id);

    int insert(Branch record);

    int insertSelective(Branch record);

    Branch selectByPrimaryKey(Short id);

    int updateByPrimaryKeySelective(Branch record);

    int updateByPrimaryKey(Branch record);

//    

    List<User> findUserByIdArray(List<Short> list);

    List<User> findUserById(Short id);

    Short getUserCount(Short id);

    Short getprepareNumber(Short id);

    Short getfemaleNumber(Short id);

    Short getminorityNumber(Short id);
}