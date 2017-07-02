package com.example.CRUDDemo.repository;

import com.example.CRUDDemo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by aman on 6/14/17.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByName(String name);
}
