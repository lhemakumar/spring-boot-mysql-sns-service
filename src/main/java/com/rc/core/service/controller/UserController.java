package com.rc.core.service.controller;

import com.rc.core.service.UserService;
import com.rc.core.service.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/addUser")
    public String home(Model model) {
        model.addAttribute("addUser", new User());
        return "index";
    }

    @RequestMapping("/addUser")
    public String addUser(@ModelAttribute User user, Model model)
    {
        System.out.println("User Name "+user.getName());
        System.out.println("User Email "+user.getEmail());
        System.out.println("User Message "+user.getMessage());

        userService.addUser(user);

        model.addAttribute("addUser", new User());

        return "index";
    }
}
