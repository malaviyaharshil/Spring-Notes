package com.mhm.Spring.Aop.service;

import com.mhm.Spring.Aop.model.JobPost;
import com.mhm.Spring.Aop.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public void addJob(JobPost job){
        repo.addJobPost(job);
    }
    public List<JobPost> getAllJobs(){
        return repo.getAllJob();
    }

    public JobPost getJob(int postId) {
//        int n=10/0;
        return repo.getJob(postId);
    }

    public void updateJob(JobPost job) {
        repo.updateJob(job);
    }

    public String deleteJob(int postId) {
        return repo.deleteJob(postId);
    }
}
