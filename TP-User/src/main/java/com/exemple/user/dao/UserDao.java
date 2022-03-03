package com.exemple.user.dao;
import com.exemple.user.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User,Long> {
    User findByLogin(String login);
    int deleteByLogin(String login);
    int deleteByBlocked(boolean blocked);
    List <User> findByBlocked(boolean blocked);
    List<User> findAll();
}
