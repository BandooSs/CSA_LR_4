package com.example.LR_2.controllers;

import org.springframework.stereotype.Controller; // Добавлен импорт
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // Добавлена аннотация @Controller
public class MainController {
    @GetMapping("/")
    public String home(Model model){
        return "homePage";
    }


}
