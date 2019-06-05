package com.tao.spring.service.impl;

import com.tao.spring.repository.PermissionRepository;
import com.tao.spring.repository.RolePermissionRepository;
import com.tao.spring.repository.RoleRepository;
import com.tao.spring.repository.UserRepository;
import com.tao.spring.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author DongTao
 * @since 2019-06-04
 */
public abstract class BaseService {

    public PermissionRepository permissionRepository;

    public RoleRepository roleRepository;

    public UserRepository userRepository;

    public RolePermissionRepository rolePermissionRepository;

    public UserRoleRepository userRoleRepository;


    @Autowired
    public void setPermissionRepository(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setRolePermissionRepository(RolePermissionRepository rolePermissionRepository) {
        this.rolePermissionRepository = rolePermissionRepository;
    }

    @Autowired
    public void setUserRoleRepository(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }
}
