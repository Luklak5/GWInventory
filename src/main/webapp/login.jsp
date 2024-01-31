<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>
</head>
<body>
	<div style="text-align: center">
        <h1>Login</h1>
        <form action="login" method="post">
            <label for="username">Username:</label>
            <input name="username" size="30" />
            <br><br>
            <label for="password">Password:</label>
            <input type="password" name="password" size="30" />
            <br>${message}
            <br><br>           
            <button type="submit">Login</button>
        </form>
    </div>
</body>
<script type="text/javascript"> 
    $(document).ready(function() {
        $("#loginForm").validate({
            rules: {
                username: "required",         
                password: "required",
            },            
            messages: {
            	username: "Please enter username",
                password: "Please enter password"
            }
        }); 
    });
</script>
</html>