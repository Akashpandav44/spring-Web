package com.akash.student_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akash.student_service.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
