package com.allteran.mirage.rootservice.service;

import com.allteran.mirage.rootservice.domain.Role;
import com.allteran.mirage.rootservice.domain.User;
import com.allteran.mirage.rootservice.repo.UserRepository;
import com.allteran.mirage.rootservice.util.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public User findById(String id) {
        return userRepo.findUserById(id);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    //this method will create any type of users
    public User createUser(User user, Role role) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Collections.singleton(role));
        user.setActive(true);
        user.setCreationDate(LocalDateTime.now());
        user.setDismissalDate(Const.DEFAULT_DATE);

        return user;
    }

    public User createAdmin(User admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(Role.ADMINISTRATOR);
        roles.add(Role.MANAGER);
        roles.add(Role.HEAD_ENGINEER);
        roles.add(Role.ENGINEER);
        roles.add(Role.USER);

        admin.setRoles(roles);
        admin.setCreationDate(LocalDateTime.now());
        admin.setDismissalDate(Const.DEFAULT_DATE);

        return admin;
    }

    //TODO: updateUser, updateProfile, deleteUser, dismissUser
}
