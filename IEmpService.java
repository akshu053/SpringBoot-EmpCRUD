package com.indusind.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.indusind.employee.entity.Employee;

public interface IEmpService {
	
	public List<Employee> getAllEmp();
	public Optional<Employee> getEmpById(Integer id);
	public Employee addEmp(Employee emp);
	public Employee upEmp(Employee emp);
	public void deleteEmp(Integer id);
	Page<Employee> getPaginationEmp(int pageNo, int pageSize);

}
