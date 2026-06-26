package com.akash.student_service.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akash.student_service.Dto.HostelApplicationDto;
import com.akash.student_service.Entity.HostelApplication;
import com.akash.student_service.Service.StudentService;

@RestController
@RequestMapping("api/application")
public class HostelApplicationController {
	
	@Autowired
	private StudentService service;
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody HostelApplicationDto dto){
		
		HostelApplication hp=service.create(dto);
		
		if(hp.getId() !=0) {
			return new ResponseEntity<>("Application submitted "+hp, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>("Application Not Submitted "+hp, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
