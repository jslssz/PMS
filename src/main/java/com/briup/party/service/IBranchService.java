package com.briup.party.service;

import com.briup.party.bean.count.BranchCount;
import com.briup.party.bean.table.Branch;

public interface IBranchService{
	Branch findById(Short id) throws Exception;
	BranchCount getBranchCount(Short id) throws Exception;
}
