package com.akash.student_service.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.akash.student_service.Dto.StudentProfileDto;
import com.akash.student_service.Entity.StudentProfile;
import com.akash.student_service.Service.StudentService;

@RestController
@RequestMapping("/api/profile")
public class StudentProfileController {
	
	@Autowired
	private StudentService service;
	
	@PostMapping("/create")
	public ResponseEntity<?> save(@RequestBody StudentProfileDto dto) {
		
		StudentProfile sp=service.create(dto);
		
		if(sp.getProfileId() !=0) {
			return new ResponseEntity<>("Student Information save "+sp, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>("Student Information Not save "+sp, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable int id){
		 
		StudentProfile sp=service.getById(id);
		
		if(sp.getProfileId() !=0) {
			return new ResponseEntity<>(sp, HttpStatus.FOUND);
		}else {
			return new ResponseEntity<>("Unable to Find "+sp, HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable int id, @RequestBody StudentProfileDto dto){
		
		StudentProfile sp=service.updateProfile(id, dto);
		
		if(sp.getProfileId() !=0) {
			return new ResponseEntity<>("Information Update "+sp, HttpStatus.OK); 
		}else {
			return new ResponseEntity<>("Information Not Update "+sp, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
