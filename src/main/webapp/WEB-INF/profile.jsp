<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
        <form action="/profile" method="POST">
            <button>Delete User</button>
            <input type="hidden" name="id" value="${user.id}">
            <button>Edit User</button>
            <input type="hidden" name="id" value="${user.id}">

<%--        </form>--%>
<%--        <form action="/profile" method="POST">--%>
<%--            <button>Edit User</button>--%>
<%--            <input type="hidden" name="id" value="${user.id}">--%>
<%--        </form>--%>
    </div>

</body>
</html>
