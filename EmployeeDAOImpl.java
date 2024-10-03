package com.indusind.employee.dao;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.indusind.employee.entity.Employee;
import com.indusind.employee.repository.EmployeeRepository;

@Component
public class EmployeeDAOImpl implements EmployeeDAO {
	
public List<Employee> empList;
	
	@Autowired
	EmployeeRepository empRepo;
	
//	public EmployeeDAOImpl(){
//		empList = new ArrayList<>();
//		Employee emp1 = new Employee(1,"Akshata","IT", 802,"98765", "F",new ArrayList<>(Arrays.asList("Reading", "Cooking")),"/images","Powai");
//		Employee emp2 = new Employee(2,"Tushar","IT", 801, "98764","M",new ArrayList<>(Arrays.asList("Reading", "Cooking")),"/images", "NaviMumabi");
//		Employee emp3 = new Employee(3,"Abhinay","IT", 806, "98763","M",new ArrayList<>(Arrays.asList("Reading", "Cooking")),"/images","NaviMumbai");
//		Employee emp4 = new Employee(4,"Mihir","IT", 910, "987632","M",new ArrayList<>(Arrays.asList("Reading", "Cooking")),"/images", "Andheri");
//		Employee emp5 = new Employee(6,"Dev","Data", 805, "98725","M",new ArrayList<>(Arrays.asList("Reading", "Cooking")),"/images", "Malad");
//		
//		empList.addAll(Arrays.asList(emp1,emp2,emp3,emp4,emp5));
//	}
	
	@Override
	public List<Employee> getAllEmp(){
		//return empList;
		return empRepo.findAll();
	}

	@Override
	public Optional<Employee> getEmpById(Integer id) {
//		for(Employee e:empList) {
//			if(id == e.getId()) {
//				return e;
//			}
//		}
//		return null;
		return empRepo.findById(id);
	}
	
	@Override
	public Employee addEmp(Employee emp) {
//		empList.add(emp);
//		return emp;
		return empRepo.save(emp);
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
		
		return empRepo.save(emp);
	}
	
	@Override
	public void deleteEmp(Integer id) {
//		Iterator<Employee> it = empList.iterator();
//		while(it.hasNext()) {
//			Employee emp = (Employee) it.next();
//			if(emp.getId()==id) {
//				it.remove();
//			}
//		}
		empRepo.deleteById(id);
		
	}
	
	@Override
	public Page<Employee> getPaginationEmp(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo,  pageSize);
		return empRepo.findAll(pageable);
	}
	


}
