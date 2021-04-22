<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Ad Details"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<br>
    <div class="card mt3 mb3 mr3 ml3 container">
        <h5 class="card-header">Title: ${ad.title}</h5>
        <div class="card-body">
            <h5 class="card-title">User Id: ${ad.userId}</h5>
            <p class="card-text">Description: ${ad.description}</p>
<%--            <p class="card-text">Created by: ${user.username}</p>--%>
            <a href="/ads" class="btn btn-primary">Ads</a>
            <form action="/details" method="POST">
                <button>Delete</button>
                <input type="hidden" value="${ad.id}" name="id">
            </form>
        </div>
    </div>
</body>
</html>
