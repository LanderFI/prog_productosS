package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import modelo.Conector;
import modelo.bean.Descuento;

public class ModeloDescuento extends Conector{
	
	public ArrayList<Descuento> getAll(){
		
		ArrayList<Descuento> descuentos = new ArrayList<Descuento>();
		
		try {
			PreparedStatement pst = super.conexion.prepareStatement("select * from descuentos");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Descuento descuento = new Descuento();
				descuento.setId(rs.getInt("id"));
				descuento.setValor(rs.getInt("valor"));
				descuento.setDescripcion(rs.getString("descripcion"));
				
				descuentos.add(descuento);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return descuentos;
	}

}
