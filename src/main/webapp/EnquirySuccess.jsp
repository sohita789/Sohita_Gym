<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Logged In Successfully</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Body Styling */
        body {
            background-image: url('https://healthandfitnesstravel.com/images/Gym20924a_copy.jpg');
            background-size: cover;
            background-position: center;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 50vh;
            margin: 0;
            font-family: 'Arial', sans-serif;
        }

        /* Content Container Styling */
        .content-container {
            background-color: rgba(255, 255, 255, 0.85);
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 15px 30px rgba(0, 0, 0, 0.1);
            text-align: center;
            max-width: 400px;
            width: 100%;
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }

        /* Hover Effect for the Content Container */
        .content-container:hover {
            transform: translateY(-5px);
            box-shadow: 0 20px 40px rgba(0, 0, 0, 0.15);
        }

        /* Heading Style */
        h1 {
            margin-bottom: 40px;
            color: purple
            font-size: 2rem;
            font-weight: 650;
            text-transform: uppercase;
        }

        /* Button Styling */
        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
            padding: 12px 30px;
            font-size: 1rem;
            font-weight: 650;
            border-radius: 8px;
            transition: background-color 0.3s ease, transform 0.3s ease;
        }

        /* Button Hover Effect */
        .btn-primary:hover {
            background-color: #0056b3;
            border-color: #004085;
            transform: translateY(-2px);
        }

        /* Link Styling */
        a {
            text-decoration: none;
            color: #007bff;
            font-weight: bold;
        }

        /* Responsive Styling */
        @media (max-width: 576px) {
            .content-container {
                padding: 20px;
                max-width: 90%;
            }

            h1 {
                font-size: 1.5rem;
            }
        }

    </style>
</head>

<body>

    <div class="content-container">
        <h1> Details Enquired Successfully</h1>
        <a href="FollowUp.jsp" class="btn btn-primary">Home</a>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
