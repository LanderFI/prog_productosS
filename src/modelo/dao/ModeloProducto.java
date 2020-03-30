package modelo.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.bean.Producto;
import modelo.bean.Talla;
import modelo.Conector;

public class ModeloProducto extends Conector {

	public ArrayList<Producto> selectAll(){
		ArrayList<Producto> productos = new ArrayList<Producto>();
		
		try {
			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from productos");
			while(rs.next()) {
				Producto producto = new Producto();
				producto.setId(rs.getInt("id"));
				producto.setNombre(rs.getString("nombre"));
				producto.setStock(rs.getInt("stock"));
				producto.setFecha_compra(rs.getDate("fecha_compra"));
				producto.setColor(rs.getString("color"));
				producto.setMade_in(rs.getString("made_in"));
				producto.setPrecio(rs.getDouble("precio"));
				producto.setDescuento(rs.getInt("descuento"));
				producto.setTallas(rs.getString("tallas"));
				
				productos.add(producto);
			}
			return productos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return productos;
	
		
	}
	
	public Producto get(int id) {
		PreparedStatement pst;
		
		try {
			pst = super.conexion.prepareStatement("select * from productos where id= ? ");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				Producto producto = new Producto();
				producto.setId(rs.getInt("id"));
				producto.setNombre(rs.getString("nombre"));
				producto.setStock(rs.getInt("stock"));
				producto.setFecha_compra(rs.getDate("fecha_compra"));
				producto.setColor(rs.getString("color"));
				producto.setMade_in(rs.getString("made_in"));
				producto.setPrecio(rs.getDouble("precio"));
				producto.setDescuento(rs.getInt("descuento"));
				producto.setTallas(rs.getString("tallas"));
				
				return producto;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void insert(Producto producto) {
		//TODO implementar
	}
	
	public void update(Producto producto) {
		//TODO implementar
	}
	
	public void delete(int id) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("DELETE FROM productos WHERE id = ? ");
			pst.setInt(1, id);
			pst.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Producto> deLaTalla(Talla talla){
		//TODO implementar, un poco mas dificil
		return null;
	}
}
