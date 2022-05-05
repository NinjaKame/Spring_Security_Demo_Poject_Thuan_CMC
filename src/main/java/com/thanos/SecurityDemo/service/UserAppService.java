package com.thanos.SecurityDemo.service;

import com.thanos.SecurityDemo.entity.UserApp;
import com.thanos.SecurityDemo.repository.UserAppRepo;
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
