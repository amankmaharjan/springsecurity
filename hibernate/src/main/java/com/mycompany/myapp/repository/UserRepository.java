package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by aman on 5/11/17.
 */

public interface UserRepository extends JpaRepository<User,Integer>{
    public User findByUsername(String name);
}
