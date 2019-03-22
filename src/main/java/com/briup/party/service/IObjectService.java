package com.briup.party.service;

import com.briup.party.bean.table.Object;

import java.util.List;

public interface IObjectService {
    List<Object> findAll(int role,Short id);

    Object findObjectById(Short id);

    int insertOrUpdateObject(Object object);

    void deleteObject(Short id);

}
