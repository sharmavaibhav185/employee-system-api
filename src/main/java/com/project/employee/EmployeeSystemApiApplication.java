package com.project.employee;

import com.project.employee.entity.EmployeeEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class EmployeeSystemApiApplication {

	public static void main(String[] args) {
//		HashSet<EmployeeEntity> hs = new HashSet<>();
//
		EmployeeEntity em1 = new EmployeeEntity();
		em1.setFirstName("Vaibhav1");
		em1.setLastName("Sharma");
		em1.setEmailId("abx@gmail.com");

		EmployeeEntity em2 = new EmployeeEntity();
		em2.setFirstName("Vaibhav");
		em2.setLastName("Sharma");
		em2.setEmailId("abx@gmail.com");

		EmployeeEntity em3 = new EmployeeEntity();
		em3.setFirstName("Vaibhav");
		em3.setLastName("Sharma");
		em3.setEmailId("abx@gmail.com");
//
//		hs.add(em1);
//		hs.add(em2);
//		hs.add(em3);
//
//		System.out.println(hs.size());

		List<EmployeeEntity> list = new ArrayList<>();
		list.add(em1);
		list.add(em2);
		list.add(em3);

		Map<String, Long> collect = list.stream().collect(Collectors.groupingBy(EmployeeEntity::getFirstName, Collectors.counting()));
		System.out.println(collect);

//		SpringApplication.run(EmployeeSystemApiApplication.class, args);
	}



}
