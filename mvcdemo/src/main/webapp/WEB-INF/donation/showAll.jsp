<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Donation</th>
				<th>Quantity</th>
				<th>Donor</th>
		</thead>
		<tbody>
			<c:forEach var="donation" items="${allDonations}">
				<tr>
					<td><c:out value="${donation.donationName}"/></td>
					<td><c:out value="${donation.quantity}"/></td>
					<td><c:out value="${donation.donor}"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>