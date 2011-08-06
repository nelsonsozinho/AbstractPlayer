package br.com.abstractlayer.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe especifica para fazer a migracao 
 * 
 * @author Nelson
 *
 */
public class MigrateMunicipiosAccess2Mysql {
	
	public List<Map<String, String>> doIt() {
		System.out.println("Iniciando leitura");
		List<Map<String, String>> valores = new ArrayList<Map<String,String>>();
		
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:odbc:ibge");
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("select * from municipio_ibge");
			while(rs.next()) {
				Map<String,String> linha = new HashMap<String, String>();
				//System.out.println(rs.getString("codigo"));
				//System.out.println(rs.getString("cidade"));
				//System.out.println(rs.getString("estado"));
				//System.out.println(rs.getString("uf"));
				linha.put("id", rs.getString("codigo"));
				linha.put("cidade", rs.getString("cidade"));
				linha.put("estado", rs.getString("estado"));
				linha.put("uf", rs.getString("uf"));
				valores.add(linha);
			}
			
			
			st.close();
			st.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return valores;
	}
	
	public void writeInMysql(List<Map<String, String>> valores) {
		System.out.println("Iniciando escrita");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {		
			e.printStackTrace();
		}
		
		Connection connection = null;
		PreparedStatement st = null;
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/commons_database","root","root");
			
			st = connection.prepareStatement("INSERT INTO MUNICIPIO_IBGE (CODIGO, CIDADE, ESTADO, UF) VALUES(?,?,?,?)");
			
			for(Map<String, String> linha : valores) {
				st.setInt(1, Integer.parseInt(linha.get("id")));
				st.setString(2, linha.get("cidade"));
				st.setString(3, linha.get("estado"));
				st.setString(4, linha.get("uf"));
				
				st.addBatch();
				st.clearParameters();
				
			}
			
			int[] updateCount = st.executeBatch();
			connection.commit();
			//connection.setAutoCommit(true);
			st.close();
			connection.close();
			
			System.out.println("Quntidade de atualizacoes: " + updateCount.length);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String ...strings) {
		MigrateMunicipiosAccess2Mysql exec = new MigrateMunicipiosAccess2Mysql();
		List<Map<String, String>> valores = exec.doIt();
		exec.writeInMysql(valores);
		System.out.println("Operacao OK");
	}

}
