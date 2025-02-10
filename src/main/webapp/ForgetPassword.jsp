<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Forget Password</title>
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <!-- Font Awesome for icons -->
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
  <style>
    body {
background-image: url(https://img.freepik.com/premium-photo/young-girl-lifting-weights-gym_156140-2823.jpg);
      height: 100vh;
      display: flex;
      justify-content: center;
      align-items: center;
    }
    .card {
      width: 400px;
      padding: 20px;
      border-radius: 15px;
      box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    }
    .btn-primary {
      background-color: #2575fc;
      border: none;
    }
    .btn-primary:hover {
      background-color: #6a11cb;
    }
    .input-group-text {
      background-color: #f0f2f5;
      border-right: 1px solid #dcdde1;
    }
    .form-control {
      border-radius: 10px;
      font-size: 16px;
    }
    .form-control:focus {
      border-color: #2575fc;
      box-shadow: 0 0 0 0.2rem rgba(38, 143, 255, 0.25);
    }
  </style>
</head>
<body>
  <div class="card bg-white">
    <h3 class="text-center mb-4">Forget Password</h3>
    <form action="forgetPassword" method="post">
      <div class="mb-3">
        <label for="email" class="form-label">Email Address</label>
        <div class="input-group">
          <span class="input-group-text"><i class="fas fa-envelope"></i></span>
          <input type="email" class="form-control" name="email" id="email" placeholder="Enter your email address" required>
        </div>
      </div>
      <div class="mb-3">
        <label for="newPassword" class="form-label">New Password</label>
        <div class="input-group">
          <span class="input-group-text"><i class="fas fa-lock"></i></span>
          <input type="password" class="form-control" name="newPassword" id="newPassword" placeholder="Enter your new password" required>
        </div>
      </div>
      <div class="mb-3">
        <label for="confirmPassword" class="form-label">Confirm Password</label>
        <div class="input-group">
          <span class="input-group-text"><i class="fas fa-lock"></i></span>
          <input type="password" class="form-control" name="confirmPassword" id="confirmPassword" placeholder="Confirm your password" required>
        </div>
      </div>
      <button type="submit" class="btn btn-primary w-100">Reset Password</button>
    </form>
  </div>

</body>
</html>
