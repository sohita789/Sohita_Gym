<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GymWorld</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <style>
        /* Global Body Styling */
        body {
            background-image: url('https://healthandfitnesstravel.com/images/Gym20924a_copy.jpg');
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            height: 100vh;
            margin: 0;
            font-family: 'Arial', sans-serif;
            color: #fff;
        }

        /* Navbar Customization */
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

        /* Heading */
        .content-container h1 {
            font-size: 2.5rem;
            color: #007bff;
            margin-bottom: 30px;
            font-weight: bold;
        }

        /* Links Styling */
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

        .links a:hover {
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

<body>

    <!-- Navigation Bar -->
    <nav class="navbar navbar-expand-lg navbar-light">
        <a class="navbar-brand" href="#">GymWorld</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="Admin.jsp">Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Enquiry.jsp">Enquiry</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="FollowUp.jsp">FollowUp</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="search">Search</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Registration.jsp">Registration</a>
                </li>
            </ul>
        </div>
    </nav>

    <!-- Main Content -->
    <div class="container content-container">
        <h1>Welcome to GymWorld</h1>
        <div class="links">
            <a href="Admin.jsp">Login</a>
            <a href="UserLogin.jsp">User Login</a>
        </div>
    </div>

    <!-- Scripts -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</body>

</html>
