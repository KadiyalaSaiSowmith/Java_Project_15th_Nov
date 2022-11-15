<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
    <title>Login Page</title>
    <link href="webjars/bootstrap/4.6.1/css/bootstrap.min.css" rel = "stylesheet">
    <style>
    /* Header/Logo Title */
    .header {
      padding: 60px;
      text-align: center;
     /* background: #98B4D4; */
      color: #98B4D4;
      font-size: 30px;
    }
    .Login-form{
    width:400px;
    height: 200px;
    position: absolute;
    background-color: #5B5EA6;
    border-radius:20px;
    top:50%;
    left: 50%;
    margin-right:50%;
    transform:translate(-50%,-50%);
    </style>

    </head>
    <body>
    <h2> ${errorMsg}</h2>
    <div class="header">
      <h1>Rental Cars.com</h1>
      <p> 24/7 Service at any location in Hyderabad </p>
    </div>
    <div class = "Login-form">
    <c:if test="${not empty errorMsg}">
    <div class="alert alert-danger" role="alert">${errorMsg}</div>
    </c:if>
    <div class = "container-fluid">
        <form:form method = "post" modelAttribute="user">
        <div class = "mt-3">
            <form:input type="text" path="userId" class= "form-control mt-3" placeholder="User ID" />
        </div>
         <div class = "mt-3">
            <form:input type="password" path="password" class= "form-control mt-3" placeholder="Password" />
 </div>
            <form:button type ="submit" class = "btn btn-dark btn-block mt-3">Register </form:button>


        </form:form>
        </div>
        </div>
    </body>
</html>