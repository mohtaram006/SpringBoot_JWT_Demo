package com.jwt.demo.repositories;

import com.jwt.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {
    public Optional<User>  findByEmail(String email);

}
