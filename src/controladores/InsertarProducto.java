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
		
		
		Date fecha = null;
		String nombre = request.getParameter("nombre");
		String stockS = request.getParameter("stock");
		int stock = Integer.parseInt(stockS);
		String fecha_string = request.getParameter("fechaCompra");
		String color = request.getParameter("color");
		String made_in = request.getParameter("made_in");
		String precioS = request.getParameter("precio");
		Double precio = Double.parseDouble(precioS);
		int descuento = Integer.parseInt(request.getParameter("descuento"));
		String [] tallas = request.getParameterValues("talla");
		
		
		Producto producto = new Producto();
		
		producto.setNombre(nombre);
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			fecha = formato.parse(fecha_string);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		
		producto.setFecha_compra(fecha);
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
