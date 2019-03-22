package com.briup.party.controller.academy;

import com.briup.party.bean.UserSelectCondition;
import com.briup.party.bean.table.Meetting;
import com.briup.party.bean.table.Object;
import com.briup.party.bean.table.Talk;
import com.briup.party.bean.table.User;
import com.briup.party.controller.IUserController;
import com.briup.party.dao.AcademyMapper;
import com.briup.party.service.*;
import com.briup.party.util.Constants;
import com.briup.party.util.MsgResponse;
import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/academy/user")
@Api(description="学院下用户信息接口")
public class AUserController implements IUserController{
    private final IUserService ius;
    private final IBranchService ibs;
    private final IMeettingService ims;
    private final IObjectService ios;
    private final ITalkService its;
    private final AcademyMapper am;

    @Autowired
    public AUserController(IUserService ius, IBranchService ibs, IMeettingService ims, IObjectService ios, ITalkService its, AcademyMapper am) {
        this.ius = ius;
        this.ibs = ibs;
        this.ims = ims;
        this.ios = ios;
        this.its = its;
        this.am = am;
    }
    @RequiresRoles("academyAdmin")
    @Override
    public MsgResponse findAllUser(Short id) {
        List<User> users = ius.findAll(Constants.ACADEMY, ius.getRoleId(Constants.ACADEMY,id));
//        拆分集合
        Set<Short> set = new HashSet<>();
        List<User> list = null;
        Map<String ,List<User>> map = new HashMap<String ,List<User>>();
        for(User user:users){
            if(set.add(user.getBranchId())){//返回true即新的branch
//                创建内集合，并添加数据至内集合中，将内集合放入外集合中。
                list = new ArrayList<>();
                list.add(user);
                map.put(user.getBranchId().toString(),list);
            }else{
//                获取内集合，并添加数据至集合中。
                list= map.get(user.getBranchId().toString());
                list.add(user);
            }
        }

        return  MsgResponse.success("academy",map);
    }
    @RequiresRoles("academyAdmin")
    @Override
    public MsgResponse findAllDev(Short id) {
        return MsgResponse.success("academy",ius.findAllDev(Constants.ACADEMY, ius.getRoleId(Constants.ACADEMY,id)));
    }

    @RequiresRoles("academyAdmin")
    @Override
    public MsgResponse findAllUserMeetting(Short id) throws Exception{
        List<Meetting> meettings = ims.findAll(Constants.ACADEMY, ius.getRoleId(Constants.ACADEMY,id));
        return MsgResponse.success("academy",meettings);
    }
    @RequiresRoles("academyAdmin")
    @Override
    public MsgResponse findAllUserObject(Short id) throws Exception{
        List<Object> objects = ios.findAll(Constants.ACADEMY, ius.getRoleId(Constants.ACADEMY,id));
        return MsgResponse.success("academy",objects);
    }
    @RequiresRoles("academyAdmin")
    @Override
    public MsgResponse findAllUserTalk(Short id) throws Exception {
        List<Talk> talks = its.findAll(Constants.ACADEMY, ius.getRoleId(Constants.ACADEMY,id));
        return MsgResponse.success("academy",talks);
    }
    @RequiresRoles("academyAdmin")
    @Override
    public MsgResponse selectBranchUser(UserSelectCondition con) {
        List<User> users = ius.selectByCondition(Constants.ACADEMY, con);
        return MsgResponse.success("academy",users);
    }



}
