package com.leitan.springapi.controller;

import com.leitan.springapi.service.AuthService;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 权限处理
 * @Author lei.tan
 * @Date 2019/12/29 14:06
 */
@RestController
public class AuthController {


    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    /**
     * 登录
     */
    @PostMapping(value = "/auth/login")
    public String login(String username, String password) throws AuthenticationException {
        // 登录成功会返回Token给用户
        return authService.login(username, password);
    }

    @PostMapping(value = "/user/common")
    public String userHi(String name) throws AuthenticationException {
        return "hi " + name + " , you have 'user' role";
    }

    @PostMapping(value = "/user/admin")
    public String adminHi(String name) throws AuthenticationException {
        return "hi " + name + " , you have 'admin' role";
    }

    @GetMapping(value = "/user/other")
    public String other(String message) throws AuthenticationException {
        return "hi! I get your " + message + " !";
    }


}
