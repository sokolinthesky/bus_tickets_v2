<%@tag pageEncoding="UTF-8"%>
<%@tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ attribute name="user" required="true" type="ua.busstation.core.user.User" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<tr>
    <td align="center">${user.userName}</td>
    <td align="center">${user.password}</td>
    <td align="center">${user.email}</td>
    <td align="center"><a href="/edit${user.userName}"><spring:message code="users.edit"/></a></td>
    <td align="center"><a href="/remove${user.userid}"><spring:message code="users.delete"/></a></td>
</tr>

