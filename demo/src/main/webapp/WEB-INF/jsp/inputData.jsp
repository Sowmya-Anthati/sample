<html>

<head>
<title>First Web Application</title>
</head>

<body>
    <font color="red">${errorMessage}</font>
    <form method="post" action="/inputData">
        Name : <input type="Name" name="name" />
        Email : <input type="Email" name="email" /> 
        PhoneNo : <input type="text" name="phoneNo">
        <input type="submit" />
    </form>
</body>

</html>