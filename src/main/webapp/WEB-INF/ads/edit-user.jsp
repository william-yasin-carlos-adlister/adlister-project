<%--
  Created by IntelliJ IDEA.
  User: yasinmogultay
  Date: 4/23/21
  Time: 4:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Edit User" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <h1>Edit User</h1>
    <form action="/ads/user-edit" method="post">
        <div class="form-group">
            <label for="title">Title</label>
            <input id="title" name="title" class="form-control" type="text" placeholder="USERNAME" value="${user.username}" required>
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea id="description" name="description" class="form-control" placeholder="EMAIL" value="${user.email}"></textarea>
        </div>
        <input type="hidden" value="${user.id}" name="id">
        <input type="submit" class="btn btn-block btn-success" value="Update">
    </form>
</div>

</body>
</html>
