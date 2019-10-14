package com.tao.spring.conditions;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * @author DongTao
 * @since 2019-09-16
 */
@Component
@ConditionalOnProperty(prefix = "company.shzq", name = "enabled")
public class TestD implements InterfaceBean {

    @Override
    public void printString() {
        System.out.println("test D");
    }
}
