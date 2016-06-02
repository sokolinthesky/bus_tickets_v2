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
    <form action="${pageContext.request.contextPath}/index/reckoning" method="post">
        <div class="lc-block">
            <spring:message code="buses.choosedDate"/>:<h3> ${date}</h3><br>
            <spring:message code="buses.chooseBus"/>:<br>
            <c:forEach var="bus" items="${buses}">
                <input type="radio" name="busNumber" value="${bus.trainNumber}"><strong>${bus.trainNumber}
                [<spring:message code="buses.seats"/>: ${bus.seats}/40]</strong><br>
            </c:forEach>
            <spring:message code="index.submit" var="valSubmit"></spring:message>
            <input type="submit" value="${valSubmit}" class="button green small">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        </div>
    </form>
    <form action="/logout" method="post">
        <spring:message code="index.logout" var="valSubmitOut"></spring:message>
        <input type="submit" class="button red big" value="${valSubmitOut}"/> <input
            type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</div>

</body>
</html>