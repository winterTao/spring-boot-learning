package com.tao.spring;

import com.tao.spring.conditions.InterfaceBean;
import com.tao.spring.config.HbzqProperties;
import com.tao.spring.config.ShzqProperties;
import com.tao.spring.config.ZszqProperties;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author DongTao
 * @since 2019-09-02
 */
@SpringBootApplication
@EnableConfigurationProperties({HbzqProperties.class, ShzqProperties.class, ZszqProperties.class})
public class ConditionApplication {

    private InterfaceBean interfaceBean;

    @Autowired
    public void setInterfaceBean(InterfaceBean interfaceBean) {
        this.interfaceBean = interfaceBean;
    }

    @PostConstruct
    public void init() {
        interfaceBean.printString();
    }

    public static void main(String[] args) {
        SpringApplication.run(ConditionApplication.class);
    }

}
