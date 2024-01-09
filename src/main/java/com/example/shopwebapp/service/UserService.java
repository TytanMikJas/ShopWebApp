package com.example.shopwebapp.service;

import com.example.shopwebapp.dto.UserDto;
import com.example.shopwebapp.entity.User;

public interface UserService {

    User save(UserDto userDto);

}
