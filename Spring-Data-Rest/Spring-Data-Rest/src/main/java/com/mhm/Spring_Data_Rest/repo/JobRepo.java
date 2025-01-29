package com.mhm.Spring_Data_Rest.repo;

import com.mhm.Spring_Data_Rest.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {

//    List<JobPost> findByPostProfileContainingOrPostDescContaining(String postPofile, String postDesc);
}
