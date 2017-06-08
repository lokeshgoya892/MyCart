
<!DOCTYPE html>
<html lang="en">
<head>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
       <a class="navbar-brand" href="${pageContext.request.contextPath}/index" ></a>
      <a href="${pageContext.request.contextPath}/index"> <img src="https://www.beardo.in/wp-content/uploads/2017/02/beardo-logowhite.png" width="200" height="100"></a>
    </div>
    
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
      
        <li><a class="dropdown-toggle" data-toggle="dropdown" href="#">Product
        <span class="caret"></span></a></li>
        <ul class="dropdown-menu">
        <li><a href="${pageContext.request.contextPath}/adminProduct">Product</a></li>
          <li><a href="${pageContext.request.contextPath}/Category">Category</a></li>
          <li><a href="${pageContext.request.contextPath}/Supplier">Supplier</a></li>
         </ul>
           
      <ul class="nav navbar-nav navbar-right">
        <li><a href="${pageContext.request.contextPath}/User"><span class="glyphicon glyphicon-user"></span> User</a></li>
        <li><a href="${pageContext.request.contextPath}/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
         <%-- <li><a href="${pageContext.request.contextPath}/"><span class="glyphicon glyphicon-log-in"></span> Login</a></li> --%>
      </ul>
    </div>
  </div>
  
  
</nav>
  

</body>
</html>