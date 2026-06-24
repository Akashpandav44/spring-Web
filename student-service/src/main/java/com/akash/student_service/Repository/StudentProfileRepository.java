package com.akash.student_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akash.student_service.Entity.StudentProfile;

@Repository
public interface StudentProfileRepository extends JpaRepository<StudentProfile, Integer> {

}
