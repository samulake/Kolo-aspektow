<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>${stepsMessage}</h2>
	<font color="red"><form:errors path="aspect.*"></form:errors></font>
	
	<form method="post" action="addAspect">
		<input name="numberOfProficiencies" value="3" type="hidden">

		<table>
			<tr>
				<td>Aspekt tła</td>
				<td>Biegłości (wybierz 3)</td>
			</tr>
			<tr>
				<td valign="top"><input type="text" name="name" /></td>		
				<td><select name="assignedProficiencyList" multiple size="6">
						<option>Walecznosc i zahartowanie</option>
						<option>Kondycja i sprawnosc</option>
						<option>Wiedza i obycie</option>
						<option>Percepcja i empatia</option>
						<option>Ekspresja i perswazja</option>
						<option>Skrupulatnosc i precyzja</option>
				</select></td>
				<td><input type="submit" value="Dodaj" /></td>
			</tr>
		</table>
	</form>

	<h3>${proficienciesOnly}</h3>

	<h3>Aspekty tła</h3>
	<c:choose>
		<c:when test="${fn:length(backgroundAspectList) gt 0}">
			<table border=1>
				<tr>
					<th>Nazwa aspektu</th>
					<th>Biegłości</th>
				</tr>
				<c:forEach var="aspect" items="${backgroundAspectList}">
					<tr>
						<td><c:out value="${aspect.name}" /></td>
						<td>${aspect.assignedProficiencyList}</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>Nie podano żadnych aspektów tła</c:otherwise>
	</c:choose>
	
	<br><br>
	<form method="post" action="addAspect.htm">
		<input name="numberOfProficiencies" value="2" type="hidden">

		<table>
			<tr>
				<td>Aspekt roli</td>
				<td>Biegłości (wybierz 2)</td>
			</tr>
			<tr>
				<td valign="top"><input type="text" name="name" /></td>				
				<td><select name="assignedProficiencyList" multiple size="6">
						<option>Walecznosc i zahartowanie</option>
						<option>Kondycja i sprawnosc</option>
						<option>Wiedza i obycie</option>
						<option>Percepcja i empatia</option>
						<option>Ekspresja i perswazja</option>
						<option>Skrupulatnosc i precyzja</option>
				</select></td>
				<td><input type="submit" value="Dodaj" /></td>
			</tr>
		</table>
	</form>
	
	<h3>Aspekty roli</h3>
	<c:choose>
		<c:when test="${fn:length(roleAspectList) gt 0}">
			<table border=1>
				<tr>
					<th>Nazwa aspektu</th>
					<th>Biegłości</th>
				</tr>
				<c:forEach var="aspect" items="${roleAspectList}">
					<tr>
						<td><c:out value="${aspect.name}" /></td>
						<td>${aspect.assignedProficiencyList}</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>Nie podano żadnych aspektów roli</c:otherwise>
	</c:choose>

	<br><br>
	<form method="post" action="addAspect.htm">
		<input name="numberOfProficiencies" value="1" type="hidden">

		<table>
			<tr>
				<td>Aspekt skupienia</td>
				<td>Biegłości (wybierz 1)</td>
			</tr>
			<tr>
				<td valign="top"><input type="text" name="name" /></td>				
				<td><select name="assignedProficiencyList" multiple size="6">
						<option>Walecznosc i zahartowanie</option>
						<option>Kondycja i sprawnosc</option>
						<option>Wiedza i obycie</option>
						<option>Percepcja i empatia</option>
						<option>Ekspresja i perswazja</option>
						<option>Skrupulatnosc i precyzja</option>
				</select></td>
				<td><input type="submit" value="Dodaj" /></td>
			</tr>
		</table>
	</form>
	
	<h3>Aspekty skupienia</h3>
	<c:choose>
		<c:when test="${fn:length(focusAspectList) gt 0}">
			<table border=1>
				<tr>
					<th>Nazwa aspektu</th>
					<th>Biegłości</th>
				</tr>
				<c:forEach var="aspect" items="${focusAspectList}">
					<tr>
						<td><c:out value="${aspect.name}" /></td>
						<td>${aspect.assignedProficiencyList}</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>Nie podano żadnych aspektów tła</c:otherwise>
	</c:choose>

	<form method="post" action="submitData.html">
		<input type="submit" value="Dalej" />
	</form>

</body>
</html>