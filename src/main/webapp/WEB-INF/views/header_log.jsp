<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<ul class="nav--actions">
    <li><a href="${pageContext.request.contextPath}/login">Zaloguj</a></li>
    <li class="highlighted"><a href="${pageContext.request.contextPath}/register">Załóż konto</a></li>
</ul>