<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Login Form</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-KyZXEJZ4K4sJ6R6F6F06z4f7RslkKXf79AZNoo47AN7lrQgz1Zp45hfY+V75f7Fc"
        crossorigin="anonymous">
    <!-- Font Awesome for icons -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">

    <style>
        /* Background Image */
        body {
            background-image: url('https://healthandfitnesstravel.com/images/Gym20924a_copy.jpg');
            background-size: cover;
            background-position: center;
            font-family: Arial, sans-serif;
             display: flex;
             justify-content: center;
              align-items: center;
              margin: 10;

      }

        .login-container {
            max-width: 400px;
            margin: 100px auto;
            padding: 50px;
            background-color: rgba(255, 255, 255, 0.8);
            border-radius: 15px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
        }

        .login-container h1 {
            text-align: center;
            margin-bottom: 30px;
            font-size: 28px;
            font-weight: bold;
            color: #333;
        }

        .form-label {
            font-weight: bold;
            font-size: 14px;
        }

        .input-group-text {
            background-color: #f0f2f5;
            border-right: 1px solid #dcdde1;
        }

        .form-control {
            border-radius: 10px;
            font-size: 16px;
            padding: 12px;
        }

        .form-control:focus {
            border-color: #007bff;
            box-shadow: 0 0 0 0.25rem rgba(38, 143, 255, 0.5);
        }

        .btn-custom {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 12px;
            font-size: 16px;
            border-radius: 8px;
            width: 100%;
            transition: background-color 0.3s ease;
        }

        .btn-custom:hover {
            background-color: #0056b3;
            cursor: pointer;
        }

        .mb-3 {
            margin-bottom: 15px;
        }

        .text-center {
            text-align: center;
        }

        .form-control-icon {
            position: absolute;
            top: 14px;
            left: 12px;
            color: #007bff;
        }

        .input-group {
            position: relative;
        }

        .forgot-password {
            font-size: 14px;
            color: #007bff;
            text-decoration: none;
        }

        .forgot-password:hover {
            text-decoration: underline;
        }
    </style>
</head>

<body>

    <div class="login-container">
        <h1>User Login</h1>
        <form action="user" method="post">

            <!-- Email field with icon -->
            <div class="mb-3">
                <div class="input-group">
                    <span class="input-group-text"><i class="fas fa-envelope"></i></span>
                    <input type="email" class="form-control" id="email" name="email" placeholder="Enter your email address" required>
                </div>
            </div>

            <!-- Password field with icon -->
            <div class="mb-3">
                <div class="input-group">
                    <span class="input-group-text"><i class="fas fa-lock"></i></span>
                    <input type="password" class="form-control" id="password" name="password" placeholder="Enter your password"
                        required>
                </div>
            </div>

            <!-- Login button -->
            <div class="d-grid gap-2 mb-3">
                <button type="submit" class="btn btn-custom">Login</button>
            </div>

            <!-- Forgot password link -->
            <div class="text-center">
                <a href="#" class="forgot-password">Forgot password?</a>
            </div>
        </form>
    </div>
  </body>
</html>
