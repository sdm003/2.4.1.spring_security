<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<body>
<div align="center">
    <h1>Edit User</h1>
    <form:form action="edit" method="post" modelAttribute="userr">
        <table>
            <td><form:hidden path="id" /></td>
            <tr>
                <td>Age:</td>
                <td><form:input path="age" /></td>
            </tr>
            <tr>
                <td>Street:</td>
                <td><form:input path ="street" /></td>
            </tr>
            <tr>
                <td>Role:</td>
                <td><form:input path ="role" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Edit"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>