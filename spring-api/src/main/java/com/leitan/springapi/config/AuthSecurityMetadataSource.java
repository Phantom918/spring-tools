package com.leitan.springapi.config;

import com.leitan.springapi.dao.PermissionMapper;
import com.leitan.springapi.entity.RolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author lei.tan
 * @description TODO
 * @date 2019/12/29 13:59
 */
@Component
public class AuthSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {


    @Autowired
    private PermissionMapper permissionMapper;

    /**
     * 每一个资源所需要的角色 Collection<ConfigAttribute>决策器会用到
     */
    private static Map<String, Collection<ConfigAttribute>> ALL_RESOURCE;


    /**
     * 返回请求的资源需要的角色
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        //object 中包含用户请求的request 信息
        HttpServletRequest request = ((FilterInvocation) o).getHttpRequest();
        for (Iterator<String> it = ALL_RESOURCE.keySet().iterator(); it.hasNext(); ) {
            String url = it.next();
            if (new AntPathRequestMatcher(url).matches(request)) {
                return ALL_RESOURCE.get(url);
            }
        }

        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        //初始化所有资源对应的角色
        loadResourceDefine();
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

    /**
     * 初始化 所有资源 对应的角色
     */
    public void loadResourceDefine() {
        ALL_RESOURCE = new HashMap<>(16);
        List<RolePermission> permissions = permissionMapper.getRolePermissions();
        //某个资源 可以被哪些角色访问
        for (RolePermission rolePermission : permissions) {
            String url = rolePermission.getUrl();
            String roleName = rolePermission.getRoleName();
            ConfigAttribute role = new SecurityConfig(roleName);
            if (ALL_RESOURCE.containsKey(url)) {
                ALL_RESOURCE.get(url).add(role);
            } else {
                List<ConfigAttribute> list = new ArrayList<>(Arrays.asList(role));
                ALL_RESOURCE.put(url, list);
            }
        }
    }


}
