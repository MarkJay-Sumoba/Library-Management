package com.jac.springboot.librarymanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    //Login Access
    @GetMapping("/LoginPage")
    public String showMyLoginPage() {
        return "/Login/login";
    }

}



