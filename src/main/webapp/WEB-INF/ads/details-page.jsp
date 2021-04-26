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
        <h5 class="card-header">Title: ${ad.adTitle}</h5>
        <div class="card-body">
            <%--  *******   show username is not working when user is not logged in ***** --%>
            <h5 class="card-title"><a href="/profile">Created By: ${user.getUsername()}</a></h5>
                <p class="card-text">Artist: ${artist.name}</p>
<%--                <p class="card-text">Album: ${album.title}</p>--%>
<%--                <p class="card-text">Album: ${ad.album.title}</p>--%>
                                <p class="card-text">Artist: ${ad.album.artist.name}</p>
            <p class="card-text">Description: ${ad.description}</p>
                <p class="card-text">Album: ${album.price}</p>
            <a href="/ads" class="btn btn-primary">Ads</a>
            <a href="/ads/edit?id=${ad.id}" class="btn btn-success">Edit</a>
            <form action="/details" method="POST">
                <button>Delete</button>
                <input type="hidden" value="${ad.id}" name="id">
                <input type="hidden" value="${artist.getName()}" name="artistName">
                <input type="hidden" value="${album.getTitle()}" name="albumName">
            </form>
        </div>
    </div>
</body>
</html>
