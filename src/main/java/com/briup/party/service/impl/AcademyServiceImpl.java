package com.briup.party.service.impl;

import com.briup.party.bean.count.AcademyCount;
import com.briup.party.bean.count.BranchCount;
import com.briup.party.bean.table.Academy;
import com.briup.party.bean.table.Branch;
import com.briup.party.dao.AcademyMapper;
import com.briup.party.dao.BranchMapper;
import com.briup.party.service.IAcademyService;
import com.briup.party.service.IBranchService;
import com.briup.party.service.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AcademyServiceImpl implements IAcademyService {
    private final ServiceUtil util;
    private final AcademyMapper am;
    private final BranchMapper bm;
    private final IBranchService ibs;

    @Autowired
    public AcademyServiceImpl(ServiceUtil util, AcademyMapper am, BranchMapper bm, IBranchService ibs) {
        this.util = util;
        this.am = am;
        this.bm = bm;
        this.ibs = ibs;
    }

    @Override
    public Academy findById(Short id) throws Exception {
        int a=1;
        short c = (short)a;
        return  am.selectByPrimaryKey(id);
    }

    /**
     * @param id academuyId
     * @return 返回该academy下的所有branch
     * @throws Exception
     */
    @Override
    public List<Branch> findBranchById(Short id) throws Exception {
        return  util.getAcademybranchs(id);
    }

//public AcademyCount(String academyName, Short branchNum, Short storageNumber, Short prepareNumber, Short femaleNumber, Short minorityNumber, Short collegeNumber) {
@Override
public AcademyCount getAcademyCount(Short id) throws Exception {
    List<Branch> branchs = am.findBranchById(id);
    Short branchId = 0;
    List<BranchCount> list = new ArrayList<BranchCount>();
//        todo 学历统计数据暂定为0.
    int userCount=0,prepareNum=0,femaleNum=0,minorityNum=0,collegeNum = 0;
    for(Branch branch:branchs){
        branchId= branch.getId();
        list.add(ibs.getBranchCount(branchId));
        userCount += bm.getUserCount(branchId);
        prepareNum +=bm.getprepareNumber(branchId);
        femaleNum += bm.getfemaleNumber(branchId);
        minorityNum +=bm.getminorityNumber(branchId);
    }
    return new AcademyCount(findById(id).getName(),userCount,prepareNum,femaleNum,minorityNum, collegeNum,list);
}
}
