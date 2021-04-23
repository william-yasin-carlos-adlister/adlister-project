<%--
  Created by IntelliJ IDEA.
  User: carlospadilla
  Date: 4/22/21
  Time: 1:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Edit Ad" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <h1>Edit Ad</h1>
    <form action="/ads/edit" method="post">
        <div class="form-group">
            <label for="title">Title</label>
           <input id="title" name="title" class="form-control" type="text" placeholder="TITLE" value="${ad.title}" required> <%-- adding required to field to make sure it's not left empty by user--%>
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea id="description" name="description" class="form-control" placeholder="DESCRIPTION" value="${ad.description}" required></textarea> <%-- adding required to field to make sure it's not left empty by user--%>
        </div>
        <input type="hidden" value="${ad.id}" name="id">
        <input type="submit" class="btn btn-block btn-success" value="Update">
    </form>
</div>

</body>
</html>
