<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title> return </title>
</head>
<body>

<h2> Kindly Enter the Car_Id  to proceed with the Returning process</h2>
 <meta charset="UTF-8" />
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
<form method="post" action="return">
<input type="number" name="return_id" placeholder="Car_Id"/>
<br><br>
<a href="/success"> <button> OK </button></a>

</form>
<br><br>
<h2> Details will be displayed in the below table </h2>
<div>

    </div>
</body>
</html>
</html>
