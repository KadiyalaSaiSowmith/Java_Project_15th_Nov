<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Cars List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
  </head>
  <body>
    <h1>Cars List</h1>
    <br/><br/>
    <div>
      <table border="1">
        <tr>
        <th> Car Id</th>
          <th>Car Model</th>
          <th>Type</th>
          <th>Price</th>
        </tr>
        <c:forEach  items="${users}" var ="car">
        <tr>
          <td>${car.car_id}</td>
          <td>${car.brand}</td>
          <td>${car.type}</td>
          <td>${car.price}</td>
        </tr>
        </c:forEach>
      </table>
    </div>
    <p>Please click the below book button to book a car</p>
    <a href="/book"> <button> BOOK NOW </button></a>

  </body>
</html>