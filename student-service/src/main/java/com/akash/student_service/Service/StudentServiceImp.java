package com.akash.student_service.Service;

import java.util.List;

import com.akash.student_service.Dto.HostelApplicationDto;
import com.akash.student_service.Dto.LoginDto;
import com.akash.student_service.Dto.StudentDto;
import com.akash.student_service.Dto.StudentProfileDto;
import com.akash.student_service.Entity.HostelApplication;
import com.akash.student_service.Entity.Student;
import com.akash.student_service.Entity.StudentProfile;

public interface StudentServiceImp {

	Student registerStudent(StudentDto dto);

	Student getStudentById(Long id);

	List<Student> getAllStudent();

	Student updateStudent(Long id, StudentDto dto);

	String deleteStudent(Long id);

	Student login(LoginDto dto);

	StudentProfile create(StudentProfileDto dto);

	StudentProfile getById(int id);

	StudentProfile updateProfile(int id, StudentProfileDto dto);

	HostelApplication create(HostelApplicationDto dto);

}
