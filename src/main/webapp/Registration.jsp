<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Form</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <style>
        /* Global Styles */
        body {
            background-image: url(https://img.freepik.com/premium-photo/young-girl-lifting-weights-gym_156140-2823.jpg);
            background-size: center;
            background-position: cover;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 250vh;
            margin: 0;
            font-family: 'Arial', sans-serif;
        }

        .form-container {
            background: rgba(255, 255, 255, 0.9);
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0px 10px 30px rgba(0, 0, 0, 0.2);
            max-width: 500px;
            width: 100%;
            transition: all 0.3s ease;
        }

        .form-container:hover {
            box-shadow: 0px 15px 45px rgba(0, 0, 0, 0.3);
        }

        .form-container h2 {
            text-align: center;
            margin-bottom: 30px;
            color: #333;
            font-size: 28px;
            font-weight: bold;
        }

        .form-group label {
            font-size: 15px;
            color: #444;
        }

        .form-control {
            border-radius: 10px;
            padding: 12px;
            font-size: 14px;
            border: 2px solid #ddd;
            transition: border-color 0.3s ease;
        }

        .form-control:focus {
            border-color: #5cb85c;
            box-shadow: 0 0 5px rgba(92, 184, 92, 0.6);
        }

        .error-message {
            color: red;
            font-size: 12px;
            margin-top: 1px;
        }

        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
            padding: 12px 20px;
            font-size: 16px;
            width: 100%;
            border-radius: 10px;
            margin-top: 20px;
            transition: background-color 0.3s ease;
        }

        .btn-primary:hover {
            background-color: #0056b3;
            border-color: #0056b3;
        }

        .form-group select {
            font-size: 14px;
            padding: 5px;
        }

        .form-group input[type="number"] {
            -moz-appearance: textfield;
            appearance: textfield;
        }

        .form-group input[type="number"]::-webkit-outer-spin-button,
        .form-group input[type="number"]::-webkit-inner-spin-button {
            -webkit-appearance: none;
            margin: 0;
        }
    </style>
</head>






<body>
    <div class="form-container">
        <h2>Registration Form</h2>
        <form action="registers" method="post">
            <div class="form-group">
                <c:forEach var="i" items="${error}">
                    <span style="color: red">${i.defaultMessage}</span>
                </c:forEach>

                      <div class="mb-2">
                       <label for="name" class="form-label"><i class="fas fa-user"></i> Name</label>

                       <select class="form-control" id="name" name="name">
                       <option>--Select--</option>
                           <c:forEach items="${listOfNames}" var="list">
                                <option value="${list.name}">${list.name}</option>
                           </c:forEach>
                       </select>
                    </div>

                <div class="form-group">
                    <label for="age">Age:</label>
                    <input type="number" id="age" name="age" class="form-control" placeholder="Enter your age" required onchange="onAge()">
                    <span id="displayAge" class="error-message"></span>
                </div>

                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" class="form-control" placeholder="Enter your Email" required onchange="onEmail()">
                    <span id="displayEmail" class="error-message"></span>
                </div>

                <div class="form-group">
                                   <label for="phoneNo">Phone No:</label>
                                   <input type="number" id="phoneNo" name="phoneNo" class="form-control" placeholder="Enter your phoneNo" required onchange="onPhoneNo()">
                                   <span id="displayPhoneNo" class="error-message"></span>
                               </div>

                <div class="form-group">
                    <label for="gymName">Gym Name:</label>
                    <input type="text" id="gymName" name="gymName" class="form-control" placeholder="Enter your gymName" onchange="onGymName()" required>
                    <span id="displayGymName" class="error-message"></span>
                </div>

                <div class="form-group">
                    <label for="packageType">Package Type:</label>
                    <select class="form-control" id="Package" name="packageType" required>
                        <option value="" data-amount="0">-- Select Package Type --</option>
                        <option value="Silver" data-amount="5000">Silver - 5000</option>
                        <option value="Gold" data-amount="10000">Gold - 10000</option>
                        <option value="Platinum" data-amount="15000">Platinum - 15000</option>
                        <option value="VIP Elite Package" data-amount="25000">VIP Elite Package -25000</option>
                    </select>
                </div>

                <div class="form-group">
                    <label for="trainerName">Trainer Name:</label>
                    <input type="text" id="trainerName" name="trainerName" class="form-control" placeholder="Enter your trainerName" required onchange="onTrainerName()">
                    <span id="displayTrainerName" class="error-message"></span>
                </div>

                <div class="form-group">
                    <label for="amount">Amount:</label>
                    <input type="number" step="0.01" class="form-control" id="amount" name="amount" readonly required>
                </div>

                <div class="form-group">
                    <label for="amountPaid">Amount Paid:</label>
                    <input type="number" class="form-control" id="amountPaid" name="amountPaid" placeholder="Enter your AmountPaid">
                    <span id="displayAmountPaid" class="error-message"></span>
                </div>

                <div class="form-group">
                    <label for="discount">Discount (%)</label>
                    <input type="number" step="0.01" class="form-control" id="discount" name="discount" min="0" max="100" required>
                </div>

                <div class="form-group">
                    <label for="installment">Installment:</label>
                    <input type="number" class="form-control" id="installment" name="installment" placeholder="Enter your Installment" required onchange="onInstallment()">
                    <span id="displayInstallment" class="error-message"></span>
                </div>

                <div class="form-group">
                    <label for="balance">Balance:</label>
                    <input type="number" class="form-control" id="balance" name="balance" readonly required>
                    <span id="displayBalance" class="error-message"></span>
                </div>

                <button type="submit" class="btn btn-primary">Register</button>
            </div>
        </form>
    </div>

      <script>
            // Handle name selection and fetch phone number
            document.getElementById('name').addEventListener('change', function () {
                const name = this.value; // Get selected name

                if (name && name !== '--Select--') {
                    // Create an AJAX request to get the phone number for the selected name
                    var xhttp = new XMLHttpRequest();
                    xhttp.open("GET", "getPhoneNumberByName?name=" + name, true);
                    xhttp.send();

                    // Handle the response
                    xhttp.onload = function () {
                        if (xhttp.status === 200) {
                            const phoneNumber = xhttp.responseText; // The phone number returned from backend
                            document.getElementById('phoneNo').value = phoneNumber; // Set the phone number in the input
                        } else {
                            console.error("Failed to fetch phone number.");
                        }
                    };
                }
            });
        </script>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

    <script>
        document.getElementById('Package').addEventListener('change', function () {
            const selectedOption = this.options[this.selectedIndex];
            const packageAmount = selectedOption.getAttribute('data-amount');
            document.getElementById('amount').value = packageAmount;
            calculateBalance();
        });

        function calculateBalance() {
            const amount = parseFloat(document.getElementById('amount').value) || 0;
            const discount = parseFloat(document.getElementById('discount').value) || 0;
            const amountPaid = parseFloat(document.getElementById('amountPaid').value) || 0;

            const discountedAmount = amount - (amount * (discount / 100));
            const balance = discountedAmount - amountPaid;
            document.getElementById('balance').value = balance.toFixed(2);
        }

        document.getElementById('discount').addEventListener('input', calculateBalance);
        document.getElementById('amountPaid').addEventListener('input', calculateBalance);
    </script>

    <script>
        var nameValue = "";
        var ageValue = "";
        var emailvalue = "";
        var trainerName = "";
        var phoneNoValue = "";

        function onName() {
            console.log("This is name field");
            var name = document.getElementById('name');
            var nameValue = name.value;

            if (nameValue.trim().length < 4) {
                document.getElementById("displayName").innerHTML = "Name must be at least 4 characters long.";
                return;
            }

            var xhttp = new XMLHttpRequest();
            xhttp.open("GET", "http://localhost:8080/Sohita_Gym/register/name/" + nameValue);
            xhttp.send();

            xhttp.onload = function () {
                document.getElementById("displayName").innerHTML = this.responseText;
            }
        }

        function onAge() {
            var age = document.getElementById('age');
            var ageValue = age.value;

            if (!ageValue || isNaN(ageValue) || ageValue < 18 || ageValue > 55) {
                document.getElementById("displayAge").innerHTML = "Please enter a valid age between 1 and 120.";
                return;
            }

            var xhttp = new XMLHttpRequest();
            xhttp.open("GET", "http://localhost:8080/Sohita_Gym/register/age/" + ageValue, true);
            xhttp.send();

            xhttp.onload = function () {
                document.getElementById("displayAge").innerHTML = this.responseText;
            }
        }

        function onEmail() {
            var email = document.getElementById('email');
            var emailValue = email.value;  // Corrected typo

            if (!emailValue.includes('@gmail.com') &&
                !emailValue.includes('@yahoo.com') &&
                !emailValue.includes('@outlook.com') &&
                !emailValue.includes('@hotmail.com') &&
                !emailValue.includes('.edu') &&
                !emailValue.includes('.org') &&
                !emailValue.includes('.info') &&
                !emailValue.includes('.net')) {
                document.getElementById("displayEmail").innerHTML = "Enter a valid email address.";
                return;
            }

            var xhttp = new XMLHttpRequest();
            xhttp.open("GET", "http://localhost:8080/Sohita_Gym/register/email/" + emailValue, true);  // Corrected typo
            xhttp.send();

            xhttp.onload = function () {
                document.getElementById("displayEmail").innerHTML = this.responseText;
            }
        }

        function onTrainerName() {
            var trainerName = document.getElementById('trainerName');
            var trainerNameValue = name.value;

            if (trainerNameValue.trim().length < 4) {
                document.getElementById("displayTrainerName").innerHTML = "trainerName  must be at least 4 characters long.";
                return;
            }

            var xhttp = new XMLHttpRequest();
            xhttp.open("GET", "http://localhost:8080/Sohita_Gym/register/trainerName/" + trainerNameValue, true);
            xhttp.send();

            xhttp.onload = function () {
                document.getElementById("displayTrainerName").innerHTML = this.responseText;
            }
        }

        function onPhoneNo() {
            var phoneNo = document.getElementById('phoneNo');
            phoneNoValue = phoneNo.value;

            if (phoneNoValue.trim().length !== 10 || (!phoneNoValue.startsWith("6") && !phoneNoValue.startsWith("7") && !phoneNoValue.startsWith("8") && !phoneNoValue.startsWith("9"))) {
                document.getElementById("displayPhoneNo").innerHTML = "Phone number must contain 10 digits and should be valid.";
                return;
            }

            var xhttp = new XMLHttpRequest();
            xhttp.open("GET", "http://localhost:8080/Sohita_Gym/register/phoneNo/" + phoneNoValue, true);
            xhttp.send();

            xhttp.onload = function () {
                document.getElementById("displayPhoneNo").innerHTML = this.responseText;
            }
        }
    </script>
</body>

</html>
