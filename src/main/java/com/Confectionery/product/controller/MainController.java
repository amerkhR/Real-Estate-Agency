package com.Confectionery.product.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;


@Controller
@RequiredArgsConstructor
public class MainController {


    @GetMapping("/")
    public String root(Principal principal, Model model) {
        if(principal != null){
            String username = principal.getName();
            model.addAttribute("username",username);
        }
        return "main";
    }

}