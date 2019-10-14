package com.tao.spring.service;

import com.tao.spring.model.Menu;
import java.util.List;

/**
 * @author DongTao
 * @since 2019-06-02
 */
public interface PermissionService {

    List<Menu> findAllPermission();
}
