package com.tao.spring.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DongTao
 * @since 2018-10-29
 */
@RestController
public class Controller {

    @Value("${name.value}")
    private String name;

    @GetMapping("/hello")
    public String hello() {
        return "hello world , spring boot 2.0 " + name;
    }

}
