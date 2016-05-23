<%@ tag description="Template Tag" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<!doctype>
<html>
<head>
    <link href="<c:url value="/resources/c/main.css"/>" rel="stylesheet">
    <script src ="<c:url value="/resources/js/ProfnastilUtils.js"/> "></script>
    <%--<script src ="${pageContext.request.contextPath}/resources/js/bookUtils.js"></script>--%>
    <%--  <link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" >--%>

    <title>Feiron</title>
    <div class="login-link-container">

    </div>

</head>
<body>
<div class = "content">
    <h1><a href="${pageContext.request.contextPath}/"><img src="${pageContext.request.contextPath}/resources/img/logo-1.jpg" width="200" height="100"></a></h1>
    <div class="login-link-container">
        <sec:authorize access="isAnonymous()">
            <p>
                <%--<a href="/spring_security_login">Sign In</a>--%>
                <a href="${pageContext.request.contextPath}/spring_security_login">Sign In</a>
            </p>
            <a href="signup">Authoritiz</a>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <a href = "${pageContext.request.contextPath}/j_spring_security_logout">Sign Out</a>
        </sec:authorize>
    </div>

    <jsp:doBody/>
</div>

</body>
</html>
