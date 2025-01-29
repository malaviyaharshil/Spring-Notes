package com.mhm.Springboot_Rest.repo;

import com.mhm.Springboot_Rest.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {

    List<JobPost> findByPostProfileContainingOrPostDescContaining(String postPofile, String postDesc);
}
//List<JobPost> jobs = new ArrayList<>();
//
//    public JobRepo() {
//
//        // Java Developer Job Post
//        jobs.add(new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
//                List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")));
//
//        // Frontend Developer Job Post
//        jobs.add(
//                new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",
//                        3, List.of("HTML", "CSS", "JavaScript", "React")));
//
//        // Data Scientist Job Post
//        jobs.add(new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
//                List.of("Python", "Machine Learning", "Data Analysis")));
//
//        // Network Engineer Job Post
//        jobs.add(new JobPost(4, "Network Engineer",
//                "Design and implement computer networks for efficient data communication", 5,
//                List.of("Networking", "Cisco", "Routing", "Switching")));
//
//        // Mobile App Developer Job Post
//        jobs
//                .add(new JobPost(5, "Mobile App Developer", "Experience in mobile app development for iOS and Android",
//                        3, List.of("iOS Development", "Android Development", "Mobile App")));
//
//        // DevOps Engineer Job Post
//        jobs.add(
//                new JobPost(6, "DevOps Engineer", "Implement and manage continuous integration and delivery pipelines",
//                        4, List.of("DevOps", "CI/CD", "Docker", "Kubernetes")));
//
//        // UI/UX Designer Job Post
//        jobs
//                .add(new JobPost(7, "UI/UX Designer", "Create engaging user experiences and intuitive user interfaces",
//                        2, List.of("User Experience", "User Interface Design", "Prototyping")));
//
//        // Cybersecurity Analyst Job Post
//        jobs
//                .add(new JobPost(8, "Cybersecurity Analyst", "Protect computer systems and networks from cyber threats",
//                        4, List.of("Cybersecurity", "Network Security", "Incident Response")));
//
//
//    }
//
//    public List<JobPost> getAllJob() {
//        return jobs;
//    }
//
//    public void addJobPost(JobPost job) {
//        jobs.add(job);
//        System.out.println(jobs);
//    }
//
//    public JobPost getJob(int postId) {
//
//        for(JobPost job : jobs) {
//            if(job.getPostId()==postId){
//                return job;
//            }
//        }
//        return null;
//    }
//
//    public void updateJob(JobPost job) {
//        for(JobPost jobPost : jobs) {
//            if(jobPost.getPostId()==job.getPostId()){
//                jobPost.setPostProfile(job.getPostProfile());
//                jobPost.setPostDesc(job.getPostDesc());
//                jobPost.setReqExperience(job.getReqExperience());
//                jobPost.setPostTechStack(job.getPostTechStack());
//            }
//        }
//    }
//
//    public String deleteJob(int postId) {
//        for(JobPost jobPost : jobs) {
//            if(jobPost.getPostId()==postId){
//               String title = jobPost.getPostProfile();
//               jobs.remove(jobPost);
//               return title;
//            }
//        }
//        return null;
//    }