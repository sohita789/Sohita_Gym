<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Form for Gym</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- FontAwesome Icons -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">

    <style>
        /* Body Styling */
        body {
            background-image: url('https://img.freepik.com/premium-photo/young-girl-lifting-weights-gym_156140-2823.jpg');
            background-size: cover;
            background-position: center;
            background-color: #f8f9fa;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            font-family: 'Arial', sans-serif;
        }

        /* Form Container Styling */
        .form-container {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 20px;
            box-shadow: 0 0 15px rgba(1, 1, 1, 0.1);
            max-width: 400px;
            width: 90%;
            margin-top: 50px;
        }

        h1 {
            font-size: 1.8rem;
            font-weight: 600;
            text-align: center;
            color: #333;
            margin-bottom: 30px;
        }

        /* Input Fields Styling */
        .form-label {
            font-weight: 600;
        }

        .form-control {
            border-radius: 8px;
            margin-bottom: 20px;
            padding-left: 40px; /* Space for the icon */
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            transition: border 0.3s ease;
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
    </style>
</head>
<body>

    <!-- Form Container -->
    <div class="form-container">
        <h1>Admin Form</h1>
        <form action="SignIn" method="get" >



            <!-- Email Field with Icon -->
            <div class="mb-3 position-relative">
                <i class="fas fa-envelope input-icon"></i>
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" name="email" id="email" placeholder="Enter your Email" required onchange="onEmail()">
                <span id="displayEmail" class="error-message"></span>
            </div>

            <!-- Password Field with Icon -->
            <div class="mb-3 position-relative">
                <i class="fas fa-lock input-icon"></i>
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" name="password" id="password" placeholder="Enter your Password" required onchange="onPassword()">
                <span id="displayPassword" class="error-message"></span>
            </div>

            <!-- Submit Button -->
            <button type="submit" class="btn btn-success w-100">Login</button>
        </form>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

    <script>

         function onEmail() {
            const email = document.getElementById("email").value;
            document.getElementById("displayEmail").innerText = !email.includes("@") ? "Please enter a valid email" : "";
        }

        function onPassword() {
            const password = document.getElementById("password").value;
            document.getElementById("displayPassword").innerText = password.length < 6 ? "Password must be at least 6 characters" : "";
        }

        function validateForm() {
            // Ensure no error messages before form submission
            return document.querySelectorAll(".error-message").length === 0;
        }
    </script>
</body>
</html>
