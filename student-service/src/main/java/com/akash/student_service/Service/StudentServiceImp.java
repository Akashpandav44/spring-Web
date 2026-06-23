package com.akash.student_service.Service;

import com.akash.student_service.Dto.StudentDto;
import com.akash.student_service.Entity.Student;

public interface StudentServiceImp {

	Student registerStudent(StudentDto dto);

}
