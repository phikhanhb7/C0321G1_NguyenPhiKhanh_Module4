<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/14/2021
  Time: 10:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="abc" method="post">

     <h3>
         Input money need to change
     </h3>
    <input type="number" name="a" placeholder="Money need to change">

    <h3>
        Money
    </h3>
    <select name="b">
        <option value="23000">VND</option>
        <option value="1">USD</option>
    </select>

    <h3>
        To Money
    </h3>
    <select name="c">
        <option value="1">USD</option>
        <option value="23000">VND</option>
    </select>
    <hr>
    <input type="submit" value="Convert">

    <h3>
        Result
    </h3>
    <input type="text" name="result" readonly value="${result}">













</form>


</body>
</html>
