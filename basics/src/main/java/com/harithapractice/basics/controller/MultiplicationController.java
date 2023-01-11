package com.harithapractice.basics.controller;

import com.harithapractice.basics.model.Multiplication;
import com.harithapractice.basics.model.Subtraction;
import com.harithapractice.basics.service.MultiplicationService;
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
public class MultiplicationController {
    @GetMapping("/multiplication")
    public String displayMultiplicationForm(Model model){
        return "/multiplication";
    }
    @PostMapping("/saveMulti")
    public ModelAndView createSubPage(@ModelAttribute Multiplication multiplication)
    {
        List<String> problems=new ArrayList<>();
        List<String> solutions=new ArrayList<>();
        MultiplicationService problem= new MultiplicationService();
        problems.addAll(problem.generateProblems(multiplication));
        solutions.addAll(problem.generateSolutions());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("multiplication_data");
        modelAndView.addObject("multiplication", multiplication);
        modelAndView.addObject("problems", problems);
        modelAndView.addObject("solutions", solutions);
        return modelAndView;
    }
}
