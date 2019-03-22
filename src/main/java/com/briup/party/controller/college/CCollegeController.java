package com.briup.party.controller.college;

import com.briup.party.bean.count.CollegeCount;
import com.briup.party.bean.table.College;
import com.briup.party.service.ICollegeService;
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
@RequestMapping("/college")
@Api(description="学校信息接口")
public class CCollegeController{

private final ICollegeService ics;
private final IUserService ius;
    @Autowired
    public CCollegeController(ICollegeService ics, IUserService ius) {
        this.ics = ics;
        this.ius = ius;
    }

    @RequiresRoles("collegeAdmin")
    @GetMapping("findByCollegeId")
    @ApiOperation(value = "传入学校返回单个党支部对象")
    public MsgResponse findByCollegeId(Short id) throws Exception {
        College college = ics.findById(ius.getRoleId(Constants.COLLEGE,id));
        return MsgResponse.success("college",college);
    }

    @RequiresRoles("collegeAdmin")
    @GetMapping("getCollegeCount")
    public MsgResponse getCollegeCount(Short id) throws Exception {
        CollegeCount collegeCount = ics.getCollegeCount(ius.getRoleId(Constants.COLLEGE,id));
        return MsgResponse.success("college",collegeCount);
    }
}
