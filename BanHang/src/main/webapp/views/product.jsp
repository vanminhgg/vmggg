<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
  <!-- Site meta -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Free Bootstrap 4 Ecommerce Template</title>
  <!-- CSS -->
  <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" type="text/css">
  <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <link href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600" rel="stylesheet" type="text/css">
  <link href="<c:url value="/templates/css/style.css"/>" rel="stylesheet" type="text/css">
</head>
<body>

<%--Header--%>
 <%@include file="header.jsp"%>
<%--Endheader--%>
<%--<section class="jumbotron text-center">--%>
<%--  <div class="container">--%>
<%--    <h1 class="jumbotron-heading">E-COMMERCE CATEGORY</h1>--%>
<%--    <p class="lead text-muted mb-0">Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression. Le Lorem Ipsum est le faux texte standard de l'imprimerie depuis les années 1500, quand un peintre anonyme assembla ensemble des morceaux de texte pour réaliser un livre spécimen de polices de texte...</p>--%>
<%--  </div>--%>
<%--</section>--%>
<div class="container">
  <div class="row">
    <div class="col">
      <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="index.html">Home</a></li>
          <li class="breadcrumb-item"><a href="category.html">Category</a></li>
          <li class="breadcrumb-item active" aria-current="page">Sub</li>
        </ol>
      </nav>
    </div>
  </div>
</div>
<div class="container">
  <div class="row">
    <div class="col-12 col-sm-3">
      <div class="card bg-light mb-3">
        <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
        <ul class="list-group category_block">
          <c:forEach items="${listcategory}" var="lc">
          <li class="list-group-item ${tagactive==lc.id ? "active":""}"><a class="text-dark" href="product?cid=${lc.id}">${lc.icon} ${lc.name}</a></li>
          </c:forEach>
        </ul>
      </div>
      <div class="card bg-light mb-3">
        <div class="card-header bg-success text-white text-uppercase">Last product</div>
        <c:forEach items="${lastproduct}" var="lp">
        <div class="card-body">
          <img class="img-fluid" src="${lp.image}" />
          <h5 class="card-title">${lp.name}</h5>
          <p class="card-text">${lp.description}</p>
          <p class="bloc_left_price">${lp.price} $</p>
        </div>
        </c:forEach>
      </div>
    </div>
    <div class="col">
      <div class="row">
        <c:forEach items="${listPCbyCID}" var="lap">
        <div class="col-12 col-md-6 col-lg-4">
          <div class="card">
            <img class="card-img-top" src="${lap.image}" alt="${lap.name}">
            <div class="card-body">
              <h4 class="card-title"><a href="productdetail?pid=${lap.id}" title="View Product">${lap.name}</a></h4>
              <p class="card-text">${lap.description}</p>
              <div class="row">
                <div class="col">
                  <p class="btn btn-danger btn-block">${lap.price} $</p>
                </div>
                <div class="col">
                  <a href="#" class="btn btn-success btn-block">Add to cart</a>
                </div>
              </div>
            </div>
          </div>
        </div>
        </c:forEach>
        <div class="col-12">
          <nav aria-label="...">
            <ul class="pagination">
              <li class="page-item disabled">
                <a class="page-link" href="#" tabindex="-1">Previous</a>
              </li>
              <li class="page-item"><a class="page-link" href="#">1</a></li>
              <li class="page-item active">
                <a class="page-link" href="#">2 <span class="sr-only">(current)</span></a>
              </li>
              <li class="page-item"><a class="page-link" href="#">3</a></li>
              <li class="page-item">
                <a class="page-link" href="#">Next</a>
              </li>
            </ul>
          </nav>
        </div>
      </div>
    </div>

  </div>
</div>

<!-- Footer -->
<%@include file="footer.jsp"%>

<!-- JS -->
<script src="//code.jquery.com/jquery-3.2.1.slim.min.js" type="text/javascript"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" type="text/javascript"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" type="text/javascript"></script>

</body>
</html>

