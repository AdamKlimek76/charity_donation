<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<li><a href="${pageContext.request.contextPath}/" class="btn btn--without-border active">Start</a></li>
<li><a href="#" class="btn btn--without-border">O co chodzi?</a></li>
<li><a href="#" class="btn btn--without-border">O nas</a></li>
<sec:authorize access="hasRole('ADMIN')">
<li><a href="${pageContext.request.contextPath}/institution/add" class="btn btn--without-border">Fundacje i organizacje</a></li>
</sec:authorize>
    <li><a href="${pageContext.request.contextPath}/donation/add" class="btn btn--without-border">Przekaż
    dary</a></li>
<li><a href="#" class="btn btn--without-border">Kontakt</a></li>