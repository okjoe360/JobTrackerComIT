package com.jobtracker.jobapp.controller;

import com.jobtracker.jobapp.dto.EducationDto;
import com.jobtracker.jobapp.entity.Education;
import com.jobtracker.jobapp.service.EducationService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/education")
public class EduController {
    private EducationService eduService;

    public EduController(EducationService eduService){
        this.eduService=eduService;
    }

    @GetMapping("")
    public String edu(Model model){
        List<EducationDto> edus = eduService.findAll();
        model.addAttribute("edus", edus);
        model.addAttribute("PageTitle", "Education");
        return "education/education";
    }

    @GetMapping("/create")
    public String createForm(Model model){
        EducationDto eduDto = new EducationDto();
        model.addAttribute("edu", eduDto);
        model.addAttribute("pageTitle", "Add Educational Credentials");
        return "education/createEduForm";
    }


    @PostMapping("/create")
    public String createFormSave(@Valid @ModelAttribute("edu") EducationDto eduDto, Model model) {
        eduService.create(eduDto);
        return "redirect:/education";
    }

    @GetMapping("/detail/{id}")
    public String Detail(@PathVariable Long id, Model model){
        Optional<Education> edu = eduService.findById(id);
        model.addAttribute("edu", edu.orElse(null));
        model.addAttribute("pageTitle", "Education Credentials Detail");
        return "education/eduDetail";
    }

    @GetMapping("/update/{id}")
    public String getUpdate(@PathVariable Long id, Model model){
        Optional<Education> edu = eduService.findById(id);
        model.addAttribute("edu", edu.orElse(null));
        model.addAttribute("pageTitle", "Education Credential Detail Update");
        return "education/eduUpdateForm";
    }

    @PostMapping("/update/{id}")
    public String postUpdate(@PathVariable Long id, @Valid @ModelAttribute("edu") Education edu, Model model){
        edu.setIdEducation(id);
        eduService.update(edu);
        return "redirect:/education";
    }

    @GetMapping("/delete/{id}")
    public String getDelete(@PathVariable Long id, Model model){
        Optional<Education> edu = eduService.findById(id);
        model.addAttribute("edu", edu.orElse(null));
        model.addAttribute("pageTitle", "Education Credential Delete");
        return "education/eduDeleteForm";
    }

    @PostMapping("/delete/{id}")
    public String postJobDelete(@PathVariable Long id){
        eduService.delete(id);
        return "redirect:/education";
    }
}
