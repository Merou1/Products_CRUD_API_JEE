<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Insert title here</title>
<link href="bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%@include file="header.jsp"%>
	<p></p>
	<div class="container">
		<div class="card">
			<div class="card-header">Recherche des Produits</div>
			<div class="card-body">
				<form action="chercher.do" method="get">
					<label>Mot Clé</label> <input type="text" name="motCle"
						value="${model.motCle}" />
					<button type="submit" class="btn btn-primary">Chercher</button>
				</form>
				<table class="table table-striped">
					<tr>
						<th>ID</th>
						<th>Nom Produit</th>
						<th>Prix</th>
					</tr>
					<c:forEach items="${model.products}" var="p">
						<tr>
							<td>${p.id}</td>
							<td>${p.nom}</td>
							<td>${p.prix}</td>
							<td><a onclick="return confirm('Etes-vous sûr ?')"
								href="supprimer.do?id=${p.id }">Supprimer</a></td>
							<td><a href="editer.do?id=${p.id }">Edit</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
