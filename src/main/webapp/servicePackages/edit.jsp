<%@ page import="org.predjeskovic.solutionCompany.service.ServicePackagesDto" %>
<%--Created by IntelliJ IDEA.
  User: Zeljko Predjeskovic
  Date: 02.07.2021
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<%  ServicePackagesDto s = (ServicePackagesDto) request.getAttribute("package");  %>
<p>--------------Service--------------</p>
<%=s.getServiceName()%><p/>
<%=s.getDescription()%><p/>
<%=s.getPrice()%><p/>

</body>
</html>
