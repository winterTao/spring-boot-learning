package com.tao.spring.repository;

import com.tao.spring.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author DongTao
 * @since 2019-03-22
 */
@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

}
