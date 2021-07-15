<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/15/2021
  Time: 10:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/calculator">

      <h2> Calculator </h2>
      <input type="number" name="numberOne">
      <input type="number" name="numberTwo">
      <div>
          <button type="submit" value="+" name="calculator">Addition</button>
          <button type="submit" value="-" name="calculator">Subtraction</button>
          <button type="submit" value="*" name="calculator">Multiplication</button>
          <button type="submit" value="/" name="calculator">Division</button>
      </div>
      <p>Result : ${result}</p>
  </form>

  </body>
</html>
