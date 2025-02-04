<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Follow-Up Page</title>
    <style>
        body {
            background-image: url('https://healthandfitnesstravel.com/images/Gym20924a_copy.jpg');
            font-family: 'Roboto', Arial, sans-serif;
            margin: 0;
            padding: 20px;
            color: #333;
        }

        h1 {
            text-align: center;
            color: #2c3e50;
            font-size: 2em;
            margin-bottom: 20px;
            text-transform: uppercase;
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
            background: rgba(255, 255, 255, 0.8);
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            padding: 20px;
        }

        .search-bar {
            margin-bottom: 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px 0;
            border-bottom: 2px solid #ccc;
        }

        .search-bar label {
            font-size: 1rem;
            font-weight: bold;
            color: #2c3e50;
        }

        .search-bar select {
            padding: 5px 10px;
            font-size: 1rem;
            border: 1px solid #ccc;
            border-radius: 6px;
            background-color: #fff;
            color: #333;
        }

        .search-bar .btn {
            font-size: 0.9rem;
            padding: 8px 15px;
            background-color: #3498db;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .search-bar .btn:hover {
            background-color: #2980b9;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 12px;
            text-align: center;
            border: 1px solid #ccc;
        }

        th {
            background-color: #2c3e50;
            color: white;
            text-transform: uppercase;
            font-size: 0.9rem;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:nth-child(odd) {
            background-color: #e9e9e9;
        }

        tr:hover {
            background-color: #d1e7dd;
        }

        td select, td input {
            padding: 5px;
            font-size: 0.9rem;
            border: 1px solid #ccc;
            border-radius: 5px;
            width: 90%;
            background-color: #fff;
            color: #333;
        }

        td .btn {
            font-size: 0.8rem;
            padding: 5px 10px;
            background-color: #e74c3c;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        td .btn:hover {
            background-color: #c0392b;
        }

        @media (max-width: 768px) {
            table, th, td {
                font-size: 0.8rem;
            }

            .search-bar {
                flex-direction: column;
                align-items: flex-start;
            }

            .search-bar label {
                margin-bottom: 10px;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Follow-Up Records</h1>

        <!-- Search Bar -->
        <div class="search-bar">
            <form action="search" method="get">
                <label for="status">Filter by Status:</label>
                <select name="status" id="status">
                    <option value="">--Select Status--</option>
                    <c:forEach var="status" items="${statusOptions}">
                        <option value="${status}" ${param.status == status ? 'selected' : ''}>
                            ${status}
                        </option>
                    </c:forEach>
                </select>
                <button type="submit" class="btn">Search</button>
            </form>
        </div>

        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Area</th>
                    <th>Distance</th>
                    <th>Phone No</th>
                    <th>Status</th>
                    <th>Reasons</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="enquiry" items="${enquiryList}">
                    <tr>
                        <form action="updateFollowUp" method="post">
                            <td>${enquiry.name}</td>
                            <td>${enquiry.area}</td>
                            <td>${enquiry.distance}</td>
                            <td>${enquiry.phoneNo}</td>
                            <td>
                                <select name="status">
                                    <c:forEach var="status" items="${statusOptions}">
                                        <option value="${status}" ${status == enquiry.status ? 'selected' : ''}>
                                            ${status}
                                        </option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td>
                                <input type="text" name="reasons" value="${enquiry.reasons}" />
                            </td>
                            <td>
                                <input type="hidden" name="name" value="${enquiry.name}" />
                                <button type="submit" class="btn">Update</button>
                                <a href="view?enquiryId=${enquiry.enquiryId}" class="btn"><i class="fas fa-eye"></i> View </a>
                            </td>
                        </form>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <a href="index.jsp" class="btn btn-primary">Home</a>
    <a href="ViewEnquiryDetails.jsp" class="btn btn-primary">ViewEnquiryDetails</a>
</body>
</html>
