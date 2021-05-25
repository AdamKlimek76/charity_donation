<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="header.jsp" %>

<body>
<header>
    <nav class="container container--70">
        <%@ include file="header_log.jsp" %>

        <ul>
            <%@ include file="header_menu.jsp" %>
        </ul>
    </nav>
</header>

<section class="login-page">
    <h2>Załóż konto</h2>
    <form:form autocomplete="off" method="post" action="/register" modelAttribute="user">
        <div class="form-group">
            <form:input path="username" placeholder="nazwa użytkownika"/>
            <form:errors path="username" cssClass="error"/>
        </div>
        <div class="form-group">
            <form:input type="password" path="password" placeholder="podaj hasło"/>
            <form:errors path="password" cssClass="error"/>
        </div>
        <div class="form-group">
            <input type="password" name="password2" placeholder="powtórz hasło"/>
        </div>

        <div class="form-group form-group--buttons">
            <a href="login.html" class="btn btn--without-border">Zaloguj się</a>
            <button class="btn" type="submit">Załóż konto</button>
        </div>
    </form:form>

    <dev><c:out value="${successMessage}"/></dev>
</section>

<%@ include file="footer.jsp" %>

</body>
</html>
