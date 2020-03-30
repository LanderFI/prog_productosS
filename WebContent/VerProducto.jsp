<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Producto</title>
  </head>
  <body>
    <table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Nombre</th>
      <th scope="col">Stock</th>
      <th scope="col">Fecha de compra</th>
      <th scope="col">Color</th>
      <th scope="col">Made in</th>
      <th scope="col">Precio</th>
      <th scope="col">Descuento</th>
      <th scope="col">Tallas</th>
      <th scope="col"><a href="VerProductos" class="btn btn-warning">Volver</a></th>
    </tr>
  </thead>
  <tbody>
  
    <tr>
      <th scope="row">${producto.getId() }</th>
     	<td>${producto.getNombre()}</td>
     	<td>${producto.getStock() }</td>
     	<td>${producto.getFecha_compra()}</td>
      	<td>${producto.getColor() }</td>
      	<td>${producto.getMade_in() }</td>
      	<td>${producto.getPrecio()}</td>
      	<td>${producto.getDescuento()}</td>
      	<td>${producto.getTallas()}</td>
    </tr>
    
   
    </tbody>
</table>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  </body>
</html>