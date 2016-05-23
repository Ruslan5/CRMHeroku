<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:directive.page contentType="text/html;charset=Utf-8"/>

<t:template>
    <sec:authorize access="isAuthenticated()">

        <form:form method="get" action="trapezium" var="pn">
            <a href="<c:url value="/"/>">Главная</a>

            <h1 id="header">Рассчёт трапеции (скатов) для вальмовой кровли</h1>
            <table>
                <div id="nav">
                    <ol>
                        <li>
                            <div id="rectangle"><a href="calc">Прямоугольник</a></div>
                        </li>
                        <p>
                        <li>
                            <div id="triangle"><p><a href="triangle">Треугольник</a></p></div>
                        </li>
                        </p>
                        <p>
                        <li>
                            <div id="trapezium"><a href="trapezium">Трапеция</a></div>
                        </li>
                        </p>
                        <p>
                        <li>
                            <div id="parallelogram">
                                <a href="#">Параллелограмм</a>
                            </div>
                        </li>
                        </p>
                    </ol>
                </div>
                <img src="${pageContext.request.contextPath}/resources/img/trapec.jpg">

                <div id="section">
                    <tr>
                        <td>
                            <form><label path="b">Ширина основания (a) </label></form>
                        </td>
                        <td><input style="width: 60px" type="text" name="a" value="${a}"/></td>
                    </tr>
                    <tr>
                        <td>
                            <form><label path="b">Ширина основания (b) </label></form>
                        </td>
                        <td><input style="width: 60px" type="text" name="b" value="${b}"/></td>
                    </tr>

                    <tr>
                        <td>
                            <form><label path="h">Высота (h) </label></form>
                        </td>
                        <td><input style="width: 60px" type="text" name="h" value="${h}"/></td>
                </div>

                <div>
                    <tr>
                        <td>
                            <form><label path="base_b"> Полезная ширина листа </label></form>
                        </td>
                        <td><input style="width: 60px" type="text" name="base_b" value="${pn.base_b}"/></td>
                    </tr>
                    <tr>
                        <td>
                            <form><label path="work_b"> Общая ширина листа </label></form>
                        </td>
                        <td><input style="width: 60px" type="text" name="work_b" value="${pn.work_b}"/></td>
                        <td colspan="2"><input type="submit" value="считать"/></td>
                    </tr>


                </div>

                <div>

                    <td><p>Количество профнастила:</p>
                        <input name="result" value="${result}"/>м.кв.
                        <p>Количество саморезов: </p>
                        <input name="sam" value="${sam}"/>шт.
                        <p>Количество листов:</p>
                        <input name="kl" value="${kl}"/>шт.
                    </td>
                </div>

            </table>
        </form:form>
    </sec:authorize>
</t:template>