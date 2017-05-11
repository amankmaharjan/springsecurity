package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.User;
import com.mycompany.myapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by aman on 5/11/17.
 */
@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findById(Integer id) {
        return userRepository.findOne(id);
    }

    public User findByName(String name) {
        return userRepository.findByUsername(name);
    }


}
