let currentPage = 0;
let totalPages = 0;
const pageSize = 2;

async function getPageData(pageNo=0){
	const url = `http://localhost:8080/api/emp/pagination?pageNo=${pageNo}&pageSize=${pageSize}`;
	try{
		const response = await fetch(url);
		if(!response.ok){
			throw new Error(`Response Status : ${response.status}`)
		}
		
		const pageData = await response.json();
		console.log(pageData);
		empTable(pageData.content);
		
		currentPage = pageData.pageable.pageNumber;
		totalPages = pageData.totalPages;
		
		updatePageBtn();
	} catch(error){
		console.error(error.message);
	}
}

function empTable(empData) {
    const table = document.querySelector(".table");

    // Clear existing table body if it exists
    const existingTbody = table.querySelector("tbody");
    if (existingTbody) {
        existingTbody.remove();
    }

    // Create a new tbody
    const tableBody = document.createElement("tbody");

    empData.forEach(emp => {
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
        updateButton.addEventListener('click', () => {
            window.location.href = `updateEmp.html?id=${emp.id}`;
        });

        const deleteButton = document.createElement("button");
        deleteButton.innerText = "Delete";
        deleteButton.classList.add('btn', 'btn-danger');
        deleteButton.addEventListener('click', () => deleteEmp(emp.id, tableRow));

        tdActions.appendChild(updateButton);
        tdActions.appendChild(deleteButton);
        tableRow.appendChild(tdActions);

        tableBody.appendChild(tableRow);
    });

    table.appendChild(tableBody);
}


function updatePageBtn(){
	const prevBtn = document.getElementById("prevBtn");
	const nextBtn = document.getElementById("nextBtn");
	const pageInfo = document.getElementById("pageInfo");
	
	pageInfo.innerText = `Page ${currentPage + 1}`;
	
	prevBtn.disabled = currentPage === 0;
	nextBtn.disabled = currentPage === totalPages-1;
}


document.getElementById("prevBtn").addEventListener("click", () => {
    if (currentPage > 0) {
        getPageData(currentPage - 1);
    }
});

document.getElementById("nextBtn").addEventListener("click", () => {
    if (currentPage < totalPages - 1) {
        getPageData(currentPage + 1);
    }
});

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

getPageData(currentPage);
