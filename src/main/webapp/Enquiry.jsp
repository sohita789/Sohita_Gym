<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Enquiry Details for Gym</title>

    <!-- Bootstrap and FontAwesome CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">

    <style>
        /* Body Styling */
        body {
            background-image: url('https://healthandfitnesstravel.com/images/Gym20924a_copy.jpg');
            background-size: cover;
            background-position: center;
            height: 100vh;
            margin: 0;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            font-family: 'Arial', sans-serif;
        }

        /* Navbar Styling */
        .navbar-custom {
            background-color: rgba(0, 0, 0, 0.7);
            width: 100%;
            position: absolute;
            top: 0;
            left: 0;
            z-index: 10;
        }

        .navbar-custom .navbar-brand,
        .navbar-custom .nav-link {
            color: white;
        }

        /* Form Container Styling */
        .form-container {
            background-color: rgba(255, 255, 255, 0.9);
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 15px 30px rgba(0, 0, 0, 0.1);
            max-width: 450px;
            width: 100%;
            margin-top: 100px;
        }

        /* Heading Styling */
        h1 {
            margin-bottom: 20px;
            font-size: 1.8rem;
            color: #333;
            text-align: center;
            font-weight: 600;
        }

        /* Input Fields Styling */
        .form-label {
            font-weight: 600;
        }

        .form-control {
            border-radius: 8px;
            margin-bottom: 15px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            transition: border 0.3s ease;
            padding-left: 40px; /* Add space for the icon */
        }

        .form-control:focus {
            border-color: #007bff;
        }

        /* Icon Styling */
        .input-icon {
            position: absolute;
            left: 10px;
            top: 50%;
            transform: translateY(-50%);
            color: #6c757d;
        }

        /* Error Message Styling */
        .error-message {
            color: red;
            font-size: 0.875rem;
            margin-top: 5px;
        }

        /* Button Styling */
        .btn-success {
            width: 100%;
            padding: 12px;
            font-size: 1rem;
            font-weight: bold;
            border-radius: 8px;
            background-color: #28a745;
            border-color: #28a745;
            transition: background-color 0.3s ease, transform 0.3s ease;
        }

        .btn-success:hover {
            background-color: #218838;
            border-color: #1e7e34;
            transform: translateY(-2px);
        }

        /* Responsive Design */
        @media (max-width: 576px) {
            .form-container {
                padding: 20px;
                max-width: 90%;
            }

            h1 {
                font-size: 1.5rem;
            }
        }
    </style>
</head>

<body>

    <!-- Navigation Bar -->
    <nav class="navbar navbar-expand-lg navbar-custom">
        <div class="ms-3"></div>
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Gym</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="index.jsp">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Admin.jsp">Admin</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Enquiry.jsp">Enquiry</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="FollowUp.jsp">FollowUp</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Registration.jsp">Registration</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Form Container -->
    <div class="form-container">
        <h1>Enquiry Form</h1>
        <form action="Enquiry" method="post">

            <c:forEach var="i" items="${error}">
                <span class="error-message">${i.defaultMessage}</span>
            </c:forEach>

            <!-- Name Field with Icon -->
            <div class="mb-3 position-relative">
                <i class="fas fa-user input-icon"></i>
                <label for="name" class="form-label">Name:</label>
                <input type="text" id="name" name="name" class="form-control" placeholder="Enter your name" required onchange="onName()">
                <span id="displayName" class="error-message"></span>
            </div>

            <!-- Age Field with Icon -->
            <div class="mb-3 position-relative">
                <i class="fas fa-birthday-cake input-icon"></i>
                <label for="age" class="form-label">Age</label>
                <input type="number" class="form-control" placeholder="Enter your Age" name="age" id="age" required onchange="onAge()">
                <span id="displayAge" class="error-message"></span>
            </div>

            <!-- Area Field with Icon -->
            <div class="mb-3 position-relative">
                <i class="fas fa-map-marker-alt input-icon"></i>
                <label for="area" class="form-label">Area</label>
                <input type="text" class="form-control" placeholder="Enter the Area" name="area" id="area" required>
            </div>

            <!-- Phone Number Field with Icon -->
            <div class="mb-3 position-relative">
                <i class="fas fa-phone input-icon"></i>
                <label for="phoneNo" class="form-label">Phone No</label>
                <input type="tel" class="form-control" placeholder="Enter your Phone No" name="phoneNo" id="phoneNo" required onchange="onPhoneNo()">
                <span id="displayPhoneNo" class="error-message"></span>
            </div>

            <!-- Distance Field with Icon -->
            <div class="mb-3 position-relative">
                <i class="fas fa-road input-icon"></i>
                <label for="distance" class="form-label">Distance</label>
                <input type="number" class="form-control" placeholder="Enter the Distance" name="distance" id="distance" required>
            </div>

            <button type="submit" class="btn btn-success">Enquiry</button>
        </form>
    </div>

    <!-- JavaScript for Form Validation -->
    <script>
        function onName() {
            var name = document.getElementById('name');
            var nameValue = name.value;

            if (nameValue.trim().length < 4) {
                document.getElementById("displayName").innerHTML = "Name must be at least 4 characters long.";
                return;
            }

            var xhttp = new XMLHttpRequest();
            xhttp.open("GET", "http://localhost:8080/Sohita_Gym/enquire/name/" + nameValue, true);
            xhttp.send();

            xhttp.onload = function() {
                document.getElementById("displayName").innerHTML = this.responseText;
            }
        }

        function onAge() {
            var age = document.getElementById('age');
            var ageValue = age.value;

            if (!ageValue || isNaN(ageValue) || ageValue < 18 || ageValue > 55) {
                document.getElementById("displayAge").innerHTML = "Please enter a valid age between 1 and 120.";
                return;
            }

            var xhttp = new XMLHttpRequest();
            xhttp.open("GET", "http://localhost:8080/Sohita_Gym/enquire/age/" + ageValue, true);
            xhttp.send();

            xhttp.onload = function() {
                document.getElementById("displayAge").innerHTML = this.responseText;
            }
        }

        function onPhoneNo() {
            var phoneNo = document.getElementById('phoneNo');
            var phoneNoValue = phoneNo.value;

            if (phoneNoValue.trim().length !== 10 || (!phoneNoValue.startsWith("6") && !phoneNoValue.startsWith("7") && !phoneNoValue.startsWith("8") && !phoneNoValue.startsWith("9"))) {
                document.getElementById("displayPhoneNo").innerHTML = "Phone number must contain 10 digits and should be valid.";
                return;
            }

            var xhttp = new XMLHttpRequest();
            xhttp.open("GET", "http://localhost:8080/Sohita_Gym/enquire/phoneNo/" + phoneNoValue, true);
            xhttp.send();

            xhttp.onload = function() {
                document.getElementById("displayPhoneNo").innerHTML = this.responseText;
            }
        }
    </script>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>
