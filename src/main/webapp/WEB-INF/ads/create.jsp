<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad"/>
    </jsp:include>
</head>
<body style="background-color: darkslategrey">
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<div class="container mt-4" style="background-color: azure; height: 90vh">
    <div class="row justify-content-center align-items-center" style="height: 90vh">
        <form class="col-8" action="/ads/create" method="post">
            <h1 class="text-center mb-5">Create a new Ad</h1>
            <div class="form-group">
                <label for="title">Title</label>
                <input id="title" name="title" class="form-control" type="text"
                       required> <%-- adding required to field to make sure it's not left empty by user--%>
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <textarea id="description" name="description" class="form-control" type="text"
                          required></textarea> <%-- adding required to field to make sure it's not left empty by user--%>
            </div>
            <%--            <div class="form-group">--%>
            <%--                <label for="title">Title</label>--%>
            <%--                <select id="category" name="title" class="form-control">--%>
            <%--                    <option value=""></option>--%>
            <%--                    <option value=""></option>--%>
            <%--                    <option value=""></option>--%>
            <%--                    <option value=""></option>--%>
            <%--                </select>--%>
            <%--            </div>--%>
            <input type="submit" class="btn btn-block btn-primary" value="Add">
        </form>
    </div>
</body>
</html>
