//package com.indusind.employee.service;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Iterator;
//import java.util.List;
//
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.indusind.employee.entity.Employee;
//@Service
//public class EmpService {
//	
//	public List<Employee> empList;
//	
//	public EmpService(){
//		empList = new ArrayList<>();
//		Employee emp1 = new Employee(1,"Akshata","IT", 802,"98765", "F",new ArrayList<>(Arrays.asList("Reading", "Cooking")),"/images","Powai");
//		Employee emp2 = new Employee(2,"Tushar","IT", 801, "98764","M",new ArrayList<>(Arrays.asList("Reading", "Cooking")),"/images", "NaviMumabi");
//		Employee emp3 = new Employee(3,"Abhinay","IT", 806, "98763","M",new ArrayList<>(Arrays.asList("Reading", "Cooking")),"/images","NaviMumbai");
//		Employee emp4 = new Employee(4,"Mihir","IT", 910, "987632","M",new ArrayList<>(Arrays.asList("Reading", "Cooking")),"/images", "Andheri");
//		Employee emp5 = new Employee(6,"Dev","Data", 805, "98725","M",new ArrayList<>(Arrays.asList("Reading", "Cooking")),"/images", "Malad");
//		
//		empList.addAll(Arrays.asList(emp1,emp2,emp3,emp4,emp5));
//	}
//	
//	public List<Employee> getAllEmp(){
//		return empList;
//	}
//
//	
//	public Employee getEmpById(Integer id) {
//		for(Employee e:empList) {
//			if(id == e.getId()) {
//				return e;
//			}
//		}
//		return null;
//	}
//	
//	public Employee addEmp(Employee emp) {
//		empList.add(emp);
//		return emp;
//	}
//	
//	public Employee upEmp(Employee emp) {
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
//	}
//
//	public void deleteEmp(Integer id) {
//		Iterator<Employee> it = empList.iterator();
//		while(it.hasNext()) {
//			Employee emp = (Employee) it.next();
//			if(emp.getId()==id) {
//				it.remove();
//			}
//		}
//		
//	}
//	
////	public String uploadSingleImage(String path, MultipartFile file) throws IOException {
////		String name = file.getOriginalFilename();
////		
////		String filePath = path + File.separator + name;
////		
////		File f = new File(path);
////		if(!f.exists()) {
////			f.mkdir();
////		}
////		
////		Files.copy(file.getInputStream(), Paths.get(filePath));
////		
////		return name;
////	}
//
//}
