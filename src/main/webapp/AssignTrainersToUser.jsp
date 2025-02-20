<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOC TYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer and Trainer Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            margin-top: 50px;
            background: skyblue;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }
        h3 {
            color: black;
            font-weight: bold;
            margin-bottom: 20px;
            text-align: center;
        }
        .table {
            border-radius: 10px;
            overflow: hidden;
            background-color: #fff;
        }
        .table th {
            background-color: pink;
            color: black;
            text-transform: uppercase;
        }
        .table tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        .table tr:hover {
            background-color: #e9ecef;
            transition: 0.3s;
        }
        .form-control {
            width: 100%;
        }
        .btn-primary {
            background-color: #007bff;
            border: none;
            padding: 8px 16px;
            border-radius: 5px;
        }
        .btn-primary:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h3>Customer and Trainer Details</h3>
        <div class="table-responsive">
            <table class="table table-bordered text-center align-middle">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Phone No</th>
                        <th>Package Type</th>
                        <th>Trainer Name</th>
                        <th>Installment</th>
                        <th>Total Amount</th>
                        <th>Balance</th>
                        <th>Amount Paid</th>
                        <th>Trainer Name</th>
                        <th>Slot Timings</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="details" items="${noTrainerList}">
                        <tr>
                            <td>${details.name}</td>
                            <td>${details.phoneNo}</td>
                            <td>${details.packageType}</td>
                            <td>${details.trainerName}</td>
                            <td>${details.installment}</td>
                            <td>${details.amount}</td>
                            <td>${details.balance}</td>
                            <td>${details.amountPaid}</td>
                            <td>
                                <form method="post" action="assignTrainer">
                                    <input type="hidden" name="name" value="${details.name}">

                                    <select name="trainerName" class="form-control">
                                        <option value="">Select Trainer</option>
                                        <c:forEach var="trainer" items="${TrainerEntityList}">
                                            <option value="${trainer.trainerName}">${trainer.trainerName}</option>
                                        </c:forEach>
                                    </select>
                            </td>
                            <td>
                                    <select name="slotTimings" class="form-control">
                                        <option value="">Select Slot</option>
                                        <c:forEach var="trainer" items="${TrainerEntityList}">
                                            <option value="${trainer.slotTimings}">${trainer.slotTimings}</option>
                                        </c:forEach>
                                    </select>
                            </td>
                            <td>
                                    <button type="submit" class="btn btn-primary">Submit</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
