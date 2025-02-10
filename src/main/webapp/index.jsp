<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GymWorld</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
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
        }


        .navbar {
            background-color: #004085; /* Dark Blue Color */
            padding: 15px 20px;
            border-bottom: 3px solid #007bff; /* Blue border */
        }

        .navbar-brand {
            color: #fff;
            font-weight: bold;
            font-size: 1.8rem;
            letter-spacing: 2px;
            text-transform: uppercase;
        }

        .navbar-nav .nav-link {
            color: #bbb;
            margin-right: 20px;
            font-weight: 500;
            font-size: 1.1rem;
            transition: color 0.3s ease;
        }

        .navbar-nav .nav-link:hover {
            color: #007bff;
            text-decoration: underline;
        }

        /* Content Container */
        .content-container {
            background-color: rgba(255, 255, 255, 0.8);
            border-radius: 10px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
            padding: 40px;
            max-width: 500px;
            margin: 100px auto;
            text-align: center;
        }


        .content-container h1 {
            font-size: 2.5rem;
            color: #007bff;
            margin-bottom: 30px;
            font-weight: bold;
        }

        .links a {
            display: block;
            padding: 15px;
            margin: 10px 0;
            background-color: #007bff;
            color: #fff;
            border-radius: 5px;
            text-decoration: none;
            font-size: 1.1rem;
            font-weight: 500;
            transition: background-color 0.3s ease, transform 0.3s ease;
        }


            background-color: #0056b3;
            transform: translateY(-5px);
        }

        /* Media Query for Responsiveness */
        @media (max-width: 767px) {
            .content-container {
                padding: 25px;
                max-width: 90%;
            }

            .content-container h1 {
                font-size: 2rem;
            }
        }
    </style>
</head>

      <!-- Main Content -->
    <div class="container content-container">
        <h1>Welcome to GymWorld</h1>
        <div class="links">
            <a href="Admin.jsp">Login</a>
            <a href="UserLogin.jsp">User Login</a>

      </div>
    </div>
</body>

</html>
