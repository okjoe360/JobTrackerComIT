package com.jobtracker.jobapp.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.jobtracker.jobapp.dto.JobDto;
import com.jobtracker.jobapp.dto.UserDto;
import com.jobtracker.jobapp.entity.Jobs;
import com.jobtracker.jobapp.entity.User;
import com.jobtracker.jobapp.repository.JobRepository;
import com.jobtracker.jobapp.repository.UserRepository;
import com.jobtracker.jobapp.service.JobService;
import com.jobtracker.jobapp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class JobsController {

    private JobService jobService;

    public JobsController(JobService jobService){
        this.jobService=jobService;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model){
        List<JobDto> jobs = jobService.findAllJob();
        model.addAttribute("jobs", jobs);
        model.addAttribute("PageTitle", "Dashboard");
        model.addAttribute("message", "Stay on top of your Job Search");
        return "dashboard";
    }

    @GetMapping("/job/create")
    public String jobsForm(Model model){
        JobDto jobDto = new JobDto();
        model.addAttribute("job", jobDto);
        model.addAttribute("pageTitle", "Create Job");
        return "jobs/jobForm";
    }


    @PostMapping("/job/save")
    public String jobCreatePost(@Valid @ModelAttribute("jobs") JobDto jobDto, Model model) {
        jobService.createJob(jobDto);
        return "redirect:/dashboard";
    }

    @GetMapping("/job/detail/{idJob}")
    public String jobDetail(@PathVariable Long idJob, Model model){
        Optional<Jobs> job = jobService.findJobById(idJob);
        model.addAttribute("job", job.orElse(null));
        model.addAttribute("pageTitle", "Job Detail");
        return "jobs/jobDetail";
    }

    @GetMapping("/job/update/{idJob}")
    public String getJobUpdate(@PathVariable Long idJob, Model model){
        Optional<Jobs> job = jobService.findJobById(idJob);
        model.addAttribute("job", job.orElse(null));
        model.addAttribute("pageTitle", "Job Detail Update");
        return "jobs/jobUpdateForm";
    }

    @PostMapping("/job/update/{idJob}")
    public String postJobUpdate(@PathVariable Long idJob, @Valid @ModelAttribute("jobs") Jobs job, Model model){
        jobService.updateJob(job);
        return "redirect:/job/detail/" + idJob;
    }

    @GetMapping("/job/delete/{idJob}")
    public String getJobDelete(@PathVariable Long idJob, Model model){
        Optional<Jobs> job = jobService.findJobById(idJob);
        model.addAttribute("job", job.orElse(null));
        model.addAttribute("pageTitle", "Job Detail Delete");
        return "jobs/jobDeleteForm";
    }

    @PostMapping("/job/delete/{idJob}")
    public String postJobDelete(@PathVariable Long idJob){
        jobService.deleteJob(idJob);
        return "redirect:/dashboard";
    }
}
