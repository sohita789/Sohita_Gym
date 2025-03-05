<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Intermediate Page</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- FontAwesome Icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">

    <style>
        body {
         background-image: url('https://img.freepik.com/premium-photo/young-girl-lifting-weights-gym_156140-2823.jpg');
          background-color: white;
            background-size: cover;
            background-position: center;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
            font-family: 'Arial', sans-serif;
            color: white;
            margin: 0;
            padding-top: 70px; /* Content starts below the navbar */
            background-color: rgba(0, 0, 0, 0.6);
        }

        .content-container {
            text-align: center;
            background-color: rgba(28, 59, 108, 0.9);
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(255, 204, 0, 0.6);
            max-width: 400px;
            margin: auto;
            flex-grow: 1;
        }

        h1 {
            color: #ffcc00;
            font-size: 2.5rem;
            margin-bottom: 20px;
        }

        .content-container p {
            color: white;
            font-size: 1.2rem;
            line-height: 1.6;
        }

        /* Navbar Styling */
        .navbar {
            background-color: pink;
        }

        .navbar-nav .nav-link {
            font-size: 1.1rem;
            color: black !important;
            margin: 0 10px;
        }

        .navbar-nav .nav-link:hover {
            color: #ffcc00 !important;
        }

        .navbar-nav .nav-link .fa {
            margin-right: 8px;
        }
    </style>
</head>

<body>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark fixed-top">
        <div class="container-fluid">
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse justify-content-center" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link active" href="Admin.jsp"><i class="fas fa-search"></i> Admin</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="Enquiry.jsp"><i class="fas fa-search"></i> Enquiry</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="search"><i class="fas fa-users"></i> FollowUp</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="register"><i class="fas fa-user-plus"></i> Registration</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="UpdateRegister.jsp"><i class="fas fa-edit"></i> Update</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="trainerslots.jsp"><i class="fas fa-calendar-alt"></i> TrainersSlot</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="ViewEnquiryDetails.jsp"><i class="fas fa-eye"></i> ViewEnquiryDetails</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="UpdateUserProfile.jsp"><i class="fas fa-eye"></i> UpdateUserProfile</a>
                    </li>

                <!--     <li class="nav-item">
                        <a class="nav-link active" href="UserProfile.jsp"><i class="fas fa-eye"></i> UserProfile</a>
                    </li>

                    <li class="nav-item">
                         <a class="nav-link active" href="noTrainer"><i class="fas fa-eye"> AssignTrainersToUser</i> </a>
                      </li> -->

                         <li class="nav-item">
                          <a class="nav-link active" href="ExerciseAndDiet.jsp"><i class="fas fa-eye"></i>ExerciseAndDiet</a>
                           </li>


                       <li class="nav-item">
                         <a class="nav-link active" href="UpdateExerciseAndDiet"><i class="fas fa-eye"> </i>UpdateUserExerciseAndDiet </a>
                        </li>


<li class="nav-item">
   <a class="nav-link active" href="viewUserExercise"><i class="fas fa-eye"> </i>ViewExerciseAndDiet </a>
                  </li>
                </ul>
            </div>
        </div>
    </nav>

  <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
