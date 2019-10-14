package com.tao.spring.repository;

import com.tao.spring.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author DongTao
 * @since 2019-06-02
 */
@Repository
public interface PermissionRepository extends JpaRepository<Menu, Integer> {

    Menu findPermissionById(Integer permissionId);

}
