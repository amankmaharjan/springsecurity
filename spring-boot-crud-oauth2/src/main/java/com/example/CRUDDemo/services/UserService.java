package com.example.CRUDDemo.services;

import com.example.CRUDDemo.domain.User;
import com.example.CRUDDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by aman on 6/14/17.
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void insert(User u) {
        userRepository.save(u);
    }

    public void update(Integer id, User editeduser) {
        User user = findOne(id);
        if (user != null) {
            user.setName(editeduser.getName());
            userRepository.save(user);
        }
    }

    public void delete(Integer id) {
        User user = findOne(id);
        if (user != null) {
            userRepository.delete(user);
        }
    }

    public List<User> findAll() {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    public User findOne(Integer id) {
        User user = userRepository.findOne(id);
        return user;
    }

    public User findByname(String name) {
        User user = userRepository.findByName(name);
        return  user;
    }
}

