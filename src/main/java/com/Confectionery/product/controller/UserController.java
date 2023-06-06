package com.Confectionery.product.controller;

import com.Confectionery.product.entity.User;
import com.Confectionery.product.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, RedirectAttributes redirectAttributes) {
        if (!userService.createUser(user)){
            redirectAttributes.addAttribute("error","Пользователь с почтой: " + user.getEmail() + " уже зарегистрирован");
            return "redirect:/registration";
        }
        userService.createUser(user);
        return "redirect:/login";
    }

}
