package com.tao.spring.config;

import com.tao.spring.model.Menu;
import com.tao.spring.model.Role;
import com.tao.spring.service.PermissionService;
import java.util.Collection;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

/**
 * @author DongTao
 * @since 2019-06-02
 */
@Slf4j
@Component
public class CustomMetadataSource implements FilterInvocationSecurityMetadataSource {

    private PermissionService permissionService;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Autowired
    public void setPermissionService(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object)
            throws IllegalArgumentException {

        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        List<Menu> allPermission = permissionService.findAllPermission();

        for (Menu permission : allPermission) {
            if (antPathMatcher.match(permission.getUrlPattern(), requestUrl)
                    && permission.getRoles().size() > 0) {
                List<Role> roles = permission.getRoles();
                int size = roles.size();
                String[] values = new String[size];
                for (int i = 0; i < size; i++) {
                    values[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(values);
            }
        }
        //没有匹配上的资源，都是登录访问
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
