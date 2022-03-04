package com.test.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired private UserService service;

    @GetMapping("/users")
    public String showUserList(Model model){
        List<User> userLists = service.listAll();
        model.addAttribute("listUsers",userLists);

        return "users";
    }

    @GetMapping("/users/new")
    public String showNewForm(Model model){
        List<User> userLists = service.listAll();
        model.addAttribute("user",new User());

        return "new";
    }
}
