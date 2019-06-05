package com.tao.spring.service;

import com.tao.spring.model.Permission;
import java.util.List;

/**
 * @author DongTao
 * @since 2019-06-02
 */
public interface PermissionService {

    List<Permission> findAllPermission();
}
