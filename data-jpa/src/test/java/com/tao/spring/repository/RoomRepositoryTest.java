package com.tao.spring.repository;

import com.tao.spring.model.Room;
import com.tao.spring.model.User;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author DongTao
 * @since 2019-04-02
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class RoomRepositoryTest {

    private RoomRepository roomRepository;

    private UserRepository userRepository;

    @Autowired
    public void setRoomRepository(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    //    @Before
//    @Transactional
//    public void setUp() throws Exception {
//        final Room room = new Room();
//        final User user1 = new User();
//        final User user2 = new User();
//
//        room.setArea("area");
//        user1.setUsername("dong");
//        user1.setPassword("123");
//        user2.setUsername("tao");
//        user2.setPassword("456");
//
//        user1.setRoom(room);
//        user2.setRoom(room);
//        List<User> userList = new ArrayList<>();
//        userList.add(user1);
//        userList.add(user2);
//        room.setUserList(userList);
//
//        final Room save = roomRepository.save(room);
//
//        log.info("---> {}", save);
//    }

    @Test
    public void findAll() {
        final List<Room> all = roomRepository.findAll();

        for (Room room : all) {
            log.info("==> {}", room);
            log.info("==> {}", room.getUserList());
        }

        final List<User> all1 = userRepository.findAll();
        for (User user : all1) {
            log.info("-------> {}", user);
            log.info("-------> {}", user.getRoom());
        }
    }
}