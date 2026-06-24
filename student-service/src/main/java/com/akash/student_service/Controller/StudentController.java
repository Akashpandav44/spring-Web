package com.akash.student_service.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akash.student_service.Dto.LoginDto;
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
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id){
		
		return ResponseEntity.ok(service.getStudentById(id));
	}
	@GetMapping("/all")
	public ResponseEntity<List<Student>> getAllStudent(){
		
		return ResponseEntity.ok(service.getAllStudent());
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id,
			@RequestBody StudentDto dto) {
		
		return ResponseEntity.ok(service.updateStudent(id, dto));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Long id){
		
		return ResponseEntity.ok(service.deleteStudent(id));
	}
	@PostMapping("/login")
	public ResponseEntity<Student> login(@RequestBody LoginDto dto) {
		
		return ResponseEntity.ok(service.login(dto));
	}

}
