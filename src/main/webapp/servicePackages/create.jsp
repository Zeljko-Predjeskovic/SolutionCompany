<%--
  Created by IntelliJ IDEA.
  User: Zeljko Predjeskovic
  Date: 04.07.2021
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Package</title>
</head>
<body>

    <form action="/ITSolutionCompany_war/packages/create" method="post">

        <input name="serviceName" placeholder="ServiceName"/></p>
        <input name="description" placeholder="Description"/></p>
        <input type="number" name="price" placeholder="Price"/></p>

        <button type="submit">create</button>
    </form>
</body>
</html>
