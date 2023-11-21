package com.momchi.back.User;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRepository {

    // Create
    void save(User user);

    // Read
    User findById(Long userId);
    User findByEmail(String email);
    List<User> getUserByRecord();
    // Update
    void update(User user);

    // Delete
    void deleteById(Long userId);

}
