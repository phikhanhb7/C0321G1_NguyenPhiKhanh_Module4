<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/16/2021
  Time: 8:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Settings</h2>

<form:form action="/update" method="post" modelAttribute="email">
    <div>
        <h3>Languages :</h3>
        <form:select path="languages">
            <form:option value="English"> English</form:option>
            <form:option value="Vietnamese"> Vietnamese</form:option>
            <form:option value="Japanese"> Japanese</form:option>
            <form:option value="Chinese"> Chinese</form:option>
        </form:select>
    </div>
    <div>
        <h3>Page Size :</h3>
        Show
        <form:select path="size">
            <form:option value="5">5</form:option>
            <form:option value="10">10</form:option>
            <form:option value="15">15</form:option>
            <form:option value="20">20</form:option>
            <form:option value="25">25</form:option>
        </form:select>
        email per page
    </div>
    <div>
        <h3>Spams Filter</h3>
        <form:checkbox path="spam"/> Enable spams filter
    </div>
    <div>
        <h2>Signature</h2>
        <form:textarea path="signature" rows="4"/>
    </div>
    <div style="margin-top: 50px">
        <form:button>Update</form:button>
        <button type="reset">Cancel</button>
    </div>
</form:form>
</body>
</html>
