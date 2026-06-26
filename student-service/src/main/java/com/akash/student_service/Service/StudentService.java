package com.akash.student_service.Service;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.akash.student_service.Dto.HostelApplicationDto;
import com.akash.student_service.Dto.LoginDto;
import com.akash.student_service.Dto.StudentDto;
import com.akash.student_service.Dto.StudentProfileDto;
import com.akash.student_service.Entity.HostelApplication;
import com.akash.student_service.Entity.Student;
import com.akash.student_service.Entity.StudentProfile;
import com.akash.student_service.Exception.StudentNotFoundException;
import com.akash.student_service.Repository.HostelApplicationRepository;
import com.akash.student_service.Repository.StudentProfileRepository;
import com.akash.student_service.Repository.StudentRepository;

@Service
public class StudentService implements StudentServiceImp{

	@Autowired
	private StudentRepository repository;
	
	@Autowired
	private StudentProfileRepository repo;
	
	@Autowired
	private HostelApplicationRepository hostelrepo;

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

	@Override
	public Student getStudentById(Long id) {
		
		return repository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student Not Found"));
	}

	@Override
	public List<Student> getAllStudent() {
		
		return repository.findAll();
	}

	@Override
	public Student updateStudent(Long id, StudentDto dto) {
		
		Student s=repository.findById(id).orElseThrow(() -> 
		new StudentNotFoundException("Student not Found"));
		
		s.setName(dto.getName());
		s.setEmail(dto.getEmail());
		s.setMobile(dto.getMobile());
		s.setPassword(dto.getPassword());
		s.setStatus(dto.getStatus());
		
		return repository.save(s);
	}

	@Override
	public String deleteStudent(Long id) {
		
		Student s=repository.findById(id).orElseThrow(() ->
		new StudentNotFoundException("Student Not Found"));
		
		s.setStatus("INACTIVE");
		repository.save(s);
		
		return "Student Soft Deleted Successfully";
	}

	@Override
	public Student login(LoginDto dto) {
		
		Student s=repository.findByEmailAndPassword(dto.getEmail(),
				dto.getPassword()).orElseThrow(() 
						-> new RuntimeException("invalid Credentials"));
		
		if("INACTIVE".equals(s.getStatus())) {
			throw new RuntimeException("Account is inactive");
		}
		return s;
	}

	@Override
	public StudentProfile create(StudentProfileDto dto) {
		
		StudentProfile sp=new StudentProfile();
		
		sp.setStudentId(dto.getStudentId());
		sp.setFatherName(dto.getFatherName());
		sp.setMotherName(dto.getMotherName());
		sp.setAddress(dto.getAddress());
		sp.setCollegeName(dto.getCollegeName());
		sp.setBranch(dto.getBranch());
		sp.setYear(dto.getYear());
		sp.setAadharNumber(dto.getAadharNumber());
		sp.setBloodGroup(dto.getBloodGroup());
		sp.setGuardianMobile(dto.getGuardianMobile());
		
		return repo.save(sp);
	}

	@Override
	public StudentProfile getById(int id) {
		
		return repo.findById(id).orElseThrow(() ->
		new RuntimeException("Student Profile Information Not Found"));
		
	}

	@Override
	public StudentProfile updateProfile(int id, StudentProfileDto dto) {

	    StudentProfile sp = repo.findById(id)
	            .orElseThrow(() ->
	            new RuntimeException("Student Profile Not Found"));

	    if(dto.getStudentId() != null) {
	        sp.setStudentId(dto.getStudentId());
	    }

	    if(dto.getFatherName() != null) {
	        sp.setFatherName(dto.getFatherName());
	    }

	    if(dto.getMotherName() != null) {
	        sp.setMotherName(dto.getMotherName());
	    }

	    if(dto.getAddress() != null) {
	        sp.setAddress(dto.getAddress());
	    }

	    if(dto.getCollegeName() != null) {
	        sp.setCollegeName(dto.getCollegeName());
	    }

	    if(dto.getBranch() != null) {
	        sp.setBranch(dto.getBranch());
	    }

	    if(dto.getYear() != null) {
	        sp.setYear(dto.getYear());
	    }

	    if(dto.getAadharNumber() != null) {
	        sp.setAadharNumber(dto.getAadharNumber());
	    }

	    if(dto.getBloodGroup() != null) {
	        sp.setBloodGroup(dto.getBloodGroup());
	    }

	    if(dto.getGuardianMobile() != null) {
	        sp.setGuardianMobile(dto.getGuardianMobile());
	    }

	    return repo.save(sp);
	}

	@Override
	public HostelApplication create(HostelApplicationDto dto) {
		
		HostelApplication hp=new HostelApplication();
		
		hp.setApplicationId(dto.getApplicationId());
		hp.setApplicationDate(dto.getApplicationDate());
		hp.setStudentId(dto.getStudentId());
		hp.setApplicationStatus("PENDING");
		
		return hostelrepo.save(hp);
	}

}
