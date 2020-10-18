
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome page</title>
    <link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/a81368914c.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
<!-----It is welcome page------>
</head>
<style>
    *{
        padding: 0;
        margin: 0;
        box-sizing: border-box;
    }

    body{
        font-family: 'Poppins', sans-serif;
        overflow: hidden;

    }
    .container{
        width: 100vw;
        height: 100vh;
        align-content: center;
        padding: 0 2rem;
    }
    h3{
        margin: 15px 0;
        color: #333;
        text-transform: uppercase;
        font-size: 2.9rem;
    }
    a{
        display: block;
        text-align: left;
        text-decoration: none;
        color: #999;
        font-size: 0.9rem;
        transition: .3s;
    }

    a:hover{
        color: #38d39f;
    }
    @media screen and (max-width: 1000px){
        h3{
            font-size: 2.4rem;
            margin: 8px 0;
        }

    }

</style>
<body>
<div class="container">
    <h3>Welcome to our online shop!</h3>
    <h5>If you want to see products, please</h5>
    <a href="register.jsp"> Sign up!</a> <h5>or</h5>
    <a href="login.jsp">Sign in!</a>
</div>
</body>
</html>
