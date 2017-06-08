<%@include file="Header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="fm"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

	<title>Category</title>
</head>
<body>

	${msg}

	<fm:form action="${pageContext.request.contextPath}/addCat"
	 commandName="category"  modelAttribute="category">

		
		<table align="center">
		
		<tr>
		<c:if test="${not empty category.cname }">
        <td>Category Id :</td><td><fm:input path="catId" disabled="true" readonly="true" /></td>
		<fm:hidden path="catId" />
		</c:if>
		</tr>
		
			<tr>
				<td>Category Name :</td>
				<td><fm:input path="cname"/></td>
			</tr>

            <tr>
				<td>Category Description :</td>
				<td><fm:input path="cdesc" /><br>
				<td>
			</tr>
		
			<c:if test="${empty category.cname }">
			
				<tr>
						<td><input type="submit" value="Add" /></td>
				</tr>
		   
		    </c:if>
		
		<tr>
          <c:if test="${not empty category.cname }">
	      
	        <td><input type="submit" value="Update" /></td>
		  
		  </c:if>
        </tr>

</table>

	</fm:form>
	

	<c:if test="${not empty categoryList}">

		<center>
			<h1>
				<font color="gold">CategoryLIST</font>
			</h1>
		</center>

		<table class="table table-hover">

			<thead>
				<tr>
					<th>CategoryName</th>
					<th>CategoryDescription</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>
			</thead>


			<tbody>

				<c:forEach items="${categoryList}" var="cat">

					<tr>
						<td>${cat.cname}</td>
						<td>${cat.cdesc}</td>
						<td><a href="<c:url value='updateCategory/${cat.catId}'/>">Update</a></td>
			  			<td><a href="deleteCategory/${cat.catId}">Delete</a></td>
					</tr>
		
		    	</c:forEach>
			
			</tbody>

			

		</table>

	</c:if>



</body>
</html>