package com.tao.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DongTao
 * @since 2019-06-04
 */
@RestController
public class BaseController {


    @GetMapping("/level1/1")
    public String level11() {
        return "level1/1";
    }

    @GetMapping("/level1/2")
    public String level12() {
        return "level1/2";
    }

    @GetMapping("/level1/3")
    public String level13() {
        return "level1/3";
    }

    @GetMapping("/level2/1")
    public String level21() {
        return "level2/1";
    }

    @GetMapping("/level2/2")
    public String level22() {
        return "level2/2";
    }

    @GetMapping("/level2/3")
    public String level23() {
        return "level2/3";
    }

    @GetMapping("/level3/1")
    public String level31() {
        return "level3/1";
    }

    @GetMapping("/level3/2")
    public String level32() {
        return "level3/2";
    }

    @GetMapping("/level3/3")
    public String level33() {
        return "level3/3";
    }

}
