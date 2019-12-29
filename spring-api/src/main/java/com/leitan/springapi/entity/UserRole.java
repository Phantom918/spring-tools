package com.leitan.springapi.entity;

import lombok.Data;

/**
 * @Description 用户角色信息
 * @Author lei.tan
 * @Date 2019/12/29 19:10
 */
@Data
public class UserRole {

    private long userId;

    private String userName;

    private long roleId;

    private String roleName;

}
