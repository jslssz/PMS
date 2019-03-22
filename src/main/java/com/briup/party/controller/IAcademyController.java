package com.briup.party.controller;

import com.briup.party.util.MsgResponse;
import org.springframework.web.bind.annotation.GetMapping;

public interface IAcademyController {
    @GetMapping("findAllAcademy")
    public MsgResponse findAllAcademy(Short id) throws Exception;
}
