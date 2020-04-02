package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Conector;
import modelo.bean.Estado;

public class ModeloEstado extends Conector{
	
	public ArrayList<Estado> getAll(){
		ArrayList<Estado> estados = new ArrayList<Estado>();
		
		try {
			PreparedStatement pst = super.conexion.prepareStatement("select * from estados");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Estado estado = new Estado();
				estado.setId(rs.getInt("id"));
				estado.setName(rs.getString("name"));
				estado.setContinent(rs.getString("continent"));
				
				estados.add(estado);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return estados;
	}

}
