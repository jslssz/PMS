package com.briup.party.controller.branch;

import com.briup.party.bean.UserSelectCondition;
import com.briup.party.bean.table.Meetting;
import com.briup.party.bean.table.Object;
import com.briup.party.bean.table.Talk;
import com.briup.party.bean.table.User;
import com.briup.party.controller.IUserController;
import com.briup.party.dao.BranchMapper;
import com.briup.party.service.*;
import com.briup.party.util.Constants;
import com.briup.party.util.MsgResponse;
import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/branch/user")
@Api(description="党支部下用户信息接口")
public class BUserController implements IUserController{
    private final IUserService ius;
    private final IBranchService ibs;
    private final IMeettingService ims;
    private final IObjectService ios;
    private final ITalkService its;
    private final BranchMapper bm;

    @Autowired
    public BUserController(IUserService ius, IBranchService ibs, IMeettingService ims, IObjectService ios, ITalkService its, BranchMapper bm) {
        this.ius = ius;
        this.ibs = ibs;
        this.ims = ims;
        this.ios = ios;
        this.its = its;
        this.bm = bm;
    }

    @RequiresRoles("branchAdmin")
    @Override
    public MsgResponse findAllUser(Short id) {
        List<User> users = ius.findAll(Constants.BRANCH, ius.getRoleId(Constants.BRANCH,id));
        return  MsgResponse.success("branch",users);
    }
    @RequiresRoles("branchAdmin")
    @Override
    public MsgResponse findAllUserMeetting(Short id) throws Exception{
        List<Meetting> meettings = ims.findAll(Constants.BRANCH, ius.getRoleId(Constants.BRANCH,id));
        return MsgResponse.success("branch",meettings);
    }
    @RequiresRoles("branchAdmin")
    @Override
    public MsgResponse findAllUserObject(Short id) throws Exception{
        List<Object> objects = ios.findAll(Constants.BRANCH, ius.getRoleId(Constants.BRANCH,id));
        return MsgResponse.success("branch",objects);
    }
    @RequiresRoles("branchAdmin")
    @Override
    public MsgResponse findAllDev(Short id) {
        return MsgResponse.success("branch",ius.findAllDev(Constants.BRANCH, ius.getRoleId(Constants.BRANCH,id)));
    }
    @RequiresRoles("branchAdmin")
    @Override
    public MsgResponse findAllUserTalk(Short id) throws Exception {
        List<Talk> talks = its.findAll(Constants.BRANCH, ius.getRoleId(Constants.BRANCH,id));
        return MsgResponse.success("branch",talks);
    }
    @RequiresRoles("branchAdmin")
    @Override
    public MsgResponse selectBranchUser(UserSelectCondition con) {
        List<User> users = ius.selectByCondition(Constants.BRANCH, con);
        return MsgResponse.success("branch",users);
    }



}
