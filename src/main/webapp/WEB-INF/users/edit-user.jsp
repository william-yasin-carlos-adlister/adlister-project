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
        <jsp:param name="title" value="Edit User"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<div class="container">
    <h1>Edit User</h1>
    <form action="/edit-user" method="post">
        <div class="form-group">
            <label for="username">Username</label>
            <input id="username" name="username" class="form-control" type="text" placeholder="USERNAME"
                   value="${user.username}" required>
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <textarea id="email" name="email" class="form-control" placeholder="EMAIL" value="${user.email}"
                      required></textarea>
        </div>
        <input type="hidden" value="${user.id}" name="id">
        <input type="submit" class="btn btn-block btn-success" value="Update">
    </form>
</div>

</body>
</html>
