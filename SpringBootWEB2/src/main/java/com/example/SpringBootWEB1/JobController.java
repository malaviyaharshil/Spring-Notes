package com.example.SpringBootWEB1;

import com.example.SpringBootWEB1.model.JobPost;
import com.example.SpringBootWEB1.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping({"/","home"})
    public String home(){
        System.out.println("home called");
        return "home";
    }

    @GetMapping("addjob")
    public String addJob(){
        return "addjob";
    }

    @PostMapping("handleForm")
    public String handleForm(JobPost jobpost){
        jobService.addJob(jobpost);
        return "success";
    }

    @GetMapping("viewalljobs")
    public String viewAllJobs(Model model){
        List<JobPost> jobs = jobService.getAllJobs();
        model.addAttribute("jobPosts",jobs);
        return "viewalljobs";
    }
}
