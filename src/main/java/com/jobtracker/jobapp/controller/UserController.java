package com.jobtracker.jobapp.controller;

import com.jobtracker.jobapp.dto.UserDto;
import com.jobtracker.jobapp.entity.User;
import com.jobtracker.jobapp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    //handler method to handle user registration form request.

    @GetMapping("/register")
    public String registrationForm(Model model){

        UserDto userDto = new UserDto();
        model.addAttribute("user",userDto);
        model.addAttribute("pageTitle", "Registration");//model object is used to store data that is entered from form.
        return "register";

    }
    //handler method to handle user registration form submit request.

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result, Model model){ //Model attribute is used to extract model object which is a form data.

        System.out.println("Dto ============================== " + userDto.getUsername());

        User checkUser = userService.findByUsername(userDto.getUsername()); //checking if entered email already exists or not.

        if(checkUser != null && checkUser.getEmail()!=null && !checkUser.getEmail().isEmpty()){
            result.rejectValue("username",null,"there is already an account existed with this email");
        }

        /*
        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/register"; // if any form has errors it will be redirected to register page only.
        }
        */

        userService.createNewUser(userDto);
        return "redirect:/login"; // @Valid from jakarta.validation will enable the validation fields of dto objectsto be enabled.
    }

    //handler methods for getting list of users.
    @GetMapping("/users")
    public String users(Model model){
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    //handler methods for handling login request.

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("pageTitle", "Login");
        return "login";
    }
}
