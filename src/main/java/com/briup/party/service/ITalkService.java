package com.briup.party.service;

import com.briup.party.bean.table.Talk;

import java.util.List;
public interface ITalkService {
	List<Talk> findAll(int role,Short id) throws Exception;

    Talk findTalkById(Short id);

    int insertOrUpdateTalk(Talk talk);

    void deleteTalk(Short id);
}
