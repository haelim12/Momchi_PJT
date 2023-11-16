package com.momchi.back.User;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void save(User user){
        userRepository.save(user);
    }

    public User login(User user) {
        User user1 = userRepository.findByEmail(user.getEmail());
        if (user1.getPassword().equals(user.getPassword())) {
            return user1;
        } else {
            return null;
        }
    }
    @Override
    public User findById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public User update(User user) {
        userRepository.update(user);
        return userRepository.findById(user.getUserId());
    }

    @Override
    public void deleteById(Long userId){
        userRepository.deleteById(userId);
    }
}
