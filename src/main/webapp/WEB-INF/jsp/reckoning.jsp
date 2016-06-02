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
        <h1><spring:message code="reckoning.ticket"/>:</h1>
        <strong><spring:message code="reckoning.busnumber"/>:</strong> ${reckoning.bus.trainNumber}<br>
        <strong><spring:message code="reckoning.route"/>:</strong> ${reckoning.route.name}<br>
        <strong><spring:message code="reckoning.date"/>:</strong> ${reckoning.bus.date}<br>
        <strong><spring:message code="reckoning.dept"/>:</strong> ${reckoning.route.departureTime}<br>
        <strong><spring:message code="reckoning.dest"/>:</strong> ${reckoning.route.destinationTime}<br>
        <strong><spring:message code="reckoning.seat"/>:</strong> ${reckoning.bus.seats + 1}<br>
        <strong><spring:message code="reckoning.price"/>:</strong> ${reckoning.route.price}
    </div>
    <form action="/logout" method="post">
        <spring:message code="index.logout" var="valSubmitOut"></spring:message>
        <input type="submit" class="button red big" value="${valSubmitOut}"/> <input
            type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</div>
</body>
</html>