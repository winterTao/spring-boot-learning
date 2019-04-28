package com.tao.spring.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @author DongTao
 * @since 2019-04-02
 */
@Getter
@Setter
@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String area;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, targetEntity = User.class)
    private List<User> userList;

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", area='" + area + '\'' +
                '}';
    }
}
