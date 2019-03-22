package com.briup.party.controller.academy;

import com.briup.party.bean.count.AcademyCount;
import com.briup.party.bean.table.Academy;
import com.briup.party.service.IAcademyService;
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
@RequestMapping("/academy")
@Api(description="学院信息接口")
public class AAcademyController{
    private final IAcademyService ias;
    private final IUserService ius;
    @Autowired
    public AAcademyController(IAcademyService ias, IUserService ius) {
        this.ias = ias;
        this.ius = ius;
    }
    @RequiresRoles("academyAdmin")
    @GetMapping("findByAcademyId")
    @ApiOperation(value = "传入用户id返回管理的学院对象")
    public MsgResponse findByAcademyId(Short id) throws Exception {
        Academy academy = ias.findById(ius.getRoleId(Constants.ACADEMY,id));
        return MsgResponse.success("academy",academy);
    }
    @RequiresRoles("academyAdmin")
    @GetMapping("getAcademyCount")
    public MsgResponse getAcademyCount(Short id) throws Exception {
        AcademyCount academyCount = ias.getAcademyCount(ius.getRoleId(Constants.ACADEMY,id));
        return MsgResponse.success("academy",academyCount);
    }
}
