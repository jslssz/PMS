package com.briup.party.service.impl;

import com.briup.party.bean.table.Object;
import com.briup.party.bean.table.User;
import com.briup.party.dao.ObjectMapper;
import com.briup.party.service.IObjectService;
import com.briup.party.service.ServiceUtil;
import com.briup.party.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObjectServiceImpl implements IObjectService {
	private final ServiceUtil util;
	private final ObjectMapper om;

	@Autowired
	public ObjectServiceImpl(ServiceUtil util, ObjectMapper om) {
		this.util = util;
		this.om = om;
	}
	@Override
	public List<Object> findAll(int role,Short id) {
		//		1.获取userId的list数组。2.根据userID数组查询数据库dao和xml
		List<Object> list = new ArrayList<Object>();
		List<User> users= new ArrayList<User>();
		switch (role){
			case Constants.USER:
				list = om.findByUserId(id);
				return list;
			case Constants.BRANCH:
				users = util.getBranchUsers(id);
				break;
			case Constants.ACADEMY:
				users = util.getAcademyUsers(id);
				break;
			case Constants.COLLEGE:
				users = util.getCollegeUsers(id);
				break;
		}
		return list;
	}

	@Override
	public Object findObjectById(Short id) {
		return om.selectByPrimaryKey(id);
	}


	@Override
	public void deleteObject(Short id) {
		om.deleteByPrimaryKey(id);
	}

	@Override
	public int insertOrUpdateObject(Object object) {
		if(object.getId()==null){
			return om.insert(object);
		}else{
			return om.updateByPrimaryKey(object);
		}
	}

	public List<Object> getObjectListByUsersArray(List<User> users){
		List<Object> objects =  new ArrayList<Object>();
		List<Short> list = new ArrayList<Short>();
		for(User user:users){
			list.add(user.getId());
		}
		objects = om.findByUserIdArray(list);
		return objects;
	}
}
