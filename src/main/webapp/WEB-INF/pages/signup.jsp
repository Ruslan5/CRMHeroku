<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page session="true"%>
<t:template>

	<h1>Sign In</h1>

	<form:form method="post" action="/sp" commandName="signInForm"  >
		<table>
			<tr>
				<td>Name:</td>
				<td><form:input path="username" /></td>
				<td><span class="error"><form:errors path="username"/></span></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:password path="password" /></td>
				<td><span class="error"><form:errors path="password" /></span></td>
			</tr>

			<tr>
				<td>Double Password:</td>
				<td><form:password path="doublepassword" /></td>
				<td><span class="error"><form:errors
						path="doublepassword" /></span></td>
			</tr>

			<tr>
				<td>Email:</td>
				<td><form:input path="email" /></td>
				<td><span class="error"><form:errors path="email" /></span></td>
			</tr>

			<tr>
				<td colspan="3"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>

	<a href="${pageContext.request.contextPath}/" title="/">Home</a>
</t:template>
