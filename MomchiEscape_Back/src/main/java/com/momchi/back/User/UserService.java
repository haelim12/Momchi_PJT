package com.momchi.back.User;

public interface UserService {
    void save(User user);

    User findById(Long userId);

    User update(User user);

    void deleteById(Long userId);
}
