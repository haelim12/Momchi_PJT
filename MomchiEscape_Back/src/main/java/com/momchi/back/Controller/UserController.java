package com.momchi.back.Controller;

import com.momchi.back.User.User;
import com.momchi.back.User.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;

    // 회원가입
    // create - post
    @PostMapping("/regist")
    public ResponseEntity regist(@RequestBody User user) {
        System.out.println(user.toString());
        userService.save(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    // 로그인 - post
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user) {
        return new ResponseEntity(userService.login(user), HttpStatus.OK);
    }

    // 회원정보 수정 - put
    @PutMapping("/user/{id}")
    public ResponseEntity update(@RequestBody User user, @PathVariable Long id) {
        return new ResponseEntity(userService.update(user), HttpStatus.OK);
    }

    // 회원 탈퇴 - delete
    @DeleteMapping("/user/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        userService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
