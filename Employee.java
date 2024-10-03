package com.indusind.employee.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="EmpTable")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
    private String name;
    private String department;
    private int ecn;
    private String phone;
    private String gender;
    private ArrayList<String> hobbies;
    //private MultipartFile profileImage;
    private String profileImagePath;
    private String address;
    
    
    public Employee() {}

	public Employee(int id, String name, String department, int ecn, String phone, String gender, ArrayList<String> hobbies, String profileImagePath,
			 String address) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.ecn = ecn;
		this.phone = phone;
		this.gender = gender;
		this.hobbies = hobbies;
		//this.profileImage = profileImage;
		this.profileImagePath = profileImagePath;
		this.address = address;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getEcn() {
		return ecn;
	}

	public void setEcn(int ecn) {
		this.ecn = ecn;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public ArrayList<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(ArrayList<String> hobbies) {
		this.hobbies = hobbies;
	}

//	public MultipartFile getProfileImage() {
//		return profileImage;
//	}
//
//	public void setProfileImage(MultipartFile profileImage) {
//		this.profileImage = profileImage;
//	}

	public String getProfileImagePath() {
		return profileImagePath;
	}

	public void setProfileImagePath(String profileImagePath) {
		this.profileImagePath = profileImagePath;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department + ", ecn=" + ecn + ", phone="
				+ phone + ", gender=" + gender + ", hobbies=" + hobbies
				+ ", profileImagePath=" + profileImagePath + ", address=" + address + "]";
	}
	
}
