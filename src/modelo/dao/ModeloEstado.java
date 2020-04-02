package modelo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Conector;
import modelo.bean.Estado;

public class ModeloEstado extends Conector{
	
	public ArrayList<Estado> getAll(){
		ArrayList<Estado> estados = new ArrayList<Estado>();
		
		try {
			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from estados");
			while(rs.next()) {
				Estado estado = new Estado();
				estado.setId(rs.getInt("id"));
				estado.setName("name");
				estado.setContinent("continent");
				
				estados.add(estado);
			}
			return estados;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return estados;
	}

}
