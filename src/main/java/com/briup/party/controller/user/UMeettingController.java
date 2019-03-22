package com.briup.party.controller.user;

import com.briup.party.bean.table.Meetting;
import com.briup.party.service.IMeettingService;
import com.briup.party.util.Constants;
import com.briup.party.util.MsgResponse;
import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/meetting")
@Api(description="指定用户的会议数据接口")
public class UMeettingController{
	private final IMeettingService ims;

	@Autowired
	public UMeettingController(IMeettingService ims) {
		this.ims = ims;
	}

    @RequiresRoles(logical = Logical.OR, value = {"user", "branchAdmin","academyAdmin","collegeAdmin"})
    @GetMapping("findAll")
	public MsgResponse findALl(Short id) throws Exception{
		List<Meetting> meettings = ims.findAll(Constants.USER, id);
		return MsgResponse.success("meetting",meettings);
	}

    @RequiresRoles(logical = Logical.OR, value = {"user", "branchAdmin","academyAdmin","collegeAdmin"})
    @GetMapping("findById")
    public MsgResponse findById(Short id) {
        Meetting meetting = ims.findMeettingById(id);
        return MsgResponse.success("meetting",meetting);
    }

    @RequiresRoles(logical = Logical.OR, value = {"user", "branchAdmin","academyAdmin","collegeAdmin"})
    @PostMapping("insertOrUpdate")
	public MsgResponse insertOrUpdate(Meetting meetting) {
        String msg  = meetting.getId()==null?"meetting_insert":"meetting_update";
	    ims.insertOrUpdateMeetting(meetting);
        return MsgResponse.success(msg,meetting);
	}

    @RequiresRoles(logical = Logical.OR, value = {"user", "branchAdmin","academyAdmin","collegeAdmin"})
    @GetMapping("delete")
	public MsgResponse delete(Short id) {
	    ims.deleteMeetting(id);
        return MsgResponse.success("meetting",null);
	}
}
