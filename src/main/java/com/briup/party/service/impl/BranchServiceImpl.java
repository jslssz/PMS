package com.briup.party.service.impl;

import com.briup.party.bean.count.BranchCount;
import com.briup.party.bean.table.Branch;
import com.briup.party.dao.BranchMapper;
import com.briup.party.service.IBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BranchServiceImpl implements IBranchService {

    private final BranchMapper bm;

    @Autowired
    public BranchServiceImpl(BranchMapper bm) {
        this.bm = bm;
    }

    @Override
    public Branch findById(Short id) throws Exception {
        return  bm.selectByPrimaryKey(id);
    }
    //public BranchCount(String branchName, Short storageNumber, Short prepareNumber, Short femaleNumber,Short minorityNumber, Short collegeNumber) {
    @Override
    public BranchCount getBranchCount(Short id) throws Exception {
        Branch branch = findById(id);
//        todo 学历统计数据暂定为0.
        BranchCount branchCount = new BranchCount(branch.getName(),bm.getUserCount(id),bm.getprepareNumber(id),bm.getfemaleNumber(id),bm.getminorityNumber(id), (short) 0);
        return branchCount;
    }
}
