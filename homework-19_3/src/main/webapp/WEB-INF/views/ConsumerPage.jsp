<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<div>
    <p>
        <br><br>
    <h1 align=center><b> Hello, ${sessionScope.username}! </b></h1>
    <p align=center>
        ${empty currentUserBucket ? "Make your order" : "You have already chosen" }
    </p>
    <div align=center>
        <ol> ${currentUserBucket}</ol>
    </div>
    <h2 align=center>
        <form action="${pageContext.request.contextPath}/consumer" method="post">
            <select size="1" name="id" required="required">
                ${makeGoodList}
            </select>
            </p>
    </h2>
    <h2 align=center><input type="submit" value="Add item">
        </form>
        <br><br>
        <form action="${pageContext.request.contextPath}/order" method="get">
            <input type="submit" value="Submit">
        </form>
    </h2>
</div>
</body>
</html>