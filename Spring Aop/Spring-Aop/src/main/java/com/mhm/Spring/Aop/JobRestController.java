package com.mhm.Spring.Aop;

import com.mhm.Spring.Aop.model.JobPost;
import com.mhm.Spring.Aop.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path="jobPost",consumes = {"application/xml"})
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
    public String updateJob(@PathVariable("postId") int postId){
        return jobService.deleteJob(postId);

    }
}
