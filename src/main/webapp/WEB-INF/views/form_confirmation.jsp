<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="header.jsp" %>
<body>
<header class="header--form-page">
    <nav class="container container--70">

        <%@ include file="header_user_profile.jsp" %>

        <ul>
            <%@ include file="header_menu.jsp" %>

            <%@ include file="header_menu_contact.jsp" %>
        </ul>
    </nav>

    <div class="slogan container container--90">
        <h2>
            Dziękujemy za przesłanie formularza Na maila prześlemy wszelkie
            informacje o odbiorze.
        </h2>
    </div>
</header>

<%@ include file="footer.jsp" %>

</body>
</html>