package com.briup.party.service;

import com.briup.party.bean.count.AcademyCount;
import com.briup.party.bean.table.Academy;
import com.briup.party.bean.table.Branch;

import java.util.List;
public interface IAcademyService {
    Academy findById(Short id) throws Exception;
    List<Branch> findBranchById(Short id) throws Exception;

    AcademyCount getAcademyCount(Short id) throws Exception;
}
