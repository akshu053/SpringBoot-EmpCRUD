document.addEventListener("DOMContentLoaded", function(){
	const addEmpForm = document.querySelector("form");
	
	const createEmployee = () =>{
		return {
			 //id: document.getElementById("employeeId").value,
			 name: document.getElementById("employeeName").value,
			 department: document.getElementById("employeeDepartment").value,
			 ecn: document.getElementById("ecn").value,
			 phone: document.getElementById("phone").value,
			 gender: document.querySelector('input[name = "gender"]:checked').value,
			 hobbies: document.getElementById("hobby").value.split(",").map(hobby=>hobby.trim()),
			 address: document.getElementById("address").value	
	};
};

//const employee ={
//		"id" : employeeId,
//		"name" : employeeName,
//		"department": employeeDepartment,
//		"ecn": ecn,
//		"phone": phone,
//		"gender": gender,
//		"hobbies": hobby,
//		"address": address
//}

const addNewEmp = async(employee) => {
	try{
		const response = await fetch("http://localhost:8080/api/addEmp", {
			method: "POST",
			headers: {
				"Content-type": "application/json; charset=UTF-8"
			},
			body: JSON.stringify(employee)
		});
		if(!response.ok){
			throw new Error(`Failed to add emp`)
		}
		const result = await response.json();
		console.log("Emp added successfully");
		alert("Employee added successfully");
		addEmpForm.reset();
	}catch(error){
		console.error(error);
	}
};

addEmpForm.addEventListener("submit", function(event){
	event.preventDefault();
	
	const employee = createEmployee();
	addNewEmp(employee);
});
});

	window.onload=function(){

	       let submitBtn = document.querySelector("#submitBtn");

	              console.log(submitBtn);

	              submitBtn.addEventListener("click", () => {

	                     console.log("before calling function");

	                     //addNewEmployee();

	                     //console.log("func call completed");

	              });

	}

