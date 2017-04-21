<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Other data</title>
</head>
<body>
	<h2>${stepsMessage}</h2>
	<font color="red"><form:errors path="trait.*"></form:errors></font>
	<form action="addOther" method="post">
		<input type="hidden" value="SECRET" name="type" />
		<table>
			<tr>
				<td>Sekret</td>
				<td>Wartosc punktowa</td>
			</tr>
			<tr>
				<td><input type="text" name="name"></td>
				<td><select name="value">
						<option>1</option>
						<option>2</option>
						<option>3</option>
				</select></td>
				<td><input type="submit" value="Dodaj" /></td>
			</tr>
		</table>
	</form>
	
	<h3>Sekrety</h3>
	<c:choose>
		<c:when test="${fn:length(secretList) gt 0}">
			<table border=1>
				<tr>
					<th>Nazwa</th>
					<th>Wartość</th>
				</tr>
				<c:forEach var="secret" items="${secretList}">
					<tr>
						<td><c:out value="${secret.name}" /></td>
						<td>${secret.value}</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>Nie podano żadnych sekretów!</c:otherwise>
	</c:choose>

	<form action="addOther" method="post">
		<input type="hidden" value="RESOURCE" name="type" />
		<table>
			<tr>
				<td>Zasob</td>
				<td>Wartosc punktowa</td>
			</tr>
			<tr>
				<td><input type="text" name="name"></td>
				<td><select name="value">
						<option>1</option>
						<option>2</option>
						<option>3</option>
				</select></td>
				<td><input type="submit" value="Dodaj" />
			</tr>
		</table>
	</form>
	
	<h3>Zasoby</h3>
	<c:choose>
		<c:when test="${fn:length(resourceList) gt 0}">
			<table border=1>
				<tr>
					<th>Nazwa</th>
					<th>Wartość</th>
				</tr>
				<c:forEach var="resource" items="${resourceList}">
					<tr>
						<td><c:out value="${resource.name}" /></td>
						<td>${resource.value}</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>Nie podano żadnych zasobów!</c:otherwise>
	</c:choose>

	<form action="addOther" method="post">
		<input type="hidden" value="TAG" name="type" />
		<table>
			<tr>
				<td>Znacznik</td>
				<td>Wartosc punktowa</td>
			</tr>
			<tr>
				<td><input type="text" name="name"></td>
				<td><select name="tagValue">
						<option>1</option>
						<option>2</option>
						<option>3</option>
				</select></td>
				<td><input type="submit" value="Dodaj" />
			</tr>
		</table>
	</form>
	
	<h3>Znaczniki</h3>
	<c:choose>
		<c:when test="${fn:length(tagList) gt 0}">
			<table border=1>
				<tr>
					<th>Nazwa</th>
					<th>Wartość</th>
				</tr>
				<c:forEach var="tag" items="${tagList}">
					<tr>
						<td><c:out value="${tag.name}" /></td>
						<td>${tag.value}</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>Nie podano żadnych zasobów!</c:otherwise>
	</c:choose>

	<form action="addOther" method="post">
		<input type="hidden" value="EXPERIENCE" name="type" />
		<table>
			<tr>
				<td>Doswiadczenie</td>
				<td>Wartosc punktowa</td>
			</tr>
			<tr>
				<td><input type="text" name="name"></td>
				<td><select name="value">
						<option>1</option>
						<option>2</option>
						<option>3</option>
				</select></td>
				<td><input type="submit" value="Dodaj" />
			</tr>
		</table>
	</form>
	
		<h3>Doświadczenie</h3>
	<c:choose>
		<c:when test="${fn:length(experienceList) gt 0}">
			<table border=1>
				<tr>
					<th>Nazwa</th>
					<th>Wartość</th>
				</tr>
				<c:forEach var="experience" items="${experienceList}">
					<tr>
						<td><c:out value="${experience.name}" /></td>
						<td>${experience.value}</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>Nie podano żadnych doświadczeń!</c:otherwise>
	</c:choose>

	<form action="generatePDF" method="post">
		<p align="center">
			<input type="submit" />
		</p>
	</form>
</body>
</html>