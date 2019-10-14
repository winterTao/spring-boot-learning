package com.tao.spring.service.impl;

import com.tao.spring.model.Menu;
import com.tao.spring.model.Role;
import com.tao.spring.model.MenuRole;
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
    public List<Menu> findAllPermission() {
        List<Menu> result = permissionRepository.findAll();

        for (Menu permission : result) {
            Set<Role> roles = new HashSet<>();
            List<MenuRole> allByPermissionId = rolePermissionRepository
                    .findAllByPermissionId(permission.getId());
            for (MenuRole rolePermission : allByPermissionId) {
                Role roleById = roleRepository.findRoleById(rolePermission.getRoleId());
                roles.add(roleById);
            }
            permission.setRoles(new ArrayList<>(roles));
        }

        return result;
    }
}
