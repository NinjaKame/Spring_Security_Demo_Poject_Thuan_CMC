package com.thanos.SecurityDemo.userRepository;

import com.thanos.SecurityDemo.Entity.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAppRepo extends JpaRepository<UserApp,Long> {
    Optional<UserApp> findByName(String username);
}
