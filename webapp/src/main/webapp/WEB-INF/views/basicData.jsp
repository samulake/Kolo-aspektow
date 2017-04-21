<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Basic data</title>
</head>
<body>
	<h2>${stepsMessage}</h2>
	<h3>Dane podstawowe</h3>
	<form action="submitBasicData.html" method="post">
		<table>
			<tr>
				<td>Imię postaci:</td>
				<td><input type="text" name="name" /></td>
				<td><font color="red"><form:errors path="hero.name" /></font></td>
			</tr>
			<tr>
				<td>Pula zaangażowania:</td>
				<td><input type="text" name="involvementPool"/></td>
				<td><font color="red"><form:errors path="hero.involvementPool" /></font></td>
			</tr>
			<tr>
				<td>Pula opowieści:</td>
				<td><input type="text" name="talePool" /></td>
				<td><font color="red"><form:errors path="hero.talePool" /></font></td>
			</tr>
			<tr>
				<td>Doniosłość podstawowa:</td>
				<td><select name="baseSignificance">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
				</select></td>
			</tr>

			<tr>
				<td><input type="submit" value="Dalej" /></td>
			</tr>
		</table>
	</form>

</body>
</html>