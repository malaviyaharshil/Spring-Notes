package com.mhm.SpringDataJpa1;

import com.mhm.SpringDataJpa1.model.Student;
import com.mhm.SpringDataJpa1.repo.StudentRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class SpringDataJpa1Application {

	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(SpringDataJpa1Application.class, args);
		StudentRepo repo = context.getBean(StudentRepo.class);
		Student s1 = context.getBean(Student.class);
		Student s2 = context.getBean(Student.class);
		Student s3 = context.getBean(Student.class);

		s3.setId(101);
		s3.setName("John");
		s3.setMarks(98);

		s2.setId(102);
		s2.setName("Bob");
		s2.setMarks(67);

		s1.setId(103);
		s1.setName("David");
		s1.setMarks(95);

//		repo.save(s2);
//		repo.save(s3);

//		System.out.println(repo.findAll());

//		Optional<Student> s = repo.findById(10);
//		System.out.println(s.orElse(new Student()));
//
//		System.out.println(repo.findByName("Bob"));

//		System.out.println(repo.findByMarksGreaterThan(97));

//		repo.save(s2); //updating object

		repo.delete(s2); //deleting object
	}

}
