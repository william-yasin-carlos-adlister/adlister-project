<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Ad Details"/>
    </jsp:include>
</head>
<body style="background-color: darkslategrey">
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<br>
<div class="container mt-4" style="background-color: azure; height: 90vh">
    <div class="row justify-content-center align-items-center" style="height: 90vh">
        <%--  *******   show username is not working when user is not logged in ***** --%>
        <div class="col-8">
            <h1 class="col-12 text-center mt-4">Additional details</h1>
            <div class="card">
                <h5 class="card-header">Title: ${ad.title}</h5>
                <div class="card-body">
                    <h5 class="card-title"><a href="/profile">Created By: ${user.getUsername()}</a></h5>
                    <p class="card-text">Description: ${ad.description}</p>
                    <a href="/ads" class="btn btn-primary">Ads</a>
                    <a href="/ads/edit?id=${ad.id}" class="btn btn-success">Edit</a>
                    <form action="/details" method="POST">
                        <button class="btn btn-danger mt-1">Delete</button>
                        <input type="hidden" value="${ad.id}" name="id">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>
