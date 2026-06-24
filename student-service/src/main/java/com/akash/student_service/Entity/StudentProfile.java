package com.akash.student_service.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="student_profile")
public class StudentProfile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int profileId;
	
	@Column(name="student_Id")
	private Long studentId;
	
	@Column(name= "father_name")
	private String fatherName;
	
	@Column(name= "mother_name")
	private String motherName;
	
	@Column(name= "address")
	private String address;
	
	@Column(name= "college_name")
	private String collegeName;
	
	@Column(name= "branch")
	private String branch;
	
	@Column(name= "year")
	private String year;
	
	@Column(name= "aadhar_number")
	private String aadharNumber;
	
	@Column(name= "blood_group")
	private String bloodGroup;
	
	@Column(name= "guardian_mobile")
	private String guardianMobile;
	
	public StudentProfile() {
		
	}

	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getGuardianMobile() {
		return guardianMobile;
	}

	public void setGuardianMobile(String guardianMobile) {
		this.guardianMobile = guardianMobile;
	}
	

}
