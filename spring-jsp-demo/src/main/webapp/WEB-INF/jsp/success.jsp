<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<html>
<H1> THANK YOU FOR AVAILING OUR SERVICE, CAR HAS BEEN RETURNED SUCCESSFULLY <H1>
<br><br>
<body>
<h2> Details of the Returned Car will be displayed in the below table </h2>
<div>
      <table border="1">
        <tr>
        <th> Car Id</th>
          <th>Car Model</th>
          <th>Type</th>
          <th>Price</th>

        </tr>
        <c:forEach  items="${returning}" var ="car">
        <tr>
          <td>${car.car_id}</td>
          <td>${car.brand}</td>
          <td>${car.type}</td>
          <td>${car.price}</td>
        </tr>
        </c:forEach>
        </table>
    </div>
    <br><br>
    <a href="/login"> <button> BACK </button></a>
    </body>
</html>
</html>