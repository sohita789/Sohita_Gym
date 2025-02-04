<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Registration Form</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <style>
        body {
            background-image: url(https://img.freepik.com/premium-photo/young-girl-lifting-weights-gym_156140-2823.jpg);
            background-size: container;
            background-position: center;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 190vh;
            margin: 0;
        }
        .form-container {
            background: rgba(255, 255, 255, 0.8);
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1);
            max-width: 400px;
            width: 80%;
        }
        .form-container h2 {
            margin-bottom: 40px;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Update Registration Form</h2>
        <form action="updateRegistration" method="post">
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" class="form-control" id="name" name="name">
            </div>

            <div class="form-group">
                <label for="phoneNo">Phone No:</label>
                <input type="number" class="form-control" id="phoneNo" name="phoneNo">
            </div>

            <div class="form-group">
                <label for="packageType">Package Type:</label>
                <select class="form-control" id="Package" name="packageType" required>
                    <option value="" data-amount="0">-- Select Package Type --</option>
                    <option value="Silver" data-amount="5000">Silver - 5000</option>
                    <option value="Gold" data-amount="10000">Gold - 10000</option>
                    <option value="Platinum" data-amount="15000">Platinum - 15000</option>
                </select>
            </div>
            <div class="form-group">
                <label for="trainerName">Trainer Name:</label>
                <input type="text" class="form-control" id="trainerName" name="trainerName" >
            </div>
            <div class="form-group">
                <label for="amount">Amount:</label>
                <input type="number" step="0.01" class="form-control" id="amount" name="amount" readonly required>
            </div>

            <div class="form-group">
                <label for="balance">Balance:</label>
                <input type="number" class="form-control" id="balance" name="balance"  required>
            </div>
            <button type="submit" class="btn btn-primary">Update</button>
        </form>
    </div>

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
</body>
</html>
