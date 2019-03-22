package com.briup.party.controller;

import com.briup.party.bean.UserSelectCondition;
import com.briup.party.util.MsgResponse;
import org.springframework.web.bind.annotation.GetMapping;

public interface IUserController {
    @GetMapping("findAllUser")
    public MsgResponse findAllUser(Short id);

    @GetMapping("findAllUserMeetting")
    public MsgResponse findAllUserMeetting(Short id) throws Exception;

    @GetMapping("findAllUserObject")
    public MsgResponse findAllUserObject(Short id) throws Exception;

    @GetMapping("findAllUserTalk")
    public MsgResponse findAllUserTalk(Short id) throws Exception;

    @GetMapping("selectBranchUser")
    public MsgResponse selectBranchUser(UserSelectCondition con);

    @GetMapping("findAllDev")
    public MsgResponse findAllDev(Short id);
}
