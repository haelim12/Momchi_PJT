package com.momchi.back.User;

import com.momchi.back.Exception.CustomException;
import com.momchi.back.Exception.ErrorHTTPStatus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void save(User user){
        User user1 = userRepository.findByEmail(user.getEmail());
        if(user1!= null){
            throw new CustomException(ErrorHTTPStatus.DUPLICATE_EMAIL);
        }
        userRepository.save(user);
    }

    public User login(User user) {
        User user1 = userRepository.findByEmail(user.getEmail());
        if(user1 == null){
            throw new CustomException(ErrorHTTPStatus.USER_NOT_EXIST);
        }
        if (user1.getPassword().equals(user.getPassword())) {
            return user1;
        } else {
            throw new CustomException(ErrorHTTPStatus.USER_NOT_EXIST);
        }
    }
    @Override
    public User findById(Long userId) {
        User user = userRepository.findById(userId);
        User user1 = new User();
        user1.setName(user.getName());
        return user1;
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
