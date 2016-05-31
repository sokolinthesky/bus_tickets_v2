<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        Нет мест.
        <a href="/chooseBus">Назад</a>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    </div>
    <form action="/logout" method="post">
        <input type="submit" class="button red big" value="Sign Out"/> <input
            type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</div>

</body>
</html>