package com.thanos.SecurityDemo.service;

import com.thanos.SecurityDemo.entity.DaoUserApp;
import com.thanos.SecurityDemo.entity.UserApp;
import com.thanos.SecurityDemo.security.enums.UserRole;
import com.thanos.SecurityDemo.repository.UserAppRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
public class DaoUserAppService implements UserDetailsService, CommandLineRunner {

    private final PasswordEncoder passwordEncoder;
    private final UserAppRepo userAppRepo;

    @Autowired
    public DaoUserAppService(PasswordEncoder passwordEncoder, UserAppRepo userAppRepo) {
        this.passwordEncoder = passwordEncoder;
        this.userAppRepo = userAppRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserApp> result = userAppRepo.findByName(username);
        if (result.isPresent()){
            return new DaoUserApp(result.get());
        } else throw new UsernameNotFoundException("Username " + username + " NOT found. Please try again.");
    }

    @Override
    public void run(String... args) throws Exception {
        List<UserApp> userAppList = Arrays.asList(
                new UserApp("admin","admin@yahoo.com", passwordEncoder.encode("tht1"),UserRole.ADMIN.name()),
                new UserApp("client","client@yahoo.com", passwordEncoder.encode("tht2"),UserRole.CLIENT.name()),
                new UserApp("ironman","ironman@yahoo.com", passwordEncoder.encode("tht3"),UserRole.CUSTOMER.name()),
                new UserApp("batman","batman@yahoo.com", passwordEncoder.encode("tht4"),UserRole.CUSTOMER.name())
        );
        userAppRepo.saveAll(userAppList);
    }
}
