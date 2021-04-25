<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h1>Create a new Wax Ad</h1>
        <form action="/ads/create" method="post">
            <div class="form-group">
                <label for="ad_title">Ad Title</label>
                <input id="ad_title" name="ad_title" class="form-control" type="text" required> <%-- adding required to field to make sure it's not left empty by user--%>
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <input id="description" name="description" class="form-control" type="text" required> <%-- adding required to field to make sure it's not left empty by user--%>
            </div>
            <div class="form-group">
                <label for="artist_name">Artist Name</label>
                <input id="artist_name" name="artist_name" class="form-control" type="text" required> <%-- adding required to field to make sure it's not left empty by user--%>
            </div>
            <div class="form-group">
                <label for="album_title">Album Title</label>
                <input id="album_title" name="album_title" class="form-control" type="text" required> <%-- adding required to field to make sure it's not left empty by user--%>
            </div>
            <div class="form-group">
                <label for="price">Price</label>
                <textarea id="price" name="price" class="form-control" type="text" required></textarea> <%-- adding required to field to make sure it's not left empty by user--%>
            </div>

            <input type="submit" class="btn btn-block btn-primary" value="Add">
        </form>
    </div>
</body>
</html>
