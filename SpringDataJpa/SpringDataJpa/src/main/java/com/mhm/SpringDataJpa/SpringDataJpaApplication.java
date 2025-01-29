package com.mhm.SpringDataJpa;

import com.mhm.SpringDataJpa.model.Student;
import com.mhm.SpringDataJpa.repository.StudentRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(SpringDataJpaApplication.class, args);

		StudentRepo repo = context.getBean(StudentRepo.class);
		Student s1 = context.getBean(Student.class);
		Student s2 = context.getBean(Student.class);
		Student s3 = context.getBean(Student.class);

		s1.setId(101);
		s1.setName("John");
		s1.setMarks(98);

		s2.setId(102);
		s2.setName("Bob");
		s2.setMarks(97);

		s1.setId(103);
		s1.setName("David");
		s1.setMarks(95);
	}

}
