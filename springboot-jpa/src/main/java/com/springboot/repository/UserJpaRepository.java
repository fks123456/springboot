package com.springboot.repository;

import com.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserJpaRepository extends JpaRepository<User, Integer> {

    @Query("select user from User user where user.id = ?1")
    public User aa(Integer id);
}
