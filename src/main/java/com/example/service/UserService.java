package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String getName(Long id) {
        return "Test";
    }
}
