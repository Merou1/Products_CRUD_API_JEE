<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Search</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">

    <h2 class="text-center mb-4">Search Products</h2>
    
    <form action="Controller" method="post" class="form-inline justify-content-center mb-4">
        <input type="text" class="form-control mr-2" placeholder="Enter mot cle" name="motCle">
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>

    <div class="table-responsive">
        <table class="table table-bordered table-striped">
            <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>Nom</th>
                    <th>Prix</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${model.products}" var="p">
                    <tr>
                        <td>${p.id}</td>
                        <td>${p.nom}</td>
                        <td>${p.prix}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
