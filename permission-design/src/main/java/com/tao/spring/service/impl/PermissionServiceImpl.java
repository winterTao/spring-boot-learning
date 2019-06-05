package com.tao.spring.service.impl;

import com.tao.spring.model.Permission;
import com.tao.spring.model.Role;
import com.tao.spring.model.RolePermission;
import com.tao.spring.service.PermissionService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Service;

/**
 * @author DongTao
 * @since 2019-06-02
 */
@Service
public class PermissionServiceImpl extends BaseService implements PermissionService {


    @Override
    public List<Permission> findAllPermission() {
        List<Permission> result = permissionRepository.findAll();

        for (Permission permission : result) {
            Set<Role> roles = new HashSet<>();
            List<RolePermission> allByPermissionId = rolePermissionRepository
                    .findAllByPermissionId(permission.getId());
            for (RolePermission rolePermission : allByPermissionId) {
                Role roleById = roleRepository.findRoleById(rolePermission.getRoleId());
                roles.add(roleById);
            }
            permission.setRoles(new ArrayList<>(roles));
        }

        return result;
    }
}
