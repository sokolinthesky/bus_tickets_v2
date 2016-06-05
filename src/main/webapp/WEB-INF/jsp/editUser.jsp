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
</div>
<div align="center">
  <form action="/edit" method="post">

    <div class="lc-block">
      <div>
        <a href="/users"><spring:message code="error.back"/></a>
      </div>

        <input type="hidden" name="id" value="${user.userid}"/>

      <div>
        <input type="text" class="style-4" name="username"
               placeholder="User Name" value="${user.userName}"/>
      </div>
      <div>
        <input type="text" class="style-4" name="password"
               placeholder="Password" value="${user.password}"/>
      </div>
      <div>
        <input type="text" class="style-4" name="email"
               placeholder="Email" value="${user.email}"/>
      </div>
      <spring:message code="index.submit" var="valSubmit"></spring:message>
      <div>
        <input type="submit" value="${valSubmit}" class="button green small"/>
      </div>
    </div>
    <form>
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
  </form>
  <form action="/logout" method="post">
    <spring:message code="index.logout" var="valSubmitOut"></spring:message>
    <input type="submit" class="button red big" value="${valSubmitOut}"/> <input
          type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  </form>
</div>
</body>
</html>
