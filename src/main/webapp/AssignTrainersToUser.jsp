<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer and Trainer Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
         background-image: url('https://img.freepik.com/premium-photo/young-girl-lifting-weights-gym_156140-2823.jpg');
            background-color: white;
            font-family: Arial, sans-serif;
            color: #333;
            line-height: 1.6;
        }
        .container {
            margin-top: 50px;
            background: skyblue;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }
        h3 {
            color: blue;
            font-weight: italic;
            margin-bottom: 20px;
            text-align: center;
            text-transform: uppercase;
        }
        .table {
            border-radius: 10px;
            overflow: hidden;
            background-color: #fff;
            border-collapse: collapse;
        }
        .table th,
        .table td {
            padding: 15px;
            text-align: center;
            vertical-align: middle;
        }
        .table th {
            background-color: pink;
            color: black;
            text-transform: uppercase;
            font-weight: bold;
            border-bottom: 2px solid #ccc;
        }
        .table tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        .table tr:hover {
            background-color: #e9ecef;
            transition: background-color 0.3s;
        }
        .form-control {
            width: 100%;
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
            box-shadow: inset 0 1px 2px rgba(0, 0, 0, 0.1);
        }
        .btn-primary {
            background-color: red;
            border: none;
            padding: 8px 16px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        .btn-primary:hover {
            background-color: pink;
            transition: background-color 0.3s, transform 0.3s;
            transform: scale(1.05);
        }
        @media (max-width: 768px) {
            .container {
                margin-top: 20px;
                padding: 15px;
            }
            .table th,
            .table td {
                padding: 10px;
            }
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
                        <th>SlotTimings</th>
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
                                    <input type="hidden" name="name" value="${details.name}"><br>

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

                          </td>
                                </form>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
