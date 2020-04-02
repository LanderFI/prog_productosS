package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Conector;
import modelo.bean.Talla;

public class ModeloTalla extends Conector{
	
	public ArrayList<Talla> getAll(){
		ArrayList<Talla> tallas = new ArrayList<Talla>();
		
		try {
			PreparedStatement pst = super.conexion.prepareStatement("select * from tallas");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Talla talla = new Talla();
				talla.setId(rs.getInt("id"));
				talla.setNombre(rs.getString("nombre"));
				
				tallas.add(talla);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tallas;
	}
}
