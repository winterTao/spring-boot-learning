package com.tao.spring.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author DongTao
 * @since 2019-05-28
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "permission")
public class Permission extends BaseModel {

    /**
     * 权限名称，以 PERMISSION_ 开始
     */
    private String name;

    /**
     * 权限中文名称
     */
    private String nameZh;

    /**
     * 表示一个url pattern，即路径匹配规则
     */
    private String urlPattern;

    private Integer parentId;

    @Transient
    private List<Role> roles;
}
