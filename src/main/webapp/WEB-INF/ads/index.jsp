<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<div class="container">
    <h1>Welcome to the Adlister!</h1>
    <div class="d-flex justify-content-center align-items-center">
        <form action="/" method="POST" style="margin: auto">
            <input type="text" id="search-title" name="search-title" placeholder="Enter title">
            <button>Search</button>
        </form>
    </div>
</div>


</body>
</html>
