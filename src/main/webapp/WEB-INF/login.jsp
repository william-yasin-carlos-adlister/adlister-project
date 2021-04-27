<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In"/>
    </jsp:include>
</head>
<body style="background-color: darkslategrey">
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<div class="container mt-4" style="background-color: azure; height: 90vh">
    <div class="row justify-content-center align-items-center" style="height: 90vh">
        <form class="col-8" action="/login" method="POST">
            <h1 class="text-center mb-5">Please Log In</h1>
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" name="password" class="form-control" type="password">
            </div>
            <input type="submit" class="btn btn-primary btn-block" value="Log In">
        </form>
    </div>
</div>

<%--<div class="container h-100">--%>
<%--    <div class="row h-100 justify-content-center align-items-center">--%>
<%--        <div class="col-10 col-md-8 col-lg-6">--%>
<%--            <!-- Form -->--%>
<%--            <form class="form-example" action="" method="post">--%>
<%--                <h1>Bootstrap 4: Align Center</h1>--%>
<%--                <p class="description">A tutorial on how to align a "form" vertically and horizontally in Bootstrap 4.</p>--%>
<%--                <!-- Input fields -->--%>
<%--                <div class="form-group">--%>
<%--                    <label for="username">Username:</label>--%>
<%--                    <input type="text" class="form-control username" id="username" placeholder="Username..." name="username">--%>
<%--                </div>--%>
<%--                <div class="form-group">--%>
<%--                    <label for="password">Password:</label>--%>
<%--                    <input type="password" class="form-control password" id="password" placeholder="Password..." name="password">--%>
<%--                </div>--%>
<%--                <button type="submit" class="btn btn-primary btn-customized">Login</button>--%>
<%--                <!-- End input fields -->--%>
<%--                <p class="copyright">&copy; Bootstrap 4 "Align Center" tutorial by <a href="https://azmind.com">AZMIND</a>.</p>--%>
<%--            </form>--%>
<%--            <!-- Form end -->--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
</body>
</html>
