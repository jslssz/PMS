package com.briup.party.controller.college;

import com.briup.party.bean.UserSelectCondition;
import com.briup.party.bean.table.Meetting;
import com.briup.party.bean.table.Object;
import com.briup.party.bean.table.Talk;
import com.briup.party.bean.table.User;
import com.briup.party.controller.IUserController;
import com.briup.party.dao.BranchMapper;
import com.briup.party.dao.CollegeMapper;
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
@RequestMapping("/college/user")
@Api(description="学校下用户信息接口")
public class CUserController implements IUserController{

    private final IUserService ius;
    private final IBranchService ibs;
    private final IMeettingService ims;
    private final IObjectService ios;
    private final ITalkService its;
    private final CollegeMapper cm;
    private final BranchMapper bm;

    @Autowired
    public CUserController(IUserService ius, IBranchService ibs, IMeettingService ims, IObjectService ios, ITalkService its, CollegeMapper cm, BranchMapper bm) {
        this.ius = ius;
        this.ibs = ibs;
        this.ims = ims;
        this.ios = ios;
        this.its = its;
        this.cm = cm;
        this.bm = bm;
    }

    @RequiresRoles("collegeAdmin")
    @Override
    public MsgResponse findAllUser(Short id) {
        List<User> users = ius.findAll(Constants.COLLEGE, id);
//        拆分集合
        Set<Short> set = new HashSet<>();
        List<User> list = null;
        Map<String ,List<User>> map = new HashMap<String ,List<User>>();
        for(User user:users){
            if(set.add(bm.selectByPrimaryKey(user.getBranchId()).getAcademyId())){//返回true即新的branch,
//                创建内集合，并添加数据至内集合中，将内集合放入外集合中。
                list = new ArrayList<>();
                list.add(user);
                map.put(bm.selectByPrimaryKey(user.getBranchId()).getAcademyId().toString(),list);
            }else{
//                获取内集合，并添加数据至集合中。
                list= map.get(bm.selectByPrimaryKey(user.getBranchId()).getAcademyId().toString());
                list.add(user);
            }
        }

        return  MsgResponse.success("college",map);
    }
    @RequiresRoles("collegeAdmin")
    @Override
    public MsgResponse findAllDev(Short id) {
        return MsgResponse.success("college",ius.findAllDev(Constants.COLLEGE, ius.getRoleId(Constants.COLLEGE,id)));
    }
    @RequiresRoles("collegeAdmin")
    @Override
    public MsgResponse findAllUserMeetting(Short id) throws Exception{
        List<Meetting> meettings = ims.findAll(Constants.COLLEGE, ius.getRoleId(Constants.COLLEGE,id));
        return MsgResponse.success("college",meettings);
    }
    @RequiresRoles("collegeAdmin")
    @Override
    public MsgResponse findAllUserObject(Short id) throws Exception{
        List<Object> objects = ios.findAll(Constants.COLLEGE, ius.getRoleId(Constants.COLLEGE,id));
        return MsgResponse.success("college",objects);
    }
    @RequiresRoles("collegeAdmin")
    @Override
    public MsgResponse findAllUserTalk(Short id) throws Exception {
        List<Talk> talks = its.findAll(Constants.COLLEGE, ius.getRoleId(Constants.COLLEGE,id));
        return MsgResponse.success("college",talks);
    }
    @RequiresRoles("collegeAdmin")
    @Override
    public MsgResponse selectBranchUser(UserSelectCondition con) {
        List<User> users = ius.selectByCondition(Constants.COLLEGE, con);
        return MsgResponse.success("college",users);
    }


}
