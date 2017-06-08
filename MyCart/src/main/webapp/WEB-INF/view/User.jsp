<%@ include file="Header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="fm"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="u"%>

<!DOCTYPE html>
<html lang="en">
    <head> 
    	<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">

		<!-- Website CSS style -->
		<link rel="stylesheet" type="text/css" href="assets/css/main.css">

		<!-- Website Font style -->
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
		
		<!-- Google Fonts -->
		<link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>

		<title>Registration</title>
		<style>
		
body, html{
     height: 100%;
     background-repeat: no-repeat;
 	background-color: #d3d3d3;
 	font-family: 'Oxygen', sans-serif;
    font-size: 12px;
}

.main{
 	margin-top: 70px;
}

h1.title { 
	font-size: 50px;
	font-family: 'Passion One', cursive; 
	font-weight: 400; 
}

hr{
	width: 10%;
	color: #fff;
}

.form-group{
	margin-bottom: 15px;
}

label{
	margin-bottom: 14px;
}

input,
input::-webkit-input-placeholder {
    font-size: 9px;
    padding-top: 3px;
}

.main-login{
 	background-color: #fff;
    /* shadows and rounded borders */
    -moz-border-radius: 2px;
    -webkit-border-radius: 2px;
    border-radius: 2px;
    -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);

}

.main-center{
 	margin-top: 30px;
 	margin: 0 auto;
 	max-width: 330px;
    padding: 40px 40px;

}

.login-button{
	margin-top: 3px;
}

.login-register{
	font-size: 8px;
	text-align: center;
}
		
		
		</style>
	</head>
	<body>
${msg}

	<fm:form action="${pageContext.request.contextPath}/addUser"
	 commandName="user"  modelAttribute="user">

		
		<table align="center">
		
		<tr>
		<u:if test="${not empty user.uname }">
        <td>User Id :</td><td><fm:input path="userId" disabled="true" readonly="true" /></td>
		<fm:hidden path="userId" />
		</u:if>
		</tr>
		
			<tr>
				<td>User Name :</td>
				<td><fm:input path="uname"/></td>
			</tr>

			<tr>
				<td>Password :</td>
				<td><fm:input type="password" path="upassword"/></td>
			</tr>
            <tr>
				<td>City :</td>
				<td><fm:input path="usercity" /><br>
				<td>
			</tr>
			  <tr>
				<td>State :</td>
				<td><fm:input path="userstate" /><br>
				<td>
			</tr>
			  <tr>
				<td>Country :</td>
				<td><fm:input path="usercountry" /><br>
				<td>
			</tr>
			  <tr>
				<td>Mobile Number</td>
				<td><fm:input path="mobileno" /><br>
				<td>
			</tr>
		
			<u:if test="${empty user.uname }">
			
				<tr>
						<td><input type="submit" value="Add" ></td>
				</tr>
		 
		    </u:if>
		
		
</table>
</fm:form>
</body>
</html>
