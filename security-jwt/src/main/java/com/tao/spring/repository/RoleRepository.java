package com.tao.spring.repository;

import com.tao.spring.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author DongTao
 * @since 2019-06-02
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findRoleById(Integer roleId);

}
