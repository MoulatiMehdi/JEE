package com.exemple.user.service;

import com.exemple.user.dao.UserDao;
import com.exemple.user.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public int deleteByLogin(String login) {
            return userDao.deleteByLogin(login);
    }

    public List<User> findByBlocked(boolean blocked) {
        return userDao.findByBlocked(blocked);
    }

    public int deleteByBlocked(boolean blocked) {

        return userDao.deleteByBlocked(blocked);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User findByLogin(String login) {
        return userDao.findByLogin(login);
    }

    public int register(User user){
        if( findByLogin(user.getLogin())!=null){
            return -1;
        }
        else if(user.getPassword().length()<8){
            return -2;
        }
        else
        {   user.setBlocked(true);
            userDao.save(user);
            return 0;
        }
    }
    public int seConnect(String login,String password){
        User user=findByLogin(login);
        if(user == null){
            return -1;
        }
        else if (!user.getPassword().equals(password)){
            return -2;
        }
        else if( user.isBlocked()){
            return -3;
        }
        else{
            return 1;
        }
    }

    // block
    public int block(String login){
        User user=findByLogin(login);
        if(! user.isBlocked()){
            user.setBlocked(true);
            userDao.save(user);
        }
            return 0;
    }

}
