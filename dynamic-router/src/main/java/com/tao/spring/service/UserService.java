package com.tao.spring.service;

import com.tao.spring.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author DongTao
 * @since 2019-06-02
 */
public interface UserService extends UserDetailsService {

    User saveUser(User user);

    Integer deleteUserByUserId(Integer userId);
}
