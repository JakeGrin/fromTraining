<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<div>
    <p>
        <br><br>
    <h2 align=center><b> Welcome to the Online Shop!</b></h2>
    <br><br>
    <h2 align=center>
        <form action="${pageContext.request.contextPath}/start" method="post">
            <input type="text" name="username" placeholder="Enter your name" size=\"40\" required="required">
    </h2>
    <br>
    <h5 align=center><label><input type="checkbox" name="checked">
        I agree with the terms of service</label></h5>
    <h2 align=center><input type="submit" value="Enter"></h2>
    </form>
    </p>
</div>
</body>
</html>
