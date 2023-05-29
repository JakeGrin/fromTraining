<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
<div>
    <p>
        <br><br>
    <h1 align=center><b> Dear ${sessionScope.username}, your order:</b></h1>
    <div align=center>
        <ol> ${userBucket} </ol>
    </div>
    <h2 align=center><b> Total:${totalCost} $</h2>
</div>
</body>
</html>