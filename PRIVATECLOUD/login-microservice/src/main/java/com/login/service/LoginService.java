package com.login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.login.dto.Message;
import com.login.entity.UserInfo;
import com.login.repository.UserInfoRepository;

@Service
public class LoginService {

    @Autowired
    private UserInfoRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public Message addUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return new Message("User added to system");
    }
    
    public List<UserInfo> listAllUsers() {
    	return repository.findAll();
    }
}
