package com.briup.party.controller;

import com.briup.party.dao.UserMapper;
import com.briup.party.dao.extend.UserVMMapper;
import com.briup.party.util.JWTUtil;
import com.briup.party.util.MsgResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;


@RestController
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final UserMapper um;
    private final UserVMMapper uvmm;
    @Autowired
    public LoginController(UserMapper um, UserVMMapper uvmm) {
        this.um = um;
        this.uvmm = uvmm;
    }


    /**
     * token不为空，但验证失败。
     */
    @RequestMapping(path = "/unauthorized/{message}")
    public MsgResponse unauthorized(@PathVariable String message) throws UnsupportedEncodingException {
        System.out.println("未认证");
        return MsgResponse.unauthorized(message);
    }

    @PostMapping("/login")
    public MsgResponse login(@RequestParam("username") String username,
                             @RequestParam("password") String password) {
        logger.info("login");
        String realPassword = um.getPassword(username);
        if (realPassword == null) {
            return MsgResponse.error("usernameError");
        } else if (!realPassword.equals(password)) {
            return MsgResponse.error("passwordError");
        } else {
            Map<String ,String> map = new HashMap<String ,String>();
            String role = uvmm.getRole(username);
            switch (role){
                case "user":
                    map.put("role","user");
                    break;
                case "branchAdmin":
                    map.put("role","branchAdmin");
                    break;
                case "academyAdmin":
                    map.put("role","academyAdmin");
                    break;
                case "collegeAdmin":
                    map.put("role","collegeAdmin");
                    break;
                case "dev":
                    map.put("role","dev");
                    break;
                default:
            }
            return MsgResponse.success(JWTUtil.createToken(username,password),map);
        }
    }


}
