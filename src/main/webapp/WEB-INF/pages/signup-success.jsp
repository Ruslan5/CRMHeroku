<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<t:template>

	<h1>Successfull Sign Up</h1>

	<p>Congratulations! Your signup was successful</p>
	<form:form action="signInForm"  method="post" commandName="signup">
		<p>Hallo, ${signInForm.username}</p>
		<p>Ваш емайл: ${signInForm.email}</p>
	</form:form>


	<a href="${pageContext.request.contextPath}/" title="/">Home</a>

</t:template>

