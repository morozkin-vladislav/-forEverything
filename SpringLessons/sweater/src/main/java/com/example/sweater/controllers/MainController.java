package com.example.sweater.controllers;

import com.example.sweater.domain.Massage;
import com.example.sweater.repository.MassageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private MassageRepo massageRepo;


    @GetMapping("/")
    public String greeting(Model model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Model model) {
        Iterable<Massage> massages = massageRepo.findAll();
        model.addAttribute("massages", massages);
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String text, @RequestParam String tag, Model model) {
        massageRepo.save(new Massage(text, tag));
        Iterable<Massage> massages = massageRepo.findAll();
        model.addAttribute("massages", massages);
        return "main";
    }
}