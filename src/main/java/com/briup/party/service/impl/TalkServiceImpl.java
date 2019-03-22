package com.briup.party.service.impl;

import com.briup.party.bean.table.Talk;
import com.briup.party.bean.table.User;
import com.briup.party.dao.TalkMapper;
import com.briup.party.service.ITalkService;
import com.briup.party.service.ServiceUtil;
import com.briup.party.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TalkServiceImpl implements ITalkService {
	private final ServiceUtil util;
	private final TalkMapper tm;

	@Autowired
	public TalkServiceImpl(ServiceUtil util, TalkMapper tm) {
		this.util = util;
		this.tm = tm;
	}


	@Override
	public void deleteTalk(Short id) {
		tm.deleteByPrimaryKey(id);
	}

	@Override
	public List<Talk> findAll(int role,Short id) throws Exception {
		List<Talk> list = new ArrayList<Talk>();
		List<User> users= new ArrayList<User>();
		switch (role){
			case Constants.USER:
				list = tm.findByUserId(id);
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
	public Talk findTalkById(Short id) {
		return tm.selectByPrimaryKey(id);
	}


	@Override
	public int insertOrUpdateTalk(Talk talk) {
		if(talk.getId()==null){
			return tm.insert(talk);
		}else{
			return tm.updateByPrimaryKey(talk);
		}
	}
	public List<Talk> geTalkListByUsersArray(List<User> users){
		List<Talk> talks =  new ArrayList<Talk>();
		List<Short> list = new ArrayList<Short>();
		for(User user:users){
			list.add(user.getId());
		}
		talks = tm.findByUserIdArray(list);
		return talks;
	}
}
