package com.mhm.Quiz_Service.repo;


import com.mhm.Quiz_Service.model.Quizz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizzRepo extends JpaRepository<Quizz,Integer> {
}
