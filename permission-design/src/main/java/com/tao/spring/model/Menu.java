package com.tao.spring.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author DongTao
 * @since 2019-05-28
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "menu")
public class Menu extends BaseModel {

    private String name;

    private String path;

    private Object component;

    private String iconCls;

    private Long parentId;

    private boolean keepAlive;

    private boolean requireAuth;
}
