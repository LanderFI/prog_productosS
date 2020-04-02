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
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		int stock = Integer.parseInt(request.getParameter("stock"));
		Date fecha_compra = null;
		
		String color = request.getParameter("color");
		String made_in = request.getParameter("made_in");
		Double precio = Double.parseDouble(request.getParameter("precio"));
		int descuento = Integer.parseInt(request.getParameter("descuento"));
		String tallas = request.getParameter("tallas");
		
		
		Producto producto = new Producto();
		
		producto.setNombre(nombre);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			fecha_compra = sdf.parse(request.getParameter("fecha_compra"));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		
		producto.setFecha_compra(fecha_compra);
		producto.setStock(stock);
		producto.setColor(color);
		producto.setMade_in(made_in);
		producto.setPrecio(precio);
		producto.setDescuento(descuento);
		producto.setTallas(tallas);
		
		
		ModeloProducto mProducto = new ModeloProducto();
		
		mProducto.insert(producto);
		
		response.sendRedirect("VerProductos");
		
	}

}
