<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%@include file="header.jsp"%>
	<p></p>
	<div class="container">
		<div class="card">
			<div class="card-header">Modification des Produits</div>
			<div class="card-body">
				<form action="update.do" method="post">
					<div hidden class="form-group">
						<label class="control-label">ID Produit :</label> <input
							type="text" name="id" class="form-control"
							value="${produit.id}" />
					</div>
					<div class="form-group">
						<label class="control-label">Nom Produit :</label> <input
							type="text" name="nom" class="form-control"
							value="${produit.nom}" />
					</div>
					<div class="form-group">
						<label class="control-label">Prix :</label> <input type="text"
							name="prix" class="form-control" value="${produit.prix}" />
					</div>
					<div>
						<button type="submit" class="btn btn-primary">Modifier</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>