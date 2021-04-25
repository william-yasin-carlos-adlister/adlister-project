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
    <h1>Welcome to the Waxlister!</h1>
    <br>
    <div>
        <form action="/" method="POST">
            <label for="search-title">Search by album title: </label>
            <input type="text" id="search-title" name="search-title" placeholder="Enter album title">
            <label for="search-artist">Search by artist: </label>
            <input type="text" id="search-artist" name="search-artist" placeholder="Enter artist name">
            <%--     if we do search by ad...   insert search by ad as well.... just get old code and put back in and use adsDao --%>
            <button>Search</button>
        </form>
    </div>
</div>


</body>
</html>
