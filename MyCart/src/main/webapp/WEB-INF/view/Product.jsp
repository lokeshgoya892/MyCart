<%@ include file="Header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
    <%@taglib uri="http://www.springframework.org/tags/form"  prefix="fm"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<html>
<head>
<style>
body { 
background-image: url("resources/image/bg9.jpg");
background-size:cover;
 background-position: 50% 50%;

 max-width: 100%;
    height: auto;
}
h1{
   text-align:center;
   
   } 


table, th, td {
    border: 3px solid black;
      border-collapse: collapse;
    
}
th, td {
    padding: 15px;
}
table {
    border-spacing: 5px;
}

th,td {
    text-align: center;
}
caption{
text-align:center;

}

</style>

</head>
<h1>Product Page</h1>

<body >

-${msg}

<div class="container">

  
  <fm:form action="${pageContext.request.contextPath}/addProduct "  method="post" enctype="multipart/form-data" commandName="product" modelAttribute="product" class="form-horizontal">
    
    
    <div class="form-group">
      <label class="control-label col-sm-3" >Product Id:</label>
      <div class="col-sm-3">
   <c:if test="${not empty product.productname }"> 
        <fm:input type="text" class="form-control" path="productId"></fm:input>
     </c:if>

      </div>
    </div>
     <div class="form-group">
      <label class="control-label col-sm-3" >Name:</label>
      <div class="col-sm-3">   
           
        <fm:input input="text" class="form-control"  path="productname"></fm:input>
       
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-3" >Description:</label>
      <div class="col-sm-3">   
           
        <fm:input input="text" class="form-control"  path="productdesc"></fm:input>
       
      </div>
    </div>
    
      <div class="form-group">
       <label class="control-label col-sm-3" >Product Image:</label>
      <div class="col-sm-3">
   <fm:input type="file" class="form-control" path="image" required="true"></fm:input>
    </div>
    </div>
    
    <div class="form-group">
      <label class="control-label col-sm-3" >Price:</label>
      <div class="col-sm-3">   
           
        <fm:input input="text" class="form-control"  path="price"></fm:input>
       
      </div>
    </div>
        <div class="form-group">
      <label class="control-label col-sm-3" >Category:</label>
      <div class="col-sm-3">   
           
       <fm:select path="categoryid">
       <c:forEach items="${categoryList}" var="cat">
       <fm:option value="${cat.catId}">${cat.catId}</fm:option>
       </c:forEach>
       </fm:select>  
      </div>
    </div>
      <div class="form-group">
      <label class="control-label col-sm-3" >Supplier:</label>
      <div class="col-sm-3">   
           
       <fm:select path="supplierid">
       <c:forEach items="${supplierList}" var="sup">
       <fm:option value="${sup.supId}">${sup.supId}</fm:option>
       </c:forEach>
       </fm:select>  
      </div>
    </div>
    <div class="form-group">        
      
      <label class="control-label col-sm-3" >Quantity:</label>
        <div class="col-sm-3">
        <fm:input type="text" class="form-control"  path="quantity"></fm:input>
      </div>
    </div>
    
    <div class="form-group">        
      <div class="col-sm-offset-3 col-sm-3">
    <c:if test="${empty product.productname }">
        <fm:button type="submit" class="btn btn-default">Register</fm:button>
   </c:if>
      </div>
      <div class="col-sm-offset-2 col-sm-3">
      <c:if test="${ not empty product.productname }">
        <fm:button type="submit" class="btn btn-default">Update</fm:button>
       </c:if>
      </div>
    </div>
  </fm:form>
  
 
  <c:if test="${not empty productList}">
<h1>Product</h1>
<table style="width:100%">


<tr>
<th>PId</th>
<th>Product name</th>


<th>Description</th>
<th>Price &#8377</th>
<th>Quantity</th>
<th colspan="2">Action</th>
</tr>

<c:forEach items="${productList}" var="prd">

<tr>


<td>${prd.productId}</td>
<td>${prd.productname}</td>
<td>${prd.productdesc}</td>
<td>${prd.price}</td>
<td>${prd.quantity}</td>



<td><a href="<c:url value='updateProduct/${prd.productname}'/>"class="btn btn-xs btn-warning"><span class="glyphicon glyphicon-edit"></span>&nbsp Edit</a></td>
<td><a href="<c:url value='deleteProduct/${prd.productname}'/>   " class="btn btn-xs btn-danger"><span class="glyphicon glyphicon-trash"></span>&nbsp Del &nbsp</a></td>
<!-- <td><img src="resources/images/${prd.productId}.jpg" width="10" height="10"></td> -->
</tr>



</c:forEach>

</table>



</c:if>
  
  


  
  
</div>
</body>
</html>