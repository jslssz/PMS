package com.briup.party.controller;

import com.briup.party.util.MsgResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
public interface CRUDController {
    @GetMapping("findAll")
    public MsgResponse findALl(Short id) throws Exception;

    @GetMapping("findById")
    public MsgResponse findById(Short id);

    @PostMapping("insertOrUpdate")
    public MsgResponse insertOrUpdate(Object object);

    @GetMapping("delete")
    public MsgResponse delete(Short id);
}
