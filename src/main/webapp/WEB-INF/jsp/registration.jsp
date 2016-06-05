<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    Change language: <a href="regPage?mylocale=en">English </a> | <a href="regPage?mylocale=uk">Ukrainian</a><br/><br/>
</div>
<div align="center">
    <form action="/registration" method="post">

        <div class="lc-block">
            <div>
                <a href="/login"><spring:message code="error.back"/></a>
            </div>
            <div>
                <input type="text" class="style-4" name="username"
                       placeholder="User Name"/>
            </div>
            <div>
                <input type="password" class="style-4" name="password"
                       placeholder="Password"/>
            </div>
            <div>
                <input type="text" class="style-4" name="email"
                       placeholder="Email"/>
            </div>
            <spring:message code="login.regsubmit" var="valSubmit"></spring:message>
            <div>
                <input type="submit" value="${valSubmit}" class="button red small"/>
            </div>
            <c:if test="${param.error ne null}">
                <div class="alert-danger">Invalid username and password.</div>
            </c:if>
            <c:if test="${param.logout ne null}">
                <div class="alert-normal">You have been logged out.</div>
            </c:if>
        </div>
        <form>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </form>
</div>
</body>
</html>
