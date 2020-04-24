package api;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import modelo.bean.Producto;
import modelo.dao.ModeloProducto;

/**
 * Servlet implementation class ApiUpdateProducto
 */
@WebServlet("/ApiUpdateProducto")
public class ApiUpdateProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApiUpdateProducto() {
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
		request.setCharacterEncoding("UTF-8");
		String jsonProducto = request.getParameter("producto");
		
		System.out.println(jsonProducto);
		JSONObject jsonObject = new JSONObject(jsonProducto);
		
		Producto producto = new Producto();
		producto.setId(jsonObject.getInt("id"));
		producto.setNombre(jsonObject.getString("nombre"));
		producto.setStock(jsonObject.getInt("stock"));
		
		Date fecha = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			fecha= sdf.parse(jsonObject.getString("fechaCompra"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		producto.setFecha_compra(fecha);
		producto.setColor(jsonObject.getString("color"));
		producto.setMade_in(jsonObject.getString("madein"));
		producto.setPrecio(jsonObject.getDouble("precio"));
		producto.setDescuento(jsonObject.getInt("descuento"));
		producto.setTallas(jsonObject.getString("talla"));
		
		ModeloProducto mProducto = new ModeloProducto();
		mProducto.update(producto);
		
		try {
			mProducto.getConexion().close();
		} catch (SQLException e) {
			System.out.println("Errorea konexioa iztean");
			e.printStackTrace();
		}
		response.setHeader("Access-Control_Allow-Origin", "*");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
	}

}
