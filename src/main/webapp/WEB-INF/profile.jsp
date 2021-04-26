<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile"/>
    </jsp:include>
</head>
<body style="background-color: darkslategrey">
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container" style="background-color: azure">
    <%--    <c:choose>--%>
    <%--        <c:when test="${sessionScope.user != null}">--%>
    <div class="row d-flex align-items-center justify-content-start">
        <h1 class="col-6">Welcome, ${sessionScope.user.username}!</h1>
        <div class="col-2">
            <button class="btn-primary btn mb3"><a class="text-light" href="/ads/create">Create Ad</a></button>
        </div>
        <div class="col-2">
            <button class="btn-success btn mb3"><a class="text-light" href="/edit-user">Edit User</a></button>
        </div>
        <div class="col-2 mt-3">
            <form class="form-inline" action="/profile" method="POST">
                <button class="btn-danger btn">Delete User</button>
                <input type="hidden" name="id" value="${user.id}">
            </form>
        </div>
    </div>
    <hr>
    <br>


    <input type="hidden" name="user-id" id="user-id" value="${ad.userId}">

    <h2>My Ads</h2>
    <div class="row">
        <c:forEach var="ad" items="${ads}">
            <div class="col-4 d-flex justify-content-between align-items-middle">
                <div class="card mt-2 mr-2 ml-2 mb-2 border border-dark" style="width: 18rem;">
                    <div class="card-body">
                        <h5 class="card-title"><a href="details?id=${ad.id}" class=" stretched-link">${ad.title}</a>
                        </h5>
                        <p class="card-text">${ad.description}</p>
                        <p>Click to see more details</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <%--        </c:when>--%>
    <%--    </c:choose>--%>
    <%--    <c:choose>--%>
    <%--        <c:when test="${sessionScope.user == null}">--%>
    <%--&lt;%&ndash;            <h1>Welcome, ${sessionScope.user.username}!</h1>&ndash;%&gt;--%>

    <%--&lt;%&ndash;            <form action="/profile" method="POST">&ndash;%&gt;--%>
    <%--&lt;%&ndash;                <button class="btn-primary btn">Delete User</button>&ndash;%&gt;--%>
    <%--&lt;%&ndash;                <input type="hidden" name="id" value="${user.id}">&ndash;%&gt;--%>
    <%--&lt;%&ndash;            </form>&ndash;%&gt;--%>

    <%--&lt;%&ndash;            <div>&ndash;%&gt;--%>
    <%--&lt;%&ndash;                <button class="btn-primary btn mb3"><a class="text-light" href="/edit-user">Edit User</a></button>&ndash;%&gt;--%>
    <%--&lt;%&ndash;            </div>&ndash;%&gt;--%>

    <%--&lt;%&ndash;            <div>&ndash;%&gt;--%>
    <%--&lt;%&ndash;                <button class="btn-primary btn mb3"><a class="text-light" href="/ads/create">Create Ad</a></button>&ndash;%&gt;--%>
    <%--&lt;%&ndash;            </div>&ndash;%&gt;--%>
    <%--            <input type="hidden" name="user-id" id="user-id" value="${ad.userId}">--%>

    <%--            <h2>All Ads</h2>--%>
    <%--            <c:forEach var="ad" items="${ads}">--%>
    <%--                <div class="col-md-6 card mt-2 mr-2 ml-2 mb-2 border border-dark" style="width: 18rem;">--%>
    <%--                    <div class="card-body">--%>
    <%--                        <h5 class="card-title"><a href="details?id=${ad.id}" class=" stretched-link">${ad.title}</a></h5>--%>
    <%--                        <p class="card-text">${ad.description}</p>--%>
    <%--                        <p>Click to see more details</p>--%>
    <%--                    </div>--%>
    <%--                </div>--%>
    <%--            </c:forEach>--%>
    <%--        </c:when>--%>
    <%--    </c:choose>--%>


</div>


</body>
</html>
