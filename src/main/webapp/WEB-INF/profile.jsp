<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container">
    <h1>Welcome, ${sessionScope.user.username}!</h1>

    <form action="/profile" method="POST">
        <button class="btn-primary btn">Delete User</button>
        <input type="hidden" name="id" value="${user.id}">
    </form>

    <div>
        <button class="btn-primary btn mb3"><a class="text-light" href="/edit-user">Edit User</a></button>
    </div>

    <div>
        <button class="btn-primary btn mb3"><a class="text-light" href="/ads/create">Create Ad</a></button>
    </div>

    <h2>My Ads</h2>
    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6 card mt-2 mr-2 ml-2 mb-2 border border-dark" style="width: 18rem;">
            <div class="card-body">
                <h5 class="card-title"><a href="#" class=" stretched-link">${ad.title}</a></h5>
                <p class="card-text">${ad.description}</p>
                <p>Click to see more details</p>
            </div>
        </div>
    </c:forEach>


</div>


</body>
</html>
