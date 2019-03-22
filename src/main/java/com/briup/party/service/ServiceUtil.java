package com.briup.party.service;

import com.briup.party.bean.table.Academy;
import com.briup.party.bean.table.Branch;
import com.briup.party.bean.table.User;
import com.briup.party.bean.tableVM.DevModal;
import com.briup.party.dao.AcademyMapper;
import com.briup.party.dao.BranchMapper;
import com.briup.party.dao.CollegeMapper;
import com.briup.party.dao.MeettingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ServiceUtil {
    private final MeettingMapper mm;
    private final BranchMapper bm;
    private final AcademyMapper am;
    private final CollegeMapper cm;
    private List<Academy> academys;
    private List<Branch> branches;
    private List<User> users;

    @Autowired
    public ServiceUtil(MeettingMapper mm, BranchMapper bm, AcademyMapper am, CollegeMapper cm) {
        this.mm = mm;
        this.bm = bm;
        this.am = am;
        this.cm = cm;
    }
    public List<Academy> getCollegeAcademy(Short id){
        academys = cm.findAcademyByCollegeId(id);
        return academys;
    }

    public List<Branch> getCollegeBranchs(Short id){
        getCollegeAcademy(id);//为academy对象赋值
//        获取acade数组对象的id数组
        List<Short> list= new ArrayList<>();
        for(Academy item: academys){
            list.add(item.getId());
        }
        branches =  am.findBranchByIdArray(list);
        return branches;
    }
    //	todo	待优化,重复代码 封装一个对象（objects）数组到id数组的方法。
    public List<User> getCollegeUsers(Short id) {
        getCollegeBranchs(id);
        List<Short> list= new ArrayList<>();
        for(Branch item: branches){
            list.add(item.getId());
        }
        users =  bm.findUserByIdArray(list);
        return users;
    }
    public List<Branch> getAcademybranchs(Short id){
        branches = am.findBranchById(id);
        return branches;
    }

    public List<User> getAcademyUsers(Short id) {
        getAcademybranchs(id);
        List<Short> list= new ArrayList<>();
        for(Branch item: branches){
            list.add(item.getId());
        }
        users =  bm.findUserByIdArray(list);
        return users;
    }

    public List<User> getBranchUsers(Short id){
        users = bm.findUserById(id);
        return users;
    }

    //    重载的工具类。
    public DevModal userToDevUtil(User user){
        //                todo 时间和材料完整度待定
        return new DevModal(user.getId(),user.getName(),bm.selectByPrimaryKey(user.getBranchId()).getName(),"1997-12-08",user.getCategory(),1);
    }
    public List<DevModal> userToDevUtil(List<User> users){
        List<DevModal> devModals = new ArrayList<DevModal>();
        for(User user:users){
            devModals.add(new DevModal(user.getId(),user.getName(),bm.selectByPrimaryKey(user.getBranchId()).getName(),"1997-12-08",user.getCategory(),1));
        }
        return devModals;
    }
}
