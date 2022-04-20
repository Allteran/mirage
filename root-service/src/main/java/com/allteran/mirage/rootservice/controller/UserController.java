package com.allteran.mirage.rootservice.controller;

import com.allteran.mirage.rootservice.domain.Role;
import com.allteran.mirage.rootservice.domain.User;
import com.allteran.mirage.rootservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/root-service/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("name/{id}")
    public String getUserFullName(@PathVariable("id") User user) {
        return user.getFirstName() + " " + user.getLastName();
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("{id}")
    public User findById(@PathVariable("id") User user) {
        return user;
    }

    @PostMapping("new/user")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user, Role.USER);
    }

    @PostMapping("new/engineer")
    public User createEngineer(@RequestBody User user) {
        return userService.createUser(user, Role.ENGINEER);
    }

    @PostMapping("new/head-engineer")
    public User createHeadEngineer(@RequestBody User user) {
        return userService.createUser(user, Role.HEAD_ENGINEER);
    }

    @PostMapping("new/manager")
    public User createManager(@RequestBody User user) {
        return userService.createUser(user, Role.MANAGER);
    }

    @PostMapping("secret/new/admin")
    public User createAdmin(@RequestBody User user) {
        return userService.createAdmin(user);
    }

    @GetMapping("testdata")
    public String getTestData() {
        return "You got test data from root-service";
    }

    //TODO: updateUser, updateProfile, delete
}
