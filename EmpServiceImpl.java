package com.indusind.employee.service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.indusind.employee.dao.EmployeeDAOImpl;
import com.indusind.employee.entity.Employee;

@Service
public class EmpServiceImpl implements IEmpService{
	
	@Autowired
	EmployeeDAOImpl employeeDAO;
	
	
	@Override
	public List<Employee> getAllEmp(){
		return employeeDAO.getAllEmp();
	}

	@Override
	public Optional<Employee> getEmpById(Integer id) {
		return employeeDAO.getEmpById(id);
	}
	
	@Override
	public Employee addEmp(Employee emp) {
		return employeeDAO.addEmp(emp);
	}
	
	@Override
	public Employee upEmp(Employee emp) {
//		Employee e1 = null;
//		for(Employee e: empList) {
//			if(e.getId()==emp.getId()) {
//				e1 = e;
//				break;
//			}
//		}
//		if(e1==null) {
//			return null;
//		}
//		
//		e1.setName(emp.getName());
//		e1.setDepartment(emp.getDepartment());
//		e1.setEcn(emp.getEcn());
//		
//		return e1;
		return employeeDAO.upEmp(emp);
	}
	
	@Override
	public void deleteEmp(Integer id) {
		employeeDAO.deleteEmp(id);
	}

	public Page<Employee> getEmpPagination(Integer pageNo, Integer pageSize) {
		return employeeDAO.getEmpPagination(pageNo, pageSize);
		
	}

}
