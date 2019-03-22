package com.briup.party.controller.user;

import com.briup.party.bean.table.Talk;
import com.briup.party.service.ITalkService;
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
@RequestMapping("/user/talk")
@Api(description = "指定用户的谈心谈话数据接口")
public class UTalkController {
    private final ITalkService its;

    @Autowired
    public UTalkController(ITalkService its) {
        this.its = its;
    }

    @RequiresRoles(logical = Logical.OR, value = {"user", "branchAdmin","academyAdmin","collegeAdmin"})
    @GetMapping("findAll")
    public MsgResponse findALl(Short id) throws Exception {
        List<Talk> talks = its.findAll(Constants.USER, id);
        return MsgResponse.success("talk",talks);
    }
    @RequiresRoles(logical = Logical.OR, value = {"user", "branchAdmin","academyAdmin","collegeAdmin"})
    @GetMapping("findById")
    public MsgResponse findById(Short id) {
        Talk talk = its.findTalkById(id);
        return MsgResponse.success("talk",talk);
    }
    @RequiresRoles(logical = Logical.OR, value = {"user", "branchAdmin","academyAdmin","collegeAdmin"})
    @PostMapping("insertOrUpdate")
    public MsgResponse insertOrUpdate(Talk talk) {
        String msg  = talk.getId()==null?"talk_insert":"talk_update";
        its.insertOrUpdateTalk(talk);
        return MsgResponse.success(msg,talk);
    }
    @RequiresRoles(logical = Logical.OR, value = {"user", "branchAdmin","academyAdmin","collegeAdmin"})
    @GetMapping("delete")
    public MsgResponse delete(Short id) {
        its.deleteTalk(id);
        return MsgResponse.success("talk",null);
    }
}
