<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
    <link href="<c:url value="css/app.css" />" rel="stylesheet"
          type="text/css">
    <title>busstation</title>
</head>
<body class="security-app">
<div class="details">
    <h2>Online Bus Station</h2>
</div>
<div align="center">

    <div class="lc-block">
        <div>
            <a href="/index"><spring:message code="error.back"/></a>
        </div>

        <table border="1">
            <tr>
                <th><spring:message code="users.name"/></th>
                <th><spring:message code="users.password"/></th>
                <th><spring:message code="users.email"/></th>
            </tr>

            <c:forEach var="user" items="${users}">
                <tags:user user="${user}"/>
            </c:forEach>
        </table>

        <form>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </div>
    <form action="/logout" method="post">
        <spring:message code="index.logout" var="valSubmitOut"></spring:message>
        <input type="submit" class="button red big" value="${valSubmitOut}"/> <input
            type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</div>
</body>
</html>
