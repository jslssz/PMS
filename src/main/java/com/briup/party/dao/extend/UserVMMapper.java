package com.briup.party.dao.extend;

import com.briup.party.bean.table.Branch;
import com.briup.party.bean.tableVM.Msgmodal;
import org.springframework.stereotype.Repository;

@Repository
public interface UserVMMapper {

	Msgmodal findById(Short id);

    String getRole(String username);

    String getRoleById(Short id);

    Branch findBranchById(Short id);
}
