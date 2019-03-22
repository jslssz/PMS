package com.briup.party.controller.college;

import com.briup.party.bean.table.Academy;
import com.briup.party.controller.IAcademyController;
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
@RequestMapping("/college/academy")
@Api(description = "学校下学院信息接口")
public class CAcademyController implements IAcademyController {
    private final ICollegeService ics;
    private final IUserService ius;

    @Autowired
    public CAcademyController(ICollegeService ics, IUserService ius) {
        this.ics = ics;
        this.ius = ius;
    }

    @RequiresRoles("collegeAdmin")
    @Override
    public MsgResponse findAllAcademy(Short id) throws Exception {
        List<Academy> academys = ics.findAcademyById(ius.getRoleId(Constants.COLLEGE,id));
        return MsgResponse.success("college",academys);
    }
}
