package com.briup.party.service;

import com.briup.party.bean.table.Meetting;

import java.util.List;
public interface IMeettingService {
	List<Meetting> findAll(int role,Short id) throws Exception;

	Meetting findMeettingById(Short id);

	int insertOrUpdateMeetting(Meetting meeting);

	void deleteMeetting(Short id);
}
