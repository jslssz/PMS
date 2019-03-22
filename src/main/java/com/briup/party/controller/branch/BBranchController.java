package com.briup.party.controller.branch;

import com.briup.party.bean.count.BranchCount;
import com.briup.party.bean.table.Branch;
import com.briup.party.service.IBranchService;
import com.briup.party.service.IUserService;
import com.briup.party.util.Constants;
import com.briup.party.util.MsgResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/branch")
@Api(description="党支部信息接口")
public class BBranchController{
    private final IBranchService ibs;
    private final IUserService ius;
    @Autowired
    public BBranchController(IBranchService ibs, IUserService ius) {
        this.ibs = ibs;
        this.ius = ius;
    }

    @RequiresRoles("branchAdmin")
    @GetMapping("findByBranchId")
    @ApiOperation(value = "传入党支部id返回单个党支部对象")
    public MsgResponse findByBranchId(Short id) throws Exception {
        Branch branch = ibs.findById(ius.getRoleId(Constants.BRANCH,id));
        return MsgResponse.success("branch",branch);
    }

    @RequiresRoles("branchAdmin")
    @GetMapping("getBranchCount")
    public MsgResponse getBranchCount(Short id) throws Exception {
        BranchCount branchCount = ibs.getBranchCount(ius.getRoleId(Constants.BRANCH,id));
        return MsgResponse.success("academy",branchCount);
    }
}
