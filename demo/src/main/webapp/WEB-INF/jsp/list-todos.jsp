<html>

<head>
<title>First Web Application</title>
</head>

<body>
    Here are the list of your todos:
    ${todos} 

    <ul>
        <li th:each="todo : ${todos}" th:text="${todo}"></li>
    </ul>
    <BR/>
    Your Name is : ${name}
</body>

</html>