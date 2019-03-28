package com.tao.spring.service;

import com.tao.spring.model.User;
import com.tao.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author DongTao
 * @since 2019-03-28
 */
@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Page<User> getUserPage(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
