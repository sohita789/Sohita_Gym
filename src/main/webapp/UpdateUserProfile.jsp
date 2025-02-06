<%@ page isELIgnored = "false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>User Update Profile</title>
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <style>
    body {
      background-color: #f8f9fa;
      font-family: Arial, sans-serif;
    }

    .container {
      max-width: 500px;
      margin-top: 50px;
    }

    .form-group label {
      font-weight: bold;
    }

    .form-control {
      border-radius: 0;
    }

    .btn-primary {
      border-radius: 0;
      background-color: #007bff;
      border-color: #007bff;
    }

    .btn-primary:hover {
      background-color: #0056b3;
      border-color: #004085;
    }
  </style>
</head>

<body>
  <div class="container">
    <h2 class="text-center">User Update Profile</h2>
    <form action="updateUserProfile" method="post" enctype="multipart/form-data">
      <div class="form-group">
        <label for="name">Name</label>
        <input type="text" class="form-control" id="name" name="name" placeholder="Enter your name" value="${register.name}">
      </div>
      <div class="form-group">
        <label for="age">Age</label>
        <input type="number" class="form-control" id="age" name="age" placeholder="Enter your age">
      </div>
      <div class="form-group">
        <label for="height">Height (cm)</label>
        <input type="number" class="form-control" id="height" name="height" placeholder="Enter your height">
      </div>
      <div class="form-group">
        <label for="weight">Weight (kg)</label>
        <input type="number" class="form-control" id="weight" name="weight" placeholder="Enter your weight">
      </div>
      <div class="form-group">
        <label for="picture">Upload Your Picture</label>
        <input type="file" class="form-control-file" id="picture" name="picture">
      </div>
      <button type="submit" class="btn btn-primary btn-block">Update Changes</button>
    </form>
  </div>

  <!-- Bootstrap JS and dependencies -->
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>
