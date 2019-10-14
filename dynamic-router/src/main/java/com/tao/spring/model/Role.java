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
@Table(name = "role")
public class Role extends BaseModel {

    /**
     * 角色名称，以 ROLE_ 开始
     */
    private String name;

    /**
     * 角色中文名称
     */
    private String nameZh;
}
