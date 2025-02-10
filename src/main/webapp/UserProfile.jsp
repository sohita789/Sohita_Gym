<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile Page</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
         background-image: url(https://img.freepik.com/premium-photo/young-girl-lifting-weights-gym_156140-2823.jpg);
             justify-content: center;
            display: flex;
            align-items: center;
            height: 100vh;
            margin: 0;
            font-family: Arial, sans-serif;
        }
        .content {
            padding: 15px; /* Reduced padding */
            background: white;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
            text-align: center;
            margin: 10px; /* Reduced margin */
        }
        .profile-header {
            font-size: 28px; /* Slightly reduced font size */
            font-weight: bold;
            margin-bottom: 15px; /* Reduced margin-bottom */
        }
        .profile-image {
            width: 100px; /* Slightly reduced size */
            height: 100px; /* Slightly reduced size */
            border-radius: 50%;
            border: 3px solid #6a11cb;
            object-fit: cover;
            margin: 0 auto 5px; /* Reduced margin-bottom */
        }
        .upload-btn {
            display: block;
            margin: 5px auto; /* Reduced margin */
            cursor: pointer;
            color: white;
            background: #007bff;
            padding: 6px 10px; /* Reduced padding */
            border-radius: 5px;
            border: none;
        }
        .profile-table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 10px; /* Reduced margin-top */
        }
        .profile-table th, .profile-table td {
            border: 1px solid #ddd;
            padding: 8px; /* Reduced padding */
            text-align: left;
        }
        .profile-table th {
            background: #f8f8f8;
        }
        .btn {
            background: #dc3545;
            color: white;
            padding: 8px 12px; /* Reduced padding */
            border: none;
            cursor: pointer;
            margin-top: 10px; /* Reduced margin-top */
            border-radius: 5px;
            transition: background 0.3s ease;
        }
        .btn:hover {
            background: #c82333;
        }
    </style>
</head>
<body>
    <div class="content">
        <div class="profile-header">My Profile</div>

        <!-- Profile Image Upload -->
        <form action="update" method="get">
            <div class="profile-card">
                <img src="download?filePath=${filePath}" alt="profile picture" class="profile-image">
                <h2>${register.name}</h2>
            </div>
        </form>

        <table class="profile-table table table-striped">
            <tr>
                <th>Full Name</th>
                <td>${register.name}</td>
            </tr>
            <tr>
                <th>Email</th>
                <td>${register.email}</td>
            </tr>
            <tr>
                <th>Age</th>
                <td>${register.age}</td>
            </tr>
            <tr>
                <th>Contact Number</th>
                <td>${register.phoneNo}</td>
            </tr>
            <tr>
                <th>Gym Name</th>
                <td>${register.gymName}</td>
            </tr>
            <tr>
                <th>Package Type</th>
                <td>${register.packageType}</td>
            </tr>
            <tr>
                <th>Trainer Name</th>
                <td>${register.trainerName}</td>
            </tr>
            <tr>
                <th>Total Amount</th>
                <td>${register.amount}</td>
            </tr>
            <tr>
                <th>Discount</th>
                <td>${register.discount}</td>
            </tr>
            <tr>
                <th>Amount Paid</th>
                <td>${register.amountPaid}</td>
            </tr>
            <tr>
                <th>Balance Amount</th>
                <td>${register.balance}</td>
            </tr>
        </table>
        <a href="update?id=${register.id}"><button class="btn">Update Profile</button></a>
    </div>

</body>
</html>
