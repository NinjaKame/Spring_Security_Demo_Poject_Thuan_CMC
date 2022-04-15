package com.thanos.SecurityDemo.userService;

import com.thanos.SecurityDemo.Entity.UserApp;
import com.thanos.SecurityDemo.userRepository.UserAppRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAppService {

    @Autowired
    private UserAppRepo userAppRepo;

    public List<UserApp> getAllUserApp(){
        return userAppRepo.findAll();
    }

}
