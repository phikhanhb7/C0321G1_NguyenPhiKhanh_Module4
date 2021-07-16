<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/15/2021
  Time: 8:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Welcome, Enter The Employee Details</h3>
<form:form modelAttribute="employee" action="create" method="post">
    <p>ID</p>
    <form:input path="id"/>
    <p>Name</p>
    <form:input path="name"></form:input>
    <p>Contact Number</p>
    <form:input path="contactNumber"></form:input>
    <br>
    <input type="submit" value="Submit">
</form:form>
</body>
</html>
