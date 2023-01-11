package com.harithapractice.basics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {


    public HomeController() {
        super();
    }

    @RequestMapping("/")
    public String home(Model model)
    {
        return"home";
    }
    @GetMapping("/home")
    public String displayHomeForm(Model model){
        return "/home";
    }







}
