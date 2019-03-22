package com.briup.party.service.impl;

import com.briup.party.bean.count.AcademyCount;
import com.briup.party.bean.count.CollegeCount;
import com.briup.party.bean.table.Academy;
import com.briup.party.bean.table.Branch;
import com.briup.party.bean.table.College;
import com.briup.party.dao.CollegeMapper;
import com.briup.party.service.IAcademyService;
import com.briup.party.service.ICollegeService;
import com.briup.party.service.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CollegeServiceImpl implements ICollegeService{
    private final CollegeMapper cm;
    private final ServiceUtil util;
    private final IAcademyService ias;
    @Autowired
    public CollegeServiceImpl(CollegeMapper cm, ServiceUtil util, IAcademyService ias) {
        this.cm = cm;
        this.util = util;
        this.ias = ias;
    }
    @Override
    public College findById(Short id) throws Exception {
        return   cm.selectByPrimaryKey(id);
    }

    @Override
    public List<Academy> findAcademyById(Short id) throws Exception {
        return util.getCollegeAcademy(id);
    }

    @Override
    public List<Branch> findBranchById(Short id) throws Exception {
        return util.getCollegeBranchs(id);
    }

    @Override
    public CollegeCount getCollegeCount(Short roleId) throws Exception {
        Short academyId = 0;
        List<Academy> academies = cm.findAcademyByCollegeId(roleId);
        AcademyCount academyCount = null;
        List<AcademyCount> academyCounts = new ArrayList<AcademyCount>();
        int storageNumber = 0,prepareNumber = 0,femaleNumber = 0,minorityNumber = 0,collegeNumber=0;
        for(Academy academy:academies){
            academyId = academy.getId();
            academyCount = ias.getAcademyCount(academyId);
            academyCounts.add(academyCount);
            storageNumber +=academyCount.getStorageNumber();
            prepareNumber +=academyCount.getPrepareNumber();
            femaleNumber += academyCount.getFemaleNumber();
            minorityNumber += academyCount.getMinorityNumber();
            collegeNumber +=academyCount.getCollegeNumber();
        }
        return new CollegeCount(findById(roleId).getName(),storageNumber,prepareNumber,femaleNumber,minorityNumber,collegeNumber,academyCounts);
    }

}
