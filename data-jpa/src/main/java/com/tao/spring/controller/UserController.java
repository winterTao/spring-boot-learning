package com.tao.spring.controller;

import com.tao.spring.model.User;
import com.tao.spring.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DongTao
 * @since 2019-03-28
 */
@Slf4j
@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * page=0&size=5&sort=id,desc
     */
    @GetMapping("/users")
    public Page<User> getUserPage(@PageableDefault(value = 5, sort = {"id"},
            direction = Direction.DESC) Pageable pageable) {

        return userService.getUserPage(pageable);
    }
}
