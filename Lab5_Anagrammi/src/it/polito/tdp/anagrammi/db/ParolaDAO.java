package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.anagrammi.model.Parola;

public class ParolaDAO {

	public boolean getEsattezza(String parola) {
		// TODO Auto-generated method stub
		
		final String sql = "SELECT * FROM parola WHERE nome= ?";
		
		try {
			
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, parola);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				
				
				return true;
			}
			
			
			return false;
			
		}catch(SQLException e) {
			
			throw new RuntimeException();
		}
	}

}
