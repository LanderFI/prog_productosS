package modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Conector;
import modelo.bean.Talla;

public class ModeloTalla extends Conector{
	
	public ArrayList<Talla> getAll(){
		ArrayList<Talla> tallas = new ArrayList<Talla>();
		
		try {
			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from tallas");
			while(rs.next()) {
				Talla talla = new Talla();
				talla.setId(rs.getInt("id"));
				talla.setNombre("nombre");
				
				tallas.add(talla);
			}
			return tallas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tallas;
	}
}
