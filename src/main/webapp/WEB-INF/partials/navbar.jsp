<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Adlister</a>
        </div>
        <c:choose>
            <c:when test="${sessionScope.user == null}">
                <ul class="nav navbar-nav navbar-right">
                    <li class="nav-item active"><a class="nav-link" href="/login">Login</a></li>
                    <li class="nav-item active"><a class="nav-link" href="/register">Register</a></li>
                </ul>
            </c:when>
        </c:choose>
        <c:choose>
            <c:when test="${sessionScope.user != null}">
                <ul class="nav navbar-nav navbar-right">
                    <li class="nav-item active"><a class="nav-link">Logged in as: ${sessionScope.user.username}</a></li>
                    <li class="nav-item active"><a class="nav-link" href="/ads/create">Create Ad</a></li>
                    <li class="nav-item active"><a class="nav-link" href="/profile">My Profile</a></li>
                    <li class="nav-item active"><a class="nav-link" href="/logout">Logout</a></li>
                </ul>
            </c:when>
        </c:choose>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
