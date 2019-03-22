package com.briup.party.service.impl;

import com.briup.party.bean.table.Meetting;
import com.briup.party.bean.table.User;
import com.briup.party.dao.MeettingMapper;
import com.briup.party.service.IMeettingService;
import com.briup.party.service.ServiceUtil;
import com.briup.party.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MeettingServiceImpl implements IMeettingService {

	private final ServiceUtil util;
	private final MeettingMapper mm;
	@Autowired
	public MeettingServiceImpl(ServiceUtil util, MeettingMapper mm) {
		this.util = util;
		this.mm = mm;
	}
	@Override
	public List<Meetting> findAll(int role ,Short id) throws Exception {
		List<Meetting> list = new ArrayList<Meetting>();
		List<User> users= new ArrayList<User>();
		switch (role){
            case Constants.USER:
            	list = mm.findByUserId(id);
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
		System.out.println(users.get(0).getName());
		list = getMeettingListByUsersArray(users);
		return list;
	}

	@Override
	public Meetting findMeettingById(Short id) {
		return mm.selectByPrimaryKey(id);
	}


	@Override
	public void deleteMeetting(Short id) {
		mm.deleteByPrimaryKey(id);
	}

	@Override
	public int insertOrUpdateMeetting(Meetting meeting) {
		if(meeting.getId()==null){
			return mm.insert(meeting);
		}else{
			return mm.updateByPrimaryKey(meeting);
		}
	}

	public List<Meetting> getMeettingListByUsersArray(List<User> users){
		List<Meetting> meettings =  new ArrayList<Meetting>();
		List<Short> list = new ArrayList<Short>();
		for(User user:users){
			list.add(user.getId());
		}
		System.out.println(list.get(0));
        meettings = mm.findByUserIdArray(list);
        return meettings;
	}
}
