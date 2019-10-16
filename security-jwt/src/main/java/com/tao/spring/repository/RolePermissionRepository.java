package com.tao.spring.repository;

import com.tao.spring.model.RolePermission;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author DongTao
 * @since 2019-06-02
 */
@Repository
public interface RolePermissionRepository extends JpaRepository<RolePermission, Integer> {

    List<RolePermission> findAllByRoleId(Integer roleId);

    List<RolePermission> findAllByPermissionId(Integer permissionId);

}
