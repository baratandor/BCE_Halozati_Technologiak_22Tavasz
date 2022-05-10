package edu.corvinus.ZH2_01.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Fel01Controller
{
    @RequestMapping("/")
    public String Home()
    {
        return "home";
    }
}
