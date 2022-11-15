
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
    height: 270px;
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
    <c:if test="${not empty successMsg}">
    <div class="alert alert-success" role="alert">${successMsg}</div>
    </c:if>

     <c:if test="${not empty errorMsg}">
        <div class="alert alert-danger" role="alert">${errorMsg}</div>
        </c:if>
    <div class = "container-fluid">
        <form method = "post" action="login">
            <input type="text" name="userId" class= "form-control mt-3" placeholder="User ID" />

            <input type="password" name="password" class= "form-control mt-3" placeholder="Password" />

            <button type = "submit" class = "btn btn-dark btn-block mt-3">Login</button>

            <div class = "mt-3">
               <a href="/register" class="btn btn-success btn-block mt-3">Register</a>
            </div>


        </form>
        </div>

        </div>
         <style>
                        .footer {
                          position: fixed;
                          left: 0;
                          bottom: 0;
                          width: 100%;
                          background-color: #34568B;
                          color: white;
                          text-align: center;
                        }
                        </style>

                        <div class="footer">
                          <a href="/reservation"> <button> BOOKING STATUS </button></a>
                        </div>

    </body>
</html>