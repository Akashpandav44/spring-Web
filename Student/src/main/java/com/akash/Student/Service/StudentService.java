package com.akash.Student.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akash.Student.Dto.StudentDto;
import com.akash.Student.Entity.Student;
import com.akash.Student.Repository.StudentRepository;

@Service
public class StudentService implements StudentServiceImpl{

	@Autowired
	private StudentRepository repository;
	
	private StudentDto mapToDto(Student s) {

	    StudentDto dto = new StudentDto();

	    dto.setId(s.getId());
	    dto.setName(s.getName());
	    dto.setEmail(s.getEmail());
	    dto.setDepartment(s.getDepartment());
	    dto.setMobile(s.getMobile());

	    return dto;
	}
	
	private Student mapToEntity(StudentDto dto) {

	    Student s = new Student();  

	    s.setName(dto.getName());
	    s.setEmail(dto.getEmail());
	    s.setDepartment(dto.getDepartment());
	    s.setMobile(dto.getMobile());

	    return s;
	}

	@Override
	public StudentDto createStudent(StudentDto dto) {
		
		Student saved=repository.save(mapToEntity(dto));
		return mapToDto(saved);
	}
}
