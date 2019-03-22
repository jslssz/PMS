package com.briup.party.service;

import com.briup.party.bean.UserSelectCondition;
import com.briup.party.bean.tableVM.DevModal;
import com.briup.party.bean.tableVM.Msgmodal;
import com.briup.party.bean.table.User;

import java.util.List;
import java.util.Map;

/**
 * service同级及其下数据的操作（统计）。
 */
public interface IUserService {

	List<User> selectByCondition(int role ,UserSelectCondition con);
	
	List<User> findAll(int role , Short id);

	Msgmodal findMsgById(Short id);

	User findById(Short id);

	void deleteUser(Short id);

	Msgmodal insertOrUpdateUser(Msgmodal msgmodul);

    Short findIdByUsername(String username);

    Short getRoleId(int role ,Short userId);

	String getRoleMessage(Short id);

	Map<String,List<DevModal>> findAllDev(int role , Short id);
}
