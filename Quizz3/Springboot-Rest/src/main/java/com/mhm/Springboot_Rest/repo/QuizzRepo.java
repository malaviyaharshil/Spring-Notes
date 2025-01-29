package com.mhm.Springboot_Rest.repo;

import com.mhm.Springboot_Rest.model.Quizz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizzRepo extends JpaRepository<Quizz,Integer> {
}
