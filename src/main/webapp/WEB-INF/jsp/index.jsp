<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>busstation</title>
    <link href="<c:url value="css/app.css" />" rel="stylesheet"
          type="text/css">
</head>
<body class="security-app">
<div class="details">
    <h2>Online Bus Station</h2>
</div>

<div align="center">
    <h1>
        Hello <span style="font-weight: bold;"><c:out value="${pageContext.request.remoteUser}"></c:out></span>
    </h1>

    <form action="${pageContext.request.contextPath}/index/chooseBus" method="post">
        <div class="lc-block">
            <div>
                Выберите дату:<br>
                <input type="date" name="date">
            </div>
            <br>

            <div>
                Выберите направление:<br>
                <select name="routeName">
                    <c:forEach var="route" items="${routes}">
                        <option value="${route.name}">${route.name}
                            [${route.departureTime} - ${route.destinationTime}]
                        </option>
                    </c:forEach>
                </select>
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <div>
                <input type="submit" value="Выбрать" class="button green small">
            </div>

        </div>
    </form>
    <form action="/logout" method="post">
        <input type="submit" class="button red big" value="Sign Out"/> <input
            type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>

</div>
</body>
</html>
