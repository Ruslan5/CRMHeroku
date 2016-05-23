<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<t:template>
    <sec:authorize access="isAuthenticated()">
    <figure style="float: left">
        <a href="calc"><img src="${pageContext.request.contextPath}/resources/img/calc.jpg" width="217"
                            height="217"></a>
        <figcaption><a href="calc">Калькулятор</figcaption>

    </figure>
    <figure style="float: left">
        <a href="product"><img src="${pageContext.request.contextPath}/resources/img/st.jpg" width="217"
                               height="217"></a>
        <figcaption><a href="product">Продукция</figcaption>
    </figure>
    <figure style="float: left">
        <a href="contact"><img src="${pageContext.request.contextPath}/resources/img/VCard.png" width="217"
                               height="217"></a>
        <figcaption><a href="contact">Контакты</figcaption>
    </figure>


    </sec:authorize>
</t:template>
