document.addEventListener("DOMContentLoaded", async() => {
  const employeeId = new URLSearchParams(window.location.search).get("id");

  const fetchEmpData = async(id) => {
    const response = await fetch(`http://localhost:8080/api/emp/${id}`);
    if(!response.ok){
      throw new Error(`Error fetching employee ${id}`);
    }
    return await response.json();
  };

  const populateForm = (employee) => {
      document.getElementById("employeeId").value = employee.id;
      document.getElementById("employeeName").value = employee.name;
      document.getElementById("employeeDepartment").value = employee.department;
      document.getElementById("ecn").value = employee.ecn;
      document.getElementById("phone").value = employee.phone;
      //document.getElementById("hobby").value = employee.hobby;
      document.getElementById("address").value = employee.address;
    }

  const updateEmployee = async(employee) => {
      const response = await fetch(`http://localhost:8080/api/upEmp`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
          body: JSON.stringify(employee)
        });

        if(!response.ok){
          throw new ERROR(`Error updating emp: ${response.status}`);
        }
        return await response.json();
    };

  document.getElementById("updateEmpForm").addEventListener("submit", async (event) => {
    const employee = {
      id: document.getElementById("employeeId").value,
      name: document.getElementById("employeeName").value,
      department: document.getElementById("employeeDepartment").value,
      ecn: document.getElementById("ecn").value,
      phone: document.getElementById("phone").value,
      //hobby: document.getElementById("hobby").value,
      address: document.getElementById("address").value
    };

    try{
      await updateEmployee(employee);
      alert("Employee updated!");
      window.location.href = "index.html";
    } catch(error){
      console.error(error);
      console("error updating employee details");
    }
  });


  try {
    const employee = await fetchEmpData(employeeId);
    populateForm(employee);
  } catch (error){
    console.error(error);
  }
});