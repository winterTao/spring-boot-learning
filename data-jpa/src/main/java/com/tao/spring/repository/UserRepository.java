package com.tao.spring.repository;

import com.tao.spring.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author DongTao
 * @since 2019-03-22
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Override
    Page<User> findAll(Pageable pageable);
}
