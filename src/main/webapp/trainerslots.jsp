<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trainer & Slot Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
         background-image: url('https://healthandfitnesstravel.com/images/Gym20924a_copy.jpg');
         background-color: lightblue;
         font-family: 'Arial', sans-serif;
          padding-top: 70px; }
        .navbar {
         background-color: pink; }
        .navbar-brand,
        .nav-link {
        color: #fff !important; }
        .container {
        margin-top: 25px;
        }
        .card {
         border: none;
          box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
          margin-bottom: 50px; }
        .card-header {
         background-color: pink;
         color: black;
         font-weight: bold;
         }
        .btn-primary:hover {
        background-color: pink;
        }
        .btn-success:hover {
         background-color: #218838;
         }
        .table th,
        .table td {
        vertical-align: middle;
         text-align: center;
          }
        .modal-content {
         border-radius: 10px;
          }
        .form-control {
         border-radius: 5px;
          }
        .modal-footer {
        display: flex;
        justify-content: space-between;
         }
    </style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark fixed-top">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Trainer Management</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">

                <li class="nav-item">
                    <a class="nav-link" href="#addSlotsModal" data-bs-toggle="modal">Add Slots</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#addTrainerModal" data-bs-toggle="modal">Add Trainer</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container" id="trainerList">
    <div class="card">
        <div class="card-header d-flex justify-content-between align-items-center">
            <h5>Trainer List</h5>
            <div>
                <button class="btn btn-success me-2" data-bs-toggle="modal" data-bs-target="#addSlotsModal">Add Slots</button>
                <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addTrainerModal">Add Trainer</button>
            </div>
        </div>

        <div class="card-body">
            <c:if test="${not empty successMessage}">
                <div class="alert alert-success">${successMessage}</div>
            </c:if>
            <c:if test="${not empty errorMessage}">
                <div class="alert alert-danger">${errorMessage}</div>
            </c:if>

            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Phone Number</th>
                        <th>Slot Timings</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="trainer" items="${trainerInfoList}">
                        <tr>
                            <td>${trainer.name}</td>
                            <td>${trainer.phoneNumber}</td>
                            <td>${trainer.slotTimings}</td>
                            <td>
                                <a href="deleteSlot?id=${trainer.id}" class="btn btn-sm btn-danger" onClick="deleteTrainer('${trainer.id}')" ><i class="fas fa-eye"></li> Delete </a>
                                </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Add Trainer Modal -->
    <div class="modal fade" id="addTrainerModal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Add Trainer</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>
                <div class="modal-body">
                    <form id="addTrainerForm" action="trainerAddact" method="post">
                        <div class="mb-3">
                            <label for="name" class="form-label">Trainer Name:</label>
                            <input type="text" id="name" class="form-control" name="Name" placeholder="Trainer Name" required>
                        </div>

                       <div class="mb-3">
                            <label for="phoneNumber" class="form-label">Phone Number:</label>
                            <input type="text" id="phoneNumber" class="form-control" name="phoneNumber" placeholder="Phone Number" required>
                        </div>

                        <div class="mb-3">
                            <label for="slotTimings" class="form-label">Select Slot Timing:</label>
                            <select id="slotTimings" class="form-select" name="slotTimings" required>
                                <option value="">-- Select Slot --</option>
                                <c:forEach var="slot" items="${slots}">
                                    <option value="${slot.startTimings} - ${slot.endTimings}">${slot.startTimings} - ${slot.endTimings}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="modal-footer">
                            <button type="submit" class="btn btn-primary">Save</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Add Slots Modal -->
    <div class="modal fade" id="addSlotsModal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Add Slot</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>
                <div class="modal-body">
                    <form id="addSlotsForm" action="AddSlotact" method="get">
                        <div class="mb-3">
                            <label for="startTimings" class="form-label">Start Time:</label>
                            <input type="time" id="startTimings" class="form-control" name="startTimings" required oninput="calculateDuration()">
                        </div>

                        <div class="mb-3">
                            <label for="endTimings" class="form-label">End Time:</label>
                            <input type="time" id="endTimings" class="form-control" name="endTimings" required oninput="calculateDuration()">
                        </div>

                        <div class="mb-3">
                            <label for="duration" class="form-label">Duration:</label>
                            <input type="text" id="duration" class="form-control" name="duration" readonly placeholder="Auto-calculated">
                        </div>

                        <div class="modal-footer">
                            <button type="submit" class="btn btn-success">Save Slot</button>
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    function deleteTrainer(id) {
        if (confirm("Are you sure?")) {
            window.location.href = "trainersSlots?id=" + id;
        }
    }

    function calculateDuration() {
        let start = document.getElementById("startTimings").value;
        let end = document.getElementById("endTimings").value;


        if (start && end) {
            let startTime = new Date("1970-01-01T" + start);
            let endTime = new Date("1970-01-01T" + end);

            let diff = (endTime - startTime) / (1000 * 60);

            if (diff > 0) {
                let hours = Math.floor(diff / 60);
                let minutes = diff % 60;
                document.getElementById("duration").value = hours + " hr " + minutes + " min";
            } else {
                document.getElementById("duration").value = "Invalid Time";
                }
                }
                }
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
