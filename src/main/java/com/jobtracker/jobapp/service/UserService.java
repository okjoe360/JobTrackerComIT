package com.jobtracker.jobapp.service;

import com.jobtracker.jobapp.dto.UserDto;
import com.jobtracker.jobapp.entity.User;

import java.util.List;

public interface UserService {
    void createNewUser(UserDto userDto);

    User findByUsername(String username);

    User findByEmail(String email);

    List<UserDto> findAllUsers();

    void updateUser(UserDto userDto);

    void deleteUser(UserDto userDto);
}
