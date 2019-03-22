package com.briup.party.controller.user;

import com.briup.party.bean.table.Object;
import com.briup.party.service.IObjectService;
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
@RequestMapping("/user/object")
@Api(description = "指定用户的党课数据接口")
public class UObjectController{
    private final IObjectService ios;

    @Autowired
    public UObjectController(IObjectService ios) {
        this.ios = ios;
    }

    @RequiresRoles(logical = Logical.OR, value = {"user", "branchAdmin","academyAdmin","collegeAdmin"})
    @GetMapping("findAll")
    public MsgResponse findALl(Short id) throws Exception{
        List<com.briup.party.bean.table.Object> objects = ios.findAll(Constants.USER, id);
        return MsgResponse.success("object",objects);
    }

    @RequiresRoles(logical = Logical.OR, value = {"user", "branchAdmin","academyAdmin","collegeAdmin"})
    @GetMapping("findById")
    public MsgResponse findById(Short id) {
        com.briup.party.bean.table.Object object = ios.findObjectById(id);
        return MsgResponse.success("object",object);
    }

    @RequiresRoles(logical = Logical.OR, value = {"user", "branchAdmin","academyAdmin","collegeAdmin"})
    @PostMapping("insertOrUpdate")
    public MsgResponse insertOrUpdate(Object object) {
        String msg  = object.getId()==null?"object_insert":"object_update";
        ios.insertOrUpdateObject(object);
        return MsgResponse.success(msg,object);
    }
    @RequiresRoles(logical = Logical.OR, value = {"user", "branchAdmin","academyAdmin","collegeAdmin"})
    @GetMapping("delete")
    public MsgResponse delete(Short id) {
        ios.deleteObject(id);
        return MsgResponse.success("object",null);
    }
}
