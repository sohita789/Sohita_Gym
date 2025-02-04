<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Page</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: white;
            margin: 30px;
        }

        h2 {
            text-align: center;
            color: #2c3e50;
            margin-bottom: 30px;
        }

        table {
            width: 100%;
            margin-top: 40px;
        }

        th, td {
            text-align: center;
            vertical-align: middle;
        }

        tr:hover {
            background-color: #e9ecef;
        }

        .thead-dark th {
            background-color: #6c757d;
            color: #fff;
        }

        @media (max-width: 768px) {
            table {
                font-size: 18px;
            }
        }

        .navbar {
            margin-bottom: 30px;
            background-color: #2c3e50;
        }

        .navbar-brand, .nav-link {
            color: #f8f9fa !important;
        }

        .nav-link:hover {
            color: #adb5bd !important;
        }
    </style>
</head>
<body>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark">
        <a class="navbar-brand" href="#">SOHITA_GYM</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Enquiry.jsp">Enquiry</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="FollowUp.jsp">FollowUp</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Registration.jsp">Registration</a>
                </li>
            </ul>
        </div>
    </nav>

    <h2>View Enquiry Details</h2>
    <table class="table table-bordered table-hover">
        <thead class="thead-dark">
            <tr>
                <th>Name</th>
                <th>Area</th>
                <th>Phone No</th>
                <th>Reasons</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${enquiryList}" var="item">
                <tr>
                    <td>${item.name}</td>
                    <td>${item.area}</td>
                    <td>${item.phoneNo}</td>
                    <td>${item.reasons}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
