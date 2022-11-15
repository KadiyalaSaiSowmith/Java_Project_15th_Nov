<html>
<head>
<title> Welcome </title>
</head>
<body>

<h2> Welcome ${userId} to the site </h2>

<h2>${car_errorMsg} </h2>
<form method="post" action="welcome">
<input type="text" name="start_time" placeholder="start_time"/>
<br><br>
<input type="text" name="end_time" placeholder="end_time"/>
<br><br>
<input type="text" name="model" placeholder="model"/>
<br><br>
<p> Order by Price in </p>
<input type="text" name="sort" placeholder="asc/desc"/>
<br><br>
<button> Find </button>
</form>
 <style>
                        .footer {
                          position: fixed;
                          left: 0;
                          bottom: 0;
                          width: 100%;
                          background-color: #5B5EA6;
                          color: white;
                          text-align: center;
                        }
                        </style>

 <div class="footer">
         <a href="/return"> <button> CLICK HERE TO RETURN THE CAR </button></a>
               </div>
</body>
</html>