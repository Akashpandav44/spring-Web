package com.akash.Student.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akash.Student.Dto.StudentDto;
import com.akash.Student.Entity.Student;
import com.akash.Student.Service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@PostMapping("/create")
	public StudentDto create (@RequestBody StudentDto dto) {
		return service.createStudent(dto);
	}

}
