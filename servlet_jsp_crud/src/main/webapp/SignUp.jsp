<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign up</title>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background: #ffffff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 300px;
        }
        h1 {
            text-align: center;
            font-size: 1.5em;
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input[type="text"],
        input[type="number"],
        input[type="tel"],
        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        button {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 5px;
            background-color: #007BFF;
            color: white;
            font-size: 1em;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Sign Up</h1>
        <form action="SignUp">
            <label for="name">Name:</label>
            <input type="text" id="name" placeholder="Enter your Name" name="name" required>
            
            <label for="age">Age:</label>
            <input type="number" id="age" placeholder="Enter your Age" name="age" required>
            
            <label for="address">Address:</label>
            <input type="text" id="address" placeholder="Enter your Address" name="address" required>
            
            <label for="phone">Phone:</label>
            <input type="tel" id="phone" placeholder="Enter your Phone" name="phone" required>
            
            <label for="email">Email:</label>
            <input type="email" id="email" placeholder="Enter your Email" name="email" required>
            
            <label for="password">Password:</label>
            <input type="password" id="password" placeholder="Enter your Password" name="password" required>
            
            <button type="submit">Sign Up</button>
        </form>
    </div>
</body>
</html>