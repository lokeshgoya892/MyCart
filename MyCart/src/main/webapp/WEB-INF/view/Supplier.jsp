<%@ include file="Header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="fm"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	${msg}

	<fm:form action="${pageContext.request.contextPath}/addsup"
		commandName="supplier" modelAttribute="supplier">



		<table align="center">

			<tr>
				<s:if test="${not empty supplier.sname }">
					<td>Supplier Id :</td>
					<td><fm:input path="supId" disabled="true"
							readonly="true" /></td>
					<fm:hidden path="supId" />
			    </s:if>
			</tr>
			

			<tr>
				<td>Supplier Name :</td>
				<td><fm:input path="sname" /></td>
			</tr>

			 <tr>
				<td>Supplier Description:</td>
				<td><fm:input path="sdesc" /></td>
			</tr>

		
			<s:if test="${empty supplier.sname }">
                
                <tr>
					<td><input type="submit" value="Add" /></td>
				</tr>
				
			</s:if>

			<tr>
				<s:if test="${not empty supplier.sname }">
					<td><input type="submit" value="Update" /></td>
			    </s:if>
			</tr>
			
		</table>

	</fm:form>


	<s:if test="${not empty SupplierList}">

		<center>
			<h1>
				<font color="gold">SupplierLIST</font>
			</h1>
		</center>

		<table class="table table-hover">

			<thead>
				<tr>
					<th>Supplier Name</th>
					<th>Supplier City</th>
					<th>Change</th>
					<th>Delete</th>
				</tr>
			</thead>


			<tbody>

				<s:forEach items="${SupplierList}" var="sup">

					<tr>
						<td>${sup.sname}</td>
						<td>${sup.sdesc}</td>
						<td><a href="updateSupplier/${sup.supId}">Update</a></td>
						<td><a href="deleteSupplier/${sup.supId}">Delete</a></td>
					</tr>

				</s:forEach>
			</tbody>


		</table>

	</s:if>

</body>
</html>