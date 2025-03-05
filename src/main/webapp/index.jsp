<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GymWorld</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-image: url('https://img.freepik.com/premium-photo/young-girl-lifting-weights-gym_156140-2823.jpg');
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            height: 100vh;
            margin: 0;
            font-family: 'Arial', sans-serif;
            color: #fff;
            position: relative;
        }
        /* Overlay to enhance readability */
        .overlay {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: rgba(0, 0, 0, 0.6);
        }
        .navbar {
            background-color: rgba(0, 64, 133, 0.9);
            padding: 15px 20px;
            border-bottom: 3px solid #007bff;
        }
        .navbar-brand {
            color: #fff;
            font-weight: bold;
            font-size: 1.8rem;
            letter-spacing: 2px;
            text-transform: uppercase;
        }
        .navbar-nav .nav-link {
            color: #fff;
            font-weight: 500;
            font-size: 1.1rem;
            transition: color 0.3s ease;
        }
        .navbar-nav .nav-link:hover {
            color: #f8d210;
            text-decoration: underline;
        }
        .content-container {
            background-color: rgba(255, 255, 255, 0.9);
            border-radius: 10px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.3);
            padding: 40px;
            max-width: 450px;
            margin: 120px auto;
            text-align: center;
            position: relative;
            z-index: 1;
        }
        .content-container h1 {
            font-size: 2.2rem;
            color: #004085;
            font-weight: bold;
            margin-bottom: 25px;
        }
        .links a {
            display: block;
            padding: 12px;
            margin: 10px 0;
            background-color: #007bff;
            color: #fff;
            border-radius: 5px;
            text-decoration: none;
            font-size: 1.1rem;
            font-weight: 500;
            transition: background-color 0.3s ease, transform 0.3s ease;
        }
        .links a:hover {
            background-color: #0056b3;
            transform: translateY(-3px);
        }
        @media (max-width: 767px) {
            .content-container {
                padding: 30px;
                max-width: 90%;
            }
            .content-container h1 {
                font-size: 1.8rem;
            }
        }
    </style>
</head>
<body>

    <div class="container content-container">
        <h1>Welcome to GymWorld</h1>
        <div class="links">
            <a href="Admin.jsp">Admin Login</a>
            <a href="UserLogin.jsp">User Login</a>
            <a href="ExerciseAndDiet.jsp"> ExerciseAndDiet</a>

        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
