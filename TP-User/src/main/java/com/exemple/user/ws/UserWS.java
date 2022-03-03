package com.exemple.user.ws;

import com.exemple.user.bean.User;
import com.exemple.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserWS {
    @Autowired
    private UserService userService;
    @GetMapping("/")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/login/{login}")
    public User findByLogin(@PathVariable String login) {
        return userService.findByLogin(login);
    }

    @RequestMapping("/")
    public int register(@RequestBody User user) {
        return userService.register(user);
    }

    @Transactional
    @DeleteMapping ("/login/{login}")
    public int deleteByLogin(@PathVariable String login) {
        return userService.deleteByLogin(login);
    }

    @GetMapping("/blocked/{blocked}")
    public List<User> findByBlocked(@PathVariable boolean blocked) {
        return userService.findByBlocked(blocked);
    }
    @Transactional
    @DeleteMapping("/blocked/{blocked}")
    public int deleteByBlocked(@PathVariable boolean blocked) {
        return userService.deleteByBlocked(blocked);
    }

    @GetMapping("/login/{login}/password/{password}")
    public int seConnect( @PathVariable String login, @PathVariable String password) {
        return userService.seConnect(login, password);
    }


    @PutMapping("/login/{login}")
    public int block(@PathVariable String login) {
        return userService.block(login);
    }
}
