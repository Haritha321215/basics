package com.harithapractice.basics.controller;

import com.harithapractice.basics.model.Addition;
import com.harithapractice.basics.service.AdditionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdditionController {
    @GetMapping("/addition")
    public String displayAdditionForm(Model model){
        return "/addition";
    }
    @PostMapping("/saveAdd")
    public ModelAndView createAddPage(@ModelAttribute Addition addition)
    {
        List<String> problems=new ArrayList<>();
        List<String> solutions=new ArrayList<>();
        AdditionService problem= new AdditionService();
        problems.addAll(problem.generateProblems(addition));
        solutions.addAll(problem.generateSolutions());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addition_data");
        modelAndView.addObject("addition", addition);
        modelAndView.addObject("problems", problems);
        modelAndView.addObject("solutions", solutions);
        return modelAndView;
    }
}
