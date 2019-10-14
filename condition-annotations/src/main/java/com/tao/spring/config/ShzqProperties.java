package com.tao.spring.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author DongTao
 * @since 2019-09-16
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "company.shzq")
public class ShzqProperties {

    private Boolean enabled = false;

}
