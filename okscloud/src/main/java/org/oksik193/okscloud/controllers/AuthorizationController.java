package org.oksik193.okscloud.controllers;

import org.oksik193.okscloud.domain.Role;
import org.oksik193.okscloud.domain.User;
import org.oksik193.okscloud.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.Map;

@Controller
public class AuthorizationController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/login")
    public String signIn (Model model) {
        return "/authorization/login";
    }

    @GetMapping("/signUp")
    public String signUp (Model model) { return "/authorization/signUp"; }

    @PostMapping("/signUp")
    public String addUser (User user,
                           @RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String password2,
                           Map<String, Object> model) {
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.put("message", "Пользователь с таким иеменем уже существует");
            return "/authorization/signUp";
        }

        if(password != null && password.equals(password2) && username != null) {
            user.setUsername(username);
            user.setActive(true);
            user.setPassword(password);
            user.setRoles(Collections.singleton(Role.USER));
            userRepo.save(user);

            return "/authorization/login";
        }

        model.put("message", "Данные заполнены неверно");
        return "/authorization/signUp";
    }
}
