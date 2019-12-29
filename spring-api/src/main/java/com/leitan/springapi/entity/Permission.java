package com.leitan.springapi.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description 权限信息
 * @Author lei.tan
 * @Date 2019/12/29 19:10
 */
@Data
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String code;

    private String url;

    private String name;

    private String description;

    private String parentCode;

}