package com.briup.party.service.impl;

import com.briup.party.bean.UserSelectCondition;
import com.briup.party.bean.table.User;
import com.briup.party.bean.table.Userdtl;
import com.briup.party.bean.table.Useretd;
import com.briup.party.bean.tableVM.DevModal;
import com.briup.party.bean.tableVM.Msgmodal;
import com.briup.party.dao.*;
import com.briup.party.dao.extend.UserVMMapper;
import com.briup.party.service.IUserService;
import com.briup.party.service.ServiceUtil;
import com.briup.party.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {
    private final ServiceUtil util;
    private final UserMapper um;
    private final BranchMapper bm;
    private final AcademyMapper am;
    private final UserdtlMapper udm;
    private final UseretdMapper utm;
    private final UserVMMapper uvmm;
    private final UrMapper ur;
    @Autowired
    public UserServiceImpl(ServiceUtil util, UserMapper um, BranchMapper bm, AcademyMapper am, UserdtlMapper udm, UseretdMapper utm, UserVMMapper uvmm, UrMapper ur) {
        this.util = util;
        this.um = um;
        this.bm = bm;
        this.am = am;
        this.udm = udm;
        this.utm = utm;
        this.uvmm = uvmm;
        this.ur = ur;
    }

    @Override
    public List<User> selectByCondition(int role, UserSelectCondition con) {
        return null;
    }

    @Override
    public List<User> findAll(int role, Short id) {
        List<User> list = new ArrayList<>();
        switch (role){
            case  Constants.USER:
                list.add(findById(id));
                break;
            case  Constants.BRANCH:
                list = util.getBranchUsers(id);
                break;
            case  Constants.ACADEMY:
                list = util.getAcademyUsers(id);
                break;
            case  Constants.COLLEGE:
                list = util.getCollegeUsers(id);
                break;
        }
        return list;
    }

    @Override
    public Map<String, List<DevModal>> findAllDev(int role, Short id) {
        Map<String ,List<DevModal>> map = new HashMap<String ,List<DevModal>>();
        List<User> users = findAll(role,id);
        List<User> actives = new ArrayList<User>();
        List<User> devObj = new ArrayList<User>();
        List<User> readyParty = new ArrayList<User>();
        List<User> officialParty = new ArrayList<User>();
        for(User user:users){
            switch (user.getCategory()){
                case "入党积极分子":
                    actives.add(user);
                    break;
                case "发展对象":
                    devObj.add(user);
                    break;
                case "预备党员":
                    readyParty.add(user);
                    break;
                case "正式党员":
                    officialParty.add(user);
                    break;
            }
        }
        map.put("actives",util.userToDevUtil(actives));
        map.put("devObj",util.userToDevUtil(devObj));
        map.put("readyParty",util.userToDevUtil(readyParty));
        map.put("officialParty",util.userToDevUtil(officialParty));
        return map;
    }

    @Override
    public Short getRoleId(int role,Short userId) {
        int roleId = 0;
        switch (role){
            case  Constants.BRANCH:
                roleId = um.selectByPrimaryKey(userId).getBranchId();
                break;
            case  Constants.ACADEMY:
                roleId =bm.selectByPrimaryKey(um.selectByPrimaryKey(userId).getBranchId()).getAcademyId();
                break;
            case  Constants.COLLEGE:
                roleId = am.selectByPrimaryKey(bm.selectByPrimaryKey(um.selectByPrimaryKey(userId).getBranchId()).getAcademyId()).getCollegeId();
                break;
        }
        return (short)(roleId);//short自动装箱为Short
    }

    @Override
    public String getRoleMessage(Short id) {
        return uvmm.getRoleById(id);
    }




    @Override
    public Msgmodal findMsgById(Short id) {
        return  uvmm.findById(id);
    }
    @Override
    public User findById(Short id) {
        return  um.selectByPrimaryKey(id);
    }
    @Transactional
    @Override
    public void deleteUser(Short id) {
//      外键维护在user表，只能先查询再删除，删除dtl会级联删除user,而user又会级联删除ur。
        User user = um.selectByPrimaryKey(id);
        udm.deleteByPrimaryKey(user.getEtdId());
        utm.deleteByPrimaryKey(user.getDtlId());
    }

    @Transactional
    @Override
    public Msgmodal insertOrUpdateUser(Msgmodal msgmodul) {
//        todo 插入用户（role+msg）4张表 user、ur、etd、dtl
        Useretd useretd = msgmodul.getUseretd()==null?new Useretd(): msgmodul.getUseretd();
        Userdtl userdtl = msgmodul.getUserdtl()==null?new Userdtl(): msgmodul.getUserdtl();
        return msgmodul;
    }

    @Override
    public Short findIdByUsername(String username) {
        return  um.findIdByUsername(username);
    }


}
