package com.jac.springboot.librarymanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    // Leaders Access
    @GetMapping("/managers")
    public String showAccessLeaders(){
        return "/User/managers";
    }

    // Systems Access
    @GetMapping("/admins")
    public String showAccessSystems(){
        return "/User/admins";
    }

    // Denying Access
    @GetMapping("/access-denied")
    public String showAccessDenied(){
        return "/User/access-denied";
    }
}
