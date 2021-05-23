<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<ul class="nav--actions">
    <li class="logged-user">
        <sec:authorize access="isAuthenticated()">
            <p>Witaj: <sec:authentication property="principal.username"/></p>
        </sec:authorize>
        <ul class="dropdown">
            <li><a href="#">Profil</a></li>
            <li><a href="#">Moje zbiórki</a></li>
            <li>
                <sec:authorize access="isAuthenticated()">
                    <form action="<c:url value="/logout"/>" method="post">
                        <input class="link " type="submit" value="Wyloguj">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                </sec:authorize>
            </li>
        </ul>
    </li>
</ul>
