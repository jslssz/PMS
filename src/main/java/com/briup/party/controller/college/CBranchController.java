package com.briup.party.controller.college;

import com.briup.party.bean.table.Branch;
import com.briup.party.controller.IBranchController;
import com.briup.party.service.ICollegeService;
import com.briup.party.service.IUserService;
import com.briup.party.util.Constants;
import com.briup.party.util.MsgResponse;
import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/college/branch")
@Api(description="学校下党支部信息接口")
public class CBranchController implements IBranchController{
    private final ICollegeService ics;
    private final IUserService ius;


    @Autowired
    public CBranchController(ICollegeService ics, IUserService ius) {
        this.ics = ics;
        this.ius = ius;
    }

    @RequiresRoles("collegeAdmin")
    @Override
    public MsgResponse findAllBranch(Short id) throws Exception {
        List<Branch> branchs = ics.findBranchById(ius.getRoleId(Constants.COLLEGE,id));
        return MsgResponse.success("college",branchs);
    }
}
