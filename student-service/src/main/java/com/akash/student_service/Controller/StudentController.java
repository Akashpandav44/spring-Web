package com.akash.student_service.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akash.student_service.Dto.StudentDto;
import com.akash.student_service.Entity.Student;
import com.akash.student_service.Service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@PostMapping("/register")
	public ResponseEntity<Student> registerStudent(
	        @RequestBody StudentDto dto) {

	    return ResponseEntity.ok(service.registerStudent(dto));
	}

}
