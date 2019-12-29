package com.leitan.springapi.service;

/**
 * @Description 权限认证相关
 * @Author lei.tan
 * @Date 2019/12/29 16:35
 */
public interface AuthService {

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    String login(String username, String password);

}
