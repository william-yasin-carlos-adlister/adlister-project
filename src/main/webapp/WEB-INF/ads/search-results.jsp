<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads"/>
    </jsp:include>
</head>
<body style="background-color: darkslategrey">
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container" style="background-color: azure; height: 90vh">
    <h1 class="mt-4 text-center">Here are the ads!</h1>
    <hr>

    <div class="row">
        <c:forEach var="ad" items="${ads}">
            <div class="col-4 d-flex justify-content-between align-items-middle">
                <div class="card bg-secondary text-white mt-2 mr-2 ml-4 mb-2 border border-dark" style="width: 18rem;">
                    <div class="card-header">
                        <h5 class="card-title"><a style="color: white" href="details?id=${ad.id}"
                                                  class=" stretched-link">${ad.title}</a></h5>
                    </div>
                    <div class="card-body">
                        <p class="card-text">${ad.description}</p>
                        <p>Click to see more details</p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

</div>

</body>
</html>
