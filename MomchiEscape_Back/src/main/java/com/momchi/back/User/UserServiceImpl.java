package com.momchi.back.User;

import com.momchi.back.Exception.CustomException;
import com.momchi.back.Exception.ErrorHTTPStatus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl {
    private final UserRepository userRepository;

    public void save(User user){
        User user1 = userRepository.findByEmail(user.getEmail());
        if(user1!= null){
            throw new CustomException(ErrorHTTPStatus.DUPLICATE_EMAIL);
        }
        userRepository.save(user);
    }
    public User login(User user) {
        User user1 = userRepository.findByEmail(user.getEmail());
        if(user1 == null || !user1.isEnabled()){
            throw new CustomException(ErrorHTTPStatus.USER_NOT_EXIST);
        }
        if (user1.getPassword().equals(user.getPassword())) {
            return user1;
        } else {
            throw new CustomException(ErrorHTTPStatus.USER_NOT_EXIST);
        }
    }
    public User findById(Long userId) {
        User user = userRepository.findById(userId);
        User user1 = new User();
        user1.setName(user.getName());
        user1.setNickname(user.getNickname());
        return user1;
    }
    public List<User> getPopularUser(){
        return userRepository.getUserByRecord();
    }

    public User update(User user) {
        userRepository.update(user);
        return userRepository.findById(user.getUserId());
    }

    public void deleteById(Long userId){
        userRepository.deleteById(userId);
    }
}
