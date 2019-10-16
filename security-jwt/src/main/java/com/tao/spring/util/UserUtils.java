package com.tao.spring.util;

import com.tao.spring.model.User;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author DongTao
 * @since 2019-06-02
 */
public class UserUtils {

    public static User getCurrentUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
