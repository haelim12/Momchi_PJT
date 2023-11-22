package com.momchi.back.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long userId;
    private String name;
    private String email;
    private String password;
    private String nickname;
    private LocalDate birthday;
    private String level;
    private boolean enabled;
}
