<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container">
    <h1>Here Are all the ads!</h1>


            <c:forEach var="artist" items="${artists}">
                <div class="card mt-2 mr-2 ml-2 mb-2 border border-dark" style="width: 18rem;">
                    <div class="card-body">
                        <h5 class="card-title"><a href="details?id=${artist.id}"
                                                  class=" stretched-link">${artist.name}</a>
                        </h5>
                            <%--                    <p class="card-text">${album.price}</p>--%>
                        <p>Click to see more details</p>
                    </div>
                </div>
            </c:forEach>
    <%--    Need choose/when to display albums or artist search results....   --%>

</div>

</body>
</html>
