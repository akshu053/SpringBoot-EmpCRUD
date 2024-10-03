package com.indusind.employee.dao;

import java.util.List;
import java.util.Optional;

//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.indusind.employee.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> getAllEmp();
	public Optional<Employee> getEmpById(Integer id);
	public Employee addEmp(Employee emp);
	public Employee upEmp(Employee emp);
	public void deleteEmp(Integer id);

}
