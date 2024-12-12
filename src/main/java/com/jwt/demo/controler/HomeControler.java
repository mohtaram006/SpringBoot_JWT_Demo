package com.jwt.demo.controler;

import com.jwt.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/home")

public class HomeControler {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public String getUser() {
        String user = userService.getUser().toString();
        return ("Hello Mr " + user);
    }

    @GetMapping("/user-logged")
    public String getLoggedInUser(Principal principal) {

        return ("Hello Mr " +  principal.getName());
    }
}
