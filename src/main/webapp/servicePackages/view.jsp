<%@ page import="org.predjeskovic.solutionCompany.service.ServicePackagesService" %>
<%@ page import="org.predjeskovic.solutionCompany.model.ServicePackages" %>
<%@ page import="org.predjeskovic.solutionCompany.service.ServicePackagesDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Zeljko Predjeskovic
  Date: 30.06.2021
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Service Packages</title>
</head>
<body>

<c:forEach items="${packages}" var="item">
    ${item}<p>
</c:forEach>


</body>
</html>
