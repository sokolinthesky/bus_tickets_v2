<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>busstation</title>
    <link href="<c:url value="css/bootstrap.css" />" rel="stylesheet"
          type="text/css">
    <link href="<c:url value="css/app.css" />" rel="stylesheet"
          type="text/css">
    <link href="<c:url value="css/bootstrap-theme.min.css" />" rel="stylesheet"
          type="text/css">
</head>
<body class="security-app">
<div class="details">
    <h2>Online Bus Station</h2>
    Change language: <a href="index?mylocale=en">English </a> | <a href="index?mylocale=uk">Ukrainian</a><br/><br/>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <a href="/users"><spring:message code="index.users"/></a>
    </sec:authorize>

</div>

<div align="center">
    <h1>
        Hello <span style="font-weight: bold;"><c:out value="${pageContext.request.remoteUser}"></c:out></span>
    </h1>

    <form action="${pageContext.request.contextPath}/index/chooseBus" method="post">
        <div class="lc-block">
            <div>
                <spring:message code="index.chooseDate"/>:<br>
                <input type="date" name="date">
            </div>
            <br>

            <div>
                <spring:message code="index.chooseRoute"/>:<br>
                <select name="routeName">
                    <c:forEach var="route" items="${routes}">
                        <option value="${route.name}">${route.name}
                            [${route.departureTime} - ${route.destinationTime}]
                        </option>
                    </c:forEach>
                </select>
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <spring:message code="index.submit" var="valSubmit"></spring:message>
            <div>
                <input type="submit" value="${valSubmit}" class="button green small">
            </div>

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
