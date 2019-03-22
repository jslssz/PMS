package com.briup.party.controller.academy;

import com.briup.party.bean.table.Branch;
import com.briup.party.controller.IBranchController;
import com.briup.party.service.IAcademyService;
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
@RequestMapping("/academy/branch")
@Api(description="学院下党支部信息接口")
public class ABranchController implements IBranchController{
    private final IUserService ius;
    private final IAcademyService ias;
    @Autowired
    public ABranchController(IUserService ius, IAcademyService ias) {
        this.ius = ius;
        this.ias = ias;
    }

    @RequiresRoles("academyAdmin")
    @Override
    public MsgResponse findAllBranch(Short id) throws Exception {
        List<Branch> branchs = ias.findBranchById(ius.getRoleId(Constants.ACADEMY,id));
        return MsgResponse.success("academy",branchs);
    }
}

