package com.tao.spring.repository;

import com.tao.spring.model.UserRole;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author DongTao
 * @since 2019-06-02
 */
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

    List<UserRole> findAllByUserId(Integer userId);
}
