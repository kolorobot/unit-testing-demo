<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1>Register</h1>
<form:form modelAttribute="registrationForm">
    <form:errors path="*" element="p" cssStyle="color: red;" />
    <table>
        <tr>
            <td width="170px">Username</td>
            <td><form:input path="username" /> <form:errors path="username" /></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><form:password path="password" /> <form:errors path="password" /></td>
        </tr>
        <!-- 
        <tr>
            <td>Confirm password</td>
            <td><form:password path="confirmedPassword" /> <form:errors path="confirmedPassword" /></td>
        </tr>
         -->
        <tr>
            <td colspan="2"><input type="submit" value="Register"></input></td>
        </tr>
    </table>
</form:form>