async function getData(){
	const url = "http://localhost:8080/api/emp";
	try{
		const response = await fetch(url);
		if(!response.ok){
			throw new Error(`Response Status : ${response.status}`);
		}
		
		const empData = await response.json();
		console.log(empData);
		empTable(empData);
	}	catch(error){
		console.error(error.message);
	}
}

function empTable (empData){
	const tableBody = document.createElement("tbody");
	const table = document.querySelector(".table");
	
	empData.forEach(emp => 
	{
		const tableRow = document.createElement("tr");
		
		const tdId = document.createElement("td");
		tdId.innerText = emp.id;
		tableRow.appendChild(tdId);
		
		const tdName = document.createElement("td");
		tdName.innerText = emp.name;
		tableRow.appendChild(tdName);
		
		const tdDept = document.createElement("td");
		tdDept.innerText = emp.department;
		tableRow.appendChild(tdDept);
		
		const tdEcn = document.createElement("td");
		tdEcn.innerText = emp.ecn;
		tableRow.appendChild(tdEcn);
		
		const tdPhone = document.createElement("td");
		tdPhone.innerText = emp.phone;
		tableRow.appendChild(tdPhone);
		
		const tdHobby = document.createElement("td");
		tdHobby.innerText = emp.hobbies;
		tableRow.appendChild(tdHobby);
		
		const tdAdd = document.createElement("td");
		tdAdd.innerText = emp.address;
		tableRow.appendChild(tdAdd);	
		
		const tdActions = document.createElement("td");
		
		const updateButton = document.createElement("button");
		updateButton.innerText = "Update";
		updateButton.classList.add('btn', 'btn-primary');
		updateButton.addEventListener('click', ()=> {window.location.href=`updateEmp.html?id=${emp.id}`});
		
		const deleteButton = document.createElement("button");
		deleteButton.innerText = "Delete";
		deleteButton.classList.add('btn', 'btn-danger');
		deleteButton.addEventListener('click', ()=> deleteEmp(emp.id, tableRow));
		
		tdActions.appendChild(updateButton);
		tdActions.appendChild(deleteButton);
		tableRow.appendChild(tdActions);
		tableBody.appendChild(tableRow);
	})
	
	table.appendChild(tableBody);
	
}

async function deleteEmp(id, tableRow){
	const url = "http://localhost:8080/api/delEmp/"+id;
	
	try{
		const response = await fetch(url, {
			method: "DELETE",
		});
		if(!response.ok){
			throw new Error(`Failed to delete employee ${id}`);
		}
		tableRow.remove();
		
		console.log("EmpId ${id} deleted successfully")
	}catch(error){
		console.error(error.message);
		
	}
}

getData();
