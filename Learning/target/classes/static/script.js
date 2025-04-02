let studentsData = [];

document.addEventListener('DOMContentLoaded', fetchStudents);

function fetchStudents() {
  fetch('http://localhost:8080/students')
    .then(response => response.json())
    .then(data => {
      studentsData = data;
      renderStudentTable(data);
    })
    .catch(error => alert('Error loading students: ' + error.message));
}

function renderStudentTable(students) {
  const table = document.getElementById("studentTable");
  table.innerHTML = '';

  students.forEach(student => {
    const row = table.insertRow();
    row.innerHTML = `
      <td>${student.rollNo}</td>
      <td><span class="view">${student.name}</span><input class="edit" type="text" value="${student.name}" style="display:none;"></td>
      <td><span class="view">${student.age}</span><input class="edit" type="number" value="${student.age}" style="display:none;"></td>
      <td><span class="view">${student.email}</span><input class="edit" type="email" value="${student.email}" style="display:none;"></td>
      <td><span class="view">${student.percentage}</span><input class="edit" type="number" value="${student.percentage}" style="display:none;"></td>
      <td><span class="view">${student.branch}</span><input class="edit" type="text" value="${student.branch}" style="display:none;"></td>
      <td>
        <button class="edit-btn" onclick="toggleEdit(this, ${student.rollNo})">Edit</button>
        <button class="save-btn" onclick="saveEdit(this, ${student.rollNo})" style="display:none;">Save</button>
        <button onclick="deleteStudent(${student.rollNo})" class="btn btn-danger">Delete</button>
      </td>
    `;
  });
}

function openAddRow() {
  const table = document.getElementById("studentTable");
  const row = table.insertRow(0);
  row.innerHTML = `
    <td>New</td>
    <td><input type="text" id="addName"></td>
    <td><input type="number" id="addAge"></td>
    <td><input type="email" id="addEmail"></td>
    <td><input type="number" id="addPercentage"></td>
    <td><input type="text" id="addBranch"></td>
    <td>
      <button onclick="addStudent()" class="btn">Save</button>
      <button onclick="fetchStudents()" class="btn btn-danger">Cancel</button>
    </td>
  `;
}

function addStudent() {
  const student = {
    name: document.getElementById('addName').value.trim(),
    age: parseInt(document.getElementById('addAge').value),
    email: document.getElementById('addEmail').value.trim(),
    percentage: parseFloat(document.getElementById('addPercentage').value),
    branch: document.getElementById('addBranch').value.trim()
  };

  fetch('http://localhost:8080/students', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(student)
  })
  .then(() => {
    fetchStudents();
  });
}

function toggleEdit(button, id) {
  const row = button.closest("tr");
  row.querySelectorAll(".view").forEach(el => el.style.display = "none");
  row.querySelectorAll(".edit").forEach(el => el.style.display = "inline-block");
  button.style.display = "none";
  row.querySelector(".save-btn").style.display = "inline-block";
}

function saveEdit(button, id) {
  const row = button.closest("tr");
  const student = {
    name: row.querySelector("input[type=text]").value,
    age: row.querySelector("input[type=number]").value,
    email: row.querySelector("input[type=email]").value,
    percentage: row.querySelectorAll("input[type=number]")[1].value,
    branch: row.querySelectorAll("input[type=text]")[1].value
  };

  fetch(`http://localhost:8080/students/${id}`, {
    method: 'PUT',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(student)
  })
  .then(() => {
    fetchStudents();
  });
}

function deleteStudent(id) {
  fetch(`http://localhost:8080/students/${id}`, { method: 'DELETE' })
    .then(() => fetchStudents());
}