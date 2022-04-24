package com.noah.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.noah.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> students;

	@PostConstruct
	public void localData() {// 當伺服器啟動時只loading一次 適合用來產生本機假資料
		students = new ArrayList<>();
		students.add(new Student("Noah", "Tseng"));
		students.add(new Student("Allan", "Liu"));
	}

	@GetMapping("/students")
	public List<Student> getStudents() {

		return students;
	}

	@GetMapping("/student/{studentId}")
	public Student getStudent(@PathVariable int studentId) {

		if (studentId > students.size() || studentId < 0) {
			throw new StudentNotFoundException("StudentId Not Found - " + studentId);
		}
		return students.get(studentId);
	}

}
