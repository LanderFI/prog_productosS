package modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Conector;
import modelo.bean.Descuento;

public class ModeloDescuento extends Conector{
	
	public ArrayList<Descuento> getAll(){
		
		ArrayList<Descuento> descuentos = new ArrayList<Descuento>();
		
		try {
			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from descuentos");
			while(rs.next()) {
				Descuento descuento = new Descuento();
				descuento.setId(rs.getInt("id"));
				descuento.setValor(rs.getInt("valor"));
				descuento.setDescripcion("descripcion");
				
				descuentos.add(descuento);
			}
			return descuentos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return descuentos;
	}

}
