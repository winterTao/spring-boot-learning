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
@Table(name = "user_role")
public class UserRole extends BaseModel {

    private Integer userId;

    private Integer roleId;
}
