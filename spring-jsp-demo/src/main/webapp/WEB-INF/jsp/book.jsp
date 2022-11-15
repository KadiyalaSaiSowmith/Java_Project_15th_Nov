<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Booking Details</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
  </head>
  <body>
    <form id="book" action="book" method="post">
    <h2> Enter the details for confirming the Booking </h2>

        <input type="number" name="car_id" placeholder="car_id">
        <br>
        <br>

          <input type="text" name="user_name" placeholder="user_name" >
           <br>
           <br>

                <input type="text" name="pickup"placeholder="pickup date">
        <br>
        <br>

                        <input type="text" name="drop_off" placeholder="drop_off date" >
                <br>
                <br>


        <button>CONFIRM BOOKING</button>
    </form>
  </body>
</html>


