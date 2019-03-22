package com.briup.party.controller;

import com.briup.party.util.MsgResponse;
import org.springframework.web.bind.annotation.GetMapping;

public interface IBranchController {
    @GetMapping("findAllBranch")
    public MsgResponse findAllBranch(Short id) throws Exception;
}
