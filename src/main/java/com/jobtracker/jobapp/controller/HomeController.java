package com.jobtracker.jobapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //handler method to handle home page.
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("pageTitle", "Landing Page");
        model.addAttribute("message", "Stay on top of your Job Search");
        return "landingPage";
    }


    @GetMapping("/about-us")
    public String about(Model model){
        model.addAttribute("pageTitle", "About Us Page");
        return "aboutUsPage";
    }

    @GetMapping("/contact-us")
    public String contact(Model model){
        model.addAttribute("pageTitle", "Contact Us Page");
        return "contactUsPage";
    }
}
