package com.tao.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DongTao
 * @since 2018-10-30
 */
@RestController
public class AopController {

  @RequestMapping(value = "/hello", method = RequestMethod.GET)
  @ResponseBody
  public String hello(@RequestParam String name) {
    return "Hello " + name;
  }
}
