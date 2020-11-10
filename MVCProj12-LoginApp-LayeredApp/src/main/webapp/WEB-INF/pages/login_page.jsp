<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<frm:form action="login" method="post" modelAttribute="modelLog">
<table border="1" bgcolor="cyan">
<tr><td>enter uname::</<td><td><frm:input path="uname"/></td></tr>
<tr><td>enter password::</<td><td><frm:input path="password"/></td></tr>
<tr colspan="2"><td><input type="submit" value="sign in"></td></tr>
</table>
</frm:form>
<br>
<h2 style="color:lightgreen">${result}</h2>