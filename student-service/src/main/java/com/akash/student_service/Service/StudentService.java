package com.akash.student_service.Service;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akash.student_service.Dto.StudentDto;
import com.akash.student_service.Entity.Student;
import com.akash.student_service.Repository.StudentRepository;

@Service
public class StudentService implements StudentServiceImp{

	@Autowired
	private StudentRepository repository;

	@Override
	public Student registerStudent(StudentDto dto) {
		
		Student s= new Student();
		
		s.setName(dto.getName());
		s.setEmail(dto.getEmail());
		s.setMobile(dto.getMobile());
		s.setPassword(dto.getPassword());
		
		s.setStatus("PENDING");
		
		return repository.save(s);
	}

}
