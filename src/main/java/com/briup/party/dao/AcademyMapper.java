package com.briup.party.dao;


import com.briup.party.bean.table.Academy;
import com.briup.party.bean.table.Branch;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcademyMapper {
    int deleteByPrimaryKey(Short id);

    int insert(Academy record);

    int insertSelective(Academy record);

    Academy selectByPrimaryKey(Short id);

    int updateByPrimaryKeySelective(Academy record);

    int updateByPrimaryKey(Academy record);

//    
    List<Branch> findBranchByIdArray(List<Short> list);

    List<Branch> findBranchById(Short academyId);

    Short getBranchCount(Short id);
}