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
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
    integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

  <title>Nuevo producto</title>
</head>

<body>
  <div class="container my-3">
    <nav aria-label="breadcrumb">
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="Home">Home</a></li>
        <li class="breadcrumb-item"><a href="VerProductos">Productos</a></li>
        <li class="breadcrumb-item active" aria-current="page">Nuevo</li>
      </ol>
    </nav>
    <div class="row">
      <div class="col-8">
        <form action="InsertarProducto" method="POST">
          <div class="mb-3">
            <div class="form-group">
              <label for="nombre">Nombre</label>
              <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Inserta nombre del producto">
            </div>
          </div>

          <div class="mb-3">
            <div class="form-group">
              <label for="nombre">Stock</label>
              <input type="number" class="form-control" id="stock" name="stock" placeholder="Inserta el numero de stock">
            </div>
          </div>

          <div class="mb-3">
            <div class="form-group">
              <label for="fechaCompra">Fecha de compra</label>
              <input type="date" class="form-control" id="fechaCompra" name="fechaCompra">
            </div>
          </div>

          <div class="mb-3">
            <div class="form-group">
              <label for="color">Color</label>
              <input type="color" class="form-control" id="color" name="color">
            </div>
          </div>

          <div class="mb-3">
            <div class="form-group">
              <label for="madein">Made in</label>
              <select id="madein" name="madein" class="form-control">
                <option>Choose...</option>
                
               <c:forEach items="${estados}" var="estado">
               <option value="${estado.getName()}">${estado.getContinent() } : ${estado.getName()}</option>
               </c:forEach>
              </select>
            </div>
          </div>

          <div class="mb-3">
            <div class="form-group">
              <label for="precio">Precio</label>
              <!--el atributo step habilita los decimales en los inputs de tipo number-->
              <input type="number" class="form-control" id="precio" name="precio" placeholder="Inserta el precio" step="0.01">
            </div>
          </div>

         <div class="mb-3">
            Descuento
            <c:forEach items="${descuentos }" var="descuento">
	             <div class="form-check">
		              <input class="form-check-input" type="radio" name="descuento" id="descuento${descuento.getValor()}" value="${descuento.getValor()}">
		              <label class="form-check-label" for="descuento${descuento.getValor()}">
		                ${descuento.getDescripcion()}
		              </label>
	            </div>
            </c:forEach>
          
          </div>

          <div class="mb-3">
            <div class="">Tallas</div>
            <c:forEach items="${tallas}" var="talla">
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="checkbox" name="descuento" id="talla${talla.getNombre()}" value="${talla.getNombre()}">
              <label class="form-check-label" for="tallaS">
                ${talla.getNombre()}
              </label>
            </div>
            </c:forEach>

            <div class="form-check form-check-inline">
              <input class="form-check-input" type="checkbox" name="descuento" id="" value="">
              <label class="form-check-label" for="">
                Todos de la tabla descuentos
              </label>
            </div>
          </div>
          <button type="submit" class="btn btn-primary">Guardar</button>
          <div class="mt-2"><a href="VerProductos" class="btn btn-warning">Cancelar</a></div>
        </form>
      </div>
      <div class="col-4">
        espacio para mostrar otra informacion
      </div>

    </div>
    <!--row-->


  </div>
  <!--container-->



  <!-- Optional JavaScript -->
  <!-- jQuery first, then Popper.js, then Bootstrap JS -->
  <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
    integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
    crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
    integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
    crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
    integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
    crossorigin="anonymous"></script>
</body>

</html>