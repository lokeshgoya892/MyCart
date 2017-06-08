<!DOCTYPE html>
<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.2/css/bootstrap.min.css" integrity="sha384-y3tfxAZXuh4HwSYylfB+J125MxIs6mR5FOHamPBG064zB+AFeWH94NdvaCBm8qnd" crossorigin="anonymous">

 <style type="text/css">


.carousel-inner > .carousel-item > img {
        padding-top:35px;
    margin: 0 auto;
    border-radius: 10px 10px 10px 10px;
    
    max-height: 500px;
    width: 750px;  
   
}



.carousel-control.left, .carousel-control.right {
    background-image: none;


}
#carousel
{
  margin-bottom: 50px;

}
</style>



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
     
     <%-- <a class="z" href="${pageContext.request.contextPath}/index" ></a> --%>
     <a href="${pageContext.request.contextPath}/index"> <img src="https://www.beardo.in/wp-content/uploads/2017/02/beardo-logowhite.png" width="200" height="100"></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <!-- <li class="active"><a href="#">Home</a></li> -->
         <li><a href="${pageContext.request.contextPath}/adminProduct">Product</a></li>
         <li><a href="${pageContext.request.contextPath}/Supplier">Supplier</a></li>
                            <li><a href="${pageContext.request.contextPath}/Category">category</a></li>
        
          <c:forEach items="${categoryList}" var="cat">
          <li><a href="${pageContext.request.contextPath}/allProducts/${cat.catId}">${cat.catId}</a></li>
         
                  </c:forEach>
          
        <!--  <li><a href="${pageContext.request.contextPath}/Hair">Hair</a></li>
         <li><a href="${pageContext.request.contextPath}/Shower">Shower</a></li>
         <li><a href="${pageContext.request.contextPath}/Skin">Skin</a></li>
         <li><a href="${pageContext.request.contextPath}/Tools">Tools</a></li>
         <li><a href="${pageContext.request.contextPath}/Combos">Combos</a></li>-->
         </ul>
         
      <ul class="nav navbar-nav navbar-right">
        <li><a href="${pageContext.request.contextPath}/User"><span class="glyphicon glyphicon-user"></span> User</a></li>
        <li><a href="${pageContext.request.contextPath}/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
    </div>
  </div>
</nav>
  
<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
    <li data-target="#myCarousel" data-slide-to="3"></li>
    
  </ol>

  <!-- Wrapper for slides -->
                <div class="carousel-inner">
                    <div class="item active">
                        <div> <img src='resources/images/beard.jpg' style="width:100%; " /></div>
                        <div class="carousel-caption" style="top:100; bottom :auto">
                          
                        </div>
                    </div>
                <div class="item">
                        <div><img src="resources/images/hair.jpg" alt="Alternate Text" style="width:100%" /></div>
                        <div class="carousel-caption" style="top:10; bottom :auto">
                          
                        </div>
                    </div>
                    <div class="item">
                        <div><img src='resources/images/shower.jpg' style="width:100%" /></div>
                        <div class="carousel-caption" style="top:auto; bottom :auto">
                        
                        </div>
                    </div>
                    <div class="item">
                        <div><img src='resources/images/skin.jpg'  style="width:100%" /></div>
                        <div class="carousel-caption" style="top:0; bottom :auto">
                         
                        </div>
                    </div>
                </div>
  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    <span class="sr-only">Next</span>
  </a>
</div>

</body>
</html>
