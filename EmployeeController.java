package com.indusind.employee.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.indusind.employee.entity.Employee;

import com.indusind.employee.service.EmpServiceImpl;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmpServiceImpl empService;
	
	@GetMapping("/emp/pagination")
	public Page<Employee> getPaginationEmp(@RequestParam(defaultValue="0") int pageNo, @RequestParam(defaultValue="2") int pageSize){
		return empService.getPaginationEmp(pageNo, pageSize);
	}
	
	
	@GetMapping("/emp")
	public List<Employee> getAllEmp() {
		return empService.getAllEmp();
	}
	
	@GetMapping("/emp/{id}")
		public Optional<Employee> getEmpById(@PathVariable Integer id) {
			return empService.getEmpById(id);
		}
	
	//add new emp
	@PostMapping("/addEmp")
	public Employee addEmp(@RequestBody Employee emp) {
		return empService.addEmp(emp);
	}

	//update emp
	@PostMapping("/upEmp")
	public Employee upEmp(@RequestBody Employee emp) {
		return empService.upEmp(emp);
	}
	
	@DeleteMapping("/delEmp/{id}")
	public void deleteEmp(@PathVariable Integer id) {
		empService.deleteEmp(id);
	}
	
//	@PostMapping("/uploadSingleImage")
//	public String uploadSingleImage(@RequestParam("image") MultipartFile img) {
//		try {
//			return empService.uploadSingleImage("images/", img);
//		} catch (IOException e) {
//			e.printStackTrace();
//			return "Something went wrong while uploading image";
//		}
//	}
}
