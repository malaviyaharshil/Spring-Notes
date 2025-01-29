package com.mhm.Springboot_Rest;

import com.mhm.Springboot_Rest.model.JobPost;
import com.mhm.Springboot_Rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@Controller
@RestController //no need to use @ResponseBody
@CrossOrigin("http://localhost:3000/")
public class JobRestController {

    @Autowired
    private JobService jobService;

    @GetMapping(path="jobPosts",produces = {"application/json"})
//    @ResponseBody
    public List<JobPost> getAllJobs(){
        return jobService.getAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId){
        return jobService.getJob(postId);
    }

    @PostMapping(path="jobPost",consumes = {"application/json"})
    public JobPost addJob(@RequestBody JobPost job){
        jobService.addJob(job);
        return jobService.getJob(job.getPostId());
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost job){
        jobService.updateJob(job);
        return jobService.getJob(job.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public void updateJob(@PathVariable("postId") int postId){
         jobService.deleteJob(postId);

    }

    @GetMapping("load")
    public String load(){
        jobService.load();
        return "Success";
    }

    @GetMapping("keyword/{keyword}")
    public List<JobPost> keyword(@PathVariable("keyword") String keyword){
        return jobService.keywordsearch(keyword);
    }
}
