package com.example.MarketAnalizeSite.controllers;

import com.example.MarketAnalizeSite.models.users.User;
import com.example.MarketAnalizeSite.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {

    private final UserService userService;

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String createUser(User user, Model model) {
        if (userService.createUser(user)) {
            model.addAttribute("errorMessage", STR."Пользователь с email:\{user.getEmail()}уже существует");
            return "registration";
        }
        return "redirect:/login";
    }

    @GetMapping("/hello")
    public String securityUrl() {
        return "hello";
    }

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/stats")
    public String stats() {
        return "stats";
    }

    @GetMapping("/account")
    public String account() {
        return "account";
    }
    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }
}
