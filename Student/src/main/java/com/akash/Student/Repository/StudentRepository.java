package com.akash.Student.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akash.Student.Dto.StudentDto;
import com.akash.Student.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


}
