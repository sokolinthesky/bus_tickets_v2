<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>busstation</title>
    <link href="<c:url value="/css/app.css" />" rel="stylesheet"
          type="text/css">
</head>
<body class="security-app">
<div class="details">
    <h2>Online Bus Station</h2>
</div>
<div align="center">
        <div class="lc-block">
            <spring:message code="error.on"/> <strong>${date}</strong> <spring:message code="error.nobuses"/>.
            <a href="/index"><spring:message code="error.back"/></a>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        </div>
    <form action="/logout" method="post">
        <spring:message code="index.logout" var="valSubmitOut"></spring:message>
        <input type="submit" class="button red big" value="${valSubmitOut}"/> <input
            type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</div>

</body>
</html>