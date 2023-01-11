package com.harithapractice.basics.controller;

import com.harithapractice.basics.model.Subtraction;
import com.harithapractice.basics.service.SubtractionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SubtractionController {
    @GetMapping("/subtraction")
    public String displaySubtractionForm(Model model){
        return "/subtraction";
    }
    @PostMapping("/saveSub")
    public ModelAndView createSubPage(@ModelAttribute Subtraction subtraction)
    {
        List<String> problems=new ArrayList<>();
        List<String> solutions=new ArrayList<>();
        SubtractionService problem= new SubtractionService();
        problems.addAll(problem.generateProblems(subtraction));
        solutions.addAll(problem.generateSolutions());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("subtraction_data");
        modelAndView.addObject("subtraction", subtraction);
        modelAndView.addObject("problems", problems);
        modelAndView.addObject("solutions", solutions);
        return modelAndView;
    }
}
