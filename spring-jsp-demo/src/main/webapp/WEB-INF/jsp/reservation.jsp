<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title> reservation </title>
</head>
<body>

<h2> Kindly Enter the Reservation Number  to know the Reservation Details</h2>
 <meta charset="UTF-8" />
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
<form method="post" action="reservation">
<input type="text" name="reservation_id" placeholder="reservation_id"/>
<br><br>
<button> Check the Details </button>
</form>
<br><br>
<h2> Details will be displayed in the below table </h2>
<div>
      <table border="1">
        <tr>
        <th> Car Id</th>
          <th>Car Model</th>
          <th>Type</th>
          <th>Price</th>
          <th>User_Name</th>
          <th>Token_Id</th>
          <th>Pick_Up</th>
          <th> Drop_Off</th>

        </tr>
        <c:forEach  items="${reserving}" var ="car">
        <tr>
          <td>${car.car_id}</td>
          <td>${car.brand}</td>
          <td>${car.type}</td>
          <td>${car.price}</td>
          <td>${car.user_name}</td>
          <td>${car.token}</td>
          <td>${car.pickup}</td>
          <td>${car.drop_off}</td>
        </tr>
        </c:forEach>



      </table>
    </div>
    <br><br>
        <a href="/login"> <button> BACK </button></a>
</body>
</html>
</html>
