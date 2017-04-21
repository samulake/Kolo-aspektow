<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	<h2>${stepsMessage}</h2>
	<font color="red"><form:errors path="strength.*"></form:errors></font>

	<form method="post" action="addStrength">
	<input type="hidden" name="value" value="3" />
		<table>
			<tr>
				<td>Nazwa atutu:</td>
				<td>Sfera glowna:</td>
				<td>Sfera sasiednia:</td>
			</tr>
			<tr>
				<td><input type="text" name="name" /></td>
				<td><select name="mainSphere">
						<option>Charakter</option>
						<option>Zacieklosc</option>
						<option>Elastycznosc</option>
						<option>Wyrafinowanie</option>
						<option>Socjalizacja</option>
				</select></td>
				<td><select name="adjoiningSphere">
						<option>Charakter</option>
						<option>Zacieklosc</option>
						<option>Elastycznosc</option>
						<option>Wyrafinowanie</option>
						<option>Socjalizacja</option>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" value="Dodaj" /></td>
			</tr>

		</table>
	</form>

	<h3>Atuty</h3>
	<c:choose>
		<c:when test="${fn:length(strengthList) gt 0}">
			<table border=1>
				<tr>
					<th>Nazwa atutu</th>
					<th>Sfera glowna</th>
					<th>Sfera sasiednia</th>
				</tr>
				<c:forEach var="strength" items="${strengthList}">
					<tr>
						<td><c:out value="${strength.name}" /></td>
						<td>${strength.mainSphere}</td>
						<td>${strength.adjoiningSphere}</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>Nie podano zadnych atutow!</c:otherwise>
	</c:choose>

	<br />

	<form action="submitStrengthData">
		<input type="submit" value="Dalej">
	</form>
</body>
</html>