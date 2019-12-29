package com.leitan.springapi.entity;

import lombok.Data;

/**
 * @Description 角色权限信息
 * @Author lei.tan
 * @Date 2019/12/29 19:10
 */
@Data
public class RolePermission {

    private long roleId;

    private String roleName;

    private long permissionId;

    private String url;



}
