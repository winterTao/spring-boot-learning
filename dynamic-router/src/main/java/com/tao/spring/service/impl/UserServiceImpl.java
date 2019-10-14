package com.tao.spring.service.impl;

import com.tao.spring.model.Role;
import com.tao.spring.model.User;
import com.tao.spring.model.UserRole;
import com.tao.spring.service.UserService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author DongTao
 * @since 2019-06-02
 */
@Slf4j
@Service
public class UserServiceImpl extends BaseService implements UserService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userByUsername = userRepository.findUserByUsername(username);
        if (userByUsername == null) {
            throw new UsernameNotFoundException("user not found");
        }

        Set<Role> roles = new HashSet<>();
        List<UserRole> allByUserId = userRoleRepository.findAllByUserId(userByUsername.getId());
        for (UserRole userRole : allByUserId) {
            Role roleById = roleRepository.findRoleById(userRole.getRoleId());
            roles.add(roleById);
        }
        userByUsername.setRoles(new ArrayList<>(roles));

        log.info("find user by username : {}", userByUsername);
        return userByUsername;
    }

    @Override
    public User saveUser(User user) {

        User userByUsername = userRepository.findUserByUsername(user.getUsername());
        if (userByUsername != null) {
            throw new UsernameNotFoundException("user is already existed");
        }

        // 密码加密
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public Integer deleteUserByUserId(Integer userId) {

        userRepository.deleteById(userId);

        return userId;
    }
}
