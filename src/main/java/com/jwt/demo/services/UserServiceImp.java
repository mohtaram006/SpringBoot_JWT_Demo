package com.jwt.demo.services;

import com.jwt.demo.entities.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
public class UserServiceImp extends UserService {

    private ArrayList<User> userList= new ArrayList<>();

    public UserServiceImp() {
        userList.add(new User(UUID.randomUUID().toString(),"Mohtaram","mohtaram006@gmail.com","mohtaram","developer"));
        userList.add(new User(UUID.randomUUID().toString(),"Saad","saad006@gmail.com","saad","student"));

    }

    @Override
    public List<User> getUser() {
        return userList;
    }
}
