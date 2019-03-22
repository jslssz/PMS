package com.briup.party.dao;

import com.briup.party.bean.table.Academy;
import com.briup.party.bean.table.College;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollegeMapper {
    int deleteByPrimaryKey(Short id);

    int insert(College record);

    int insertSelective(College record);

    College selectByPrimaryKey(Short id);

    int updateByPrimaryKeySelective(College record);

    int updateByPrimaryKey(College record);

//
    List<Academy> findAcademyByCollegeId(Short collegeId);
}