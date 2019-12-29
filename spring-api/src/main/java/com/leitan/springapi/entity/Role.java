package com.leitan.springapi.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.List;

/**
 * @Description 角色信息
 * @Author lei.tan
 * @Date 2019/12/29 19:10
 */
@Data
public class Role implements GrantedAuthority, Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String description;

    private List<User> users;

    private List<Permission> permissions;

    @Override
    public String getAuthority() {
        return name;
    }
}