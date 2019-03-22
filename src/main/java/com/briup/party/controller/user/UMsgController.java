package com.briup.party.controller.user;

import com.briup.party.bean.table.Academy;
import com.briup.party.bean.table.Branch;
import com.briup.party.bean.tableVM.Msgmodal;
import com.briup.party.bean.tableVM.UserModal;
import com.briup.party.dao.AcademyMapper;
import com.briup.party.dao.BranchMapper;
import com.briup.party.dao.CollegeMapper;
import com.briup.party.dao.UserMapper;
import com.briup.party.dao.extend.UserVMMapper;
import com.briup.party.service.*;
import com.briup.party.util.Constants;
import com.briup.party.util.MsgResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user/msg")
@Api(description="指定用户的个人信息数据接口")
public class UMsgController{
	private final IUserService iuser;
	private final UserMapper um;
	private final UserVMMapper uvvm;
	private final AcademyMapper am;
	private final IAcademyService ias;
	private final CollegeMapper cm;
	private final ICollegeService ics;
	private final BranchMapper  bm;
	private final IBranchService ibs;
	private final ServiceUtil serviceUtil;

	@Autowired
	public UMsgController(IUserService iuser, UserMapper um, UserVMMapper uvvm, AcademyMapper am, IAcademyService ias, CollegeMapper cm, ICollegeService ics, BranchMapper bm, IBranchService ibs, ServiceUtil serviceUtil) {
		this.iuser = iuser;
        this.um = um;
        this.uvvm = uvvm;
        this.am = am;
        this.ias = ias;
        this.cm = cm;
        this.ics = ics;
        this.bm = bm;
        this.ibs = ibs;
        this.serviceUtil = serviceUtil;
    }

    @RequiresRoles(logical = Logical.OR, value = {"user", "branchAdmin","academyAdmin","collegeAdmin"})
    @GetMapping("getUser")
    public MsgResponse getUser(String username) {
        Short userId = iuser.findIdByUsername(username);
        String role = iuser.getRoleMessage(userId);
        Map<String,Object> map = new HashMap<String,Object>();
        UserModal userModal = new UserModal();
        switch (role){
            case "user":
                break;
            case "branchAdmin":
                userModal.setRole(bm.selectByPrimaryKey( iuser.getRoleId(Constants.BRANCH,userId)));
                break;
            case "academyAdmin":
                userModal.setRole(am.selectByPrimaryKey( iuser.getRoleId(Constants.ACADEMY,userId)));
                break;
            case "collegeAdmin":
                userModal.setRole(cm.selectByPrimaryKey( iuser.getRoleId(Constants.COLLEGE,userId)));
                break;
        }
        userModal.setUser(iuser.findById((short)(userId)));
        map.put("userModal",userModal);
        return MsgResponse.success("getUser",map);
    }

    @RequiresRoles(logical = Logical.OR, value = {"user", "branchAdmin","academyAdmin","collegeAdmin"})
    @GetMapping("getRole")
    @ApiOperation(value = "返回其所管辖的直接对象，以及统计对象")
    public MsgResponse getRole(Short id) throws Exception {
        Map<String,Object> map = new HashMap<String,Object>();
        String role = iuser.getRoleMessage(id);
        switch (role){
            case "user":
                map.put("count",null);
                List<Branch> oneBranch = new ArrayList<Branch>();
                oneBranch.add(uvvm.findBranchById(id));//返回单个branch对象
                map.put("roleList",oneBranch);
                break;
            case "branchAdmin":
                map.put("count",ibs.getBranchCount(iuser.getRoleId(Constants.BRANCH,id)));
                List<Branch> branch = new ArrayList<Branch>();
                branch.add(uvvm.findBranchById(id));//返回单个branch对象
                map.put("roleList",branch);
                break;
            case "academyAdmin":
                map.put("count",ias.getAcademyCount(iuser.getRoleId(Constants.ACADEMY,id)));
                List<Branch> branches = ias.findBranchById(iuser.getRoleId(Constants.ACADEMY,id));
                map.put("roleList",branches);
                break;
            case "collegeAdmin":
                map.put("count",ics.getCollegeCount(iuser.getRoleId(Constants.COLLEGE,id)));
                List<Academy> academys = ics.findAcademyById(iuser.getRoleId(Constants.COLLEGE,id));
                map.put("roleList",academys);
                break;
        }
        return MsgResponse.success("getRole",map);
    }

    @RequiresRoles(logical = Logical.OR, value = {"user", "branchAdmin","academyAdmin","collegeAdmin"})
    @GetMapping("findAllUser")
    @ApiOperation(value = "传入id返回该用户的详细信息")
    public MsgResponse findAllUser(Short id) {
        return MsgResponse.success("findAllUser",iuser.findAll(Constants.USER, id));
    }
    @RequiresRoles(logical = Logical.OR, value = {"user", "branchAdmin","academyAdmin","collegeAdmin"})
    @GetMapping("findAllDev")
    @ApiOperation(value = "传入id返回该用户的发展管理信息")
    public MsgResponse findAllDev(Short id) {
        return MsgResponse.success("findAllDev",iuser.findAllDev(Constants.USER, id));
    }
    @RequiresRoles(logical = Logical.OR, value = {"user", "branchAdmin","academyAdmin","collegeAdmin"})
	@GetMapping("findMsgById")
	@ApiOperation(value = "传入id返回该用户的详细信息")
	public MsgResponse findMsgById(Short id) {
		Msgmodal msg = iuser.findMsgById(id);
		return MsgResponse.success("findMsgById",msg);
	}

    @RequiresRoles(logical = Logical.OR, value = {"user", "branchAdmin","academyAdmin","collegeAdmin"})
	@GetMapping("deleteUser")
	@ApiOperation(value = "传入id属性删除党员")
	public MsgResponse deleteUser(Short id){
		iuser.deleteUser(id);
		return MsgResponse.success("deleteUser",null);
	}

    @RequiresRoles(logical = Logical.OR, value = {"user", "branchAdmin","academyAdmin","collegeAdmin"})
	@PostMapping("insertOrUpdateUser")
	@ApiOperation(value = "插入或更新某个党员信息")
	public MsgResponse insertOrUpdateUser(Msgmodal msgmodul) {
//	    我定义的VM，手动封装返回数据
		msgmodul = iuser.insertOrUpdateUser(msgmodul);
		return MsgResponse.success("insertOrUpdateUser", msgmodul);
	}

}
