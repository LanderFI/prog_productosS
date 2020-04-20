package controladores;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.Producto;
import modelo.dao.ModeloProducto;

/**
 * Servlet implementation class InsertarProducto
 */
@WebServlet("/InsertarProducto")
public class InsertarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloProducto mProducto = new ModeloProducto(); // crear un ojbeto de la clase Modelo Producto
		// Recuperar mediante request.getParameter los valores del formulario
		Date fecha = null;
		String nombre=request.getParameter("nombre");

		String stockS = request.getParameter("stock");
		int stock=Integer.parseInt(stockS);

		String fechaString = request.getParameter("fechaCompra");
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			fecha = formato.parse(fechaString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String color=request.getParameter("color");
		String made_in=request.getParameter("madein");
		String precioS = request.getParameter("precio");
		Double precio=Double.parseDouble(precioS);
		String descuentoS = request.getParameter("descuento");
		int descuento=Integer.parseInt(descuentoS);

		String[] tallas = request.getParameterValues("talla");
		

		// crear un producto con los datos del formulario
		Producto producto=new Producto();
		producto.setNombre(nombre);
		producto.setStock(stock);
		   producto.setFecha_compra(fecha);
		   producto.setColor(color);
		   producto.setMade_in(made_in);
		   producto.setPrecio(precio);
		   producto.setDescuento(descuento);
		   producto.setTallas(tallas);      
		 
		   //insertar producto
		mProducto.insert(producto);
		
		response.sendRedirect("VerProductos");
	}

}