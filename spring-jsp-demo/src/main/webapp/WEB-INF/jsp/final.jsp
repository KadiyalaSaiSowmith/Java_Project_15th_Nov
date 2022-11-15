<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
  <head>
  <h2> BOOKED SUCCESSFULLY </h2>
    <meta charset="UTF-8" />
    <title>Cars List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
  </head>
  <body>
    <h1>Booked Car Details</h1>
    <br/><br/>
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
        <c:forEach  items="${booking}" var ="car">
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

      <p>Click the below button to navigate to the Login page</p>
          <a href="/login"> <button> Move to Login </button></a>
    </div>
  </body>
</html>
</html>