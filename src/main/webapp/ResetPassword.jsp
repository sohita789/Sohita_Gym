<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reset Password</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome for icons -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <style>
        body {
         background-image: url(https://img.freepik.com/premium-photo/young-girl-lifting-weights-gym_156140-2823.jpg);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f8f9fa;
            font-family: Arial, sans-serif;
        }
        .container {
            max-width: 400px;
            background: white;
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }
        .btn-primary {
            background-color: #007bff;
            border: none;
        }
        .btn-primary:hover {
            background-color: #0056b3;
        }
        .input-group-text {
            background-color: #f0f2f5;
            border-right: 1px solid #dcdde1;
        }
        .form-control {
            border-radius: 10px;
            font-size: 16px;
            padding: 10px;
        }
        .form-control:focus {
            border-color: #007bff;
            box-shadow: 0 0 0 0.2rem rgba(38, 143, 255, 0.25);
        }
        .form-label {
            font-weight: bold;
            margin-bottom: 8px;
        }
    </style>
</head>
<body>
<c:set var="userName" value="${userName}" />
    <div class="container">
        <h2 class="text-center mb-4">Reset Password</h2>
        <form action="resetPassword" method="post">
            <input type="text" name="name" value="${userName}">

            <div class="mb-3">
                <label for="oldPassword" class="form-label">Old Password</label>
                <div class="input-group">
                    <span class="input-group-text"><i class="fas fa-lock"></i></span>
                    <input type="password" name="oldPassword" id="oldPassword" class="form-control" placeholder="Enter your old password" required>
                </div>
            </div>
            <div class="mb-3">
                <label for="newPassword" class="form-label">New Password</label>
                <div class="input-group">
                    <span class="input-group-text"><i class="fas fa-key"></i></span>
                    <input type="password" name="newPassword" id="newPassword" class="form-control" placeholder="Enter your new password" required>
                </div>
            </div>
            <div class="mb-3">
                <label for="confirmPassword" class="form-label">Confirm Password</label>
                <div class="input-group">
                    <span class="input-group-text"><i class="fas fa-check"></i></span>
                    <input type="password" name="confirmPassword" id="confirmPassword" class="form-control" placeholder="Confirm your new password" required>
                </div>
            </div>
            <button type="submit" class="btn btn-primary w-100">Update Password</button>
        </form>
    </div>
</body>
</html>
