package com.briup.party.service;

import com.briup.party.bean.count.CollegeCount;
import com.briup.party.bean.table.Academy;
import com.briup.party.bean.table.Branch;
import com.briup.party.bean.table.College;

import java.util.List;
public interface ICollegeService {
    College findById(Short id) throws Exception;
    List<Academy> findAcademyById(Short id) throws Exception;
    List<Branch> findBranchById(Short id) throws Exception;

    CollegeCount getCollegeCount(Short roleId) throws Exception;
}
