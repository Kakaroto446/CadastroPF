package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.PessoaFisica;

public class select {
		
		private Connection conn;		//cria o objeto para a conexao
			
		public select(Connection conn) {		//metodo construtor que recebe a conexao
			this.conn = conn;		//faz com que esse objeto local receba a conexao que está sendo usada
		}
		
		public int contar() throws SQLException{
			int c = 0;	
			String sql = "select COUNT(*) as contador from pf";
			Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(sql);
	         while(rs.next()) {
	        	 c = rs.getInt("contador");
	         }
	         
			stmt.close();
			return c;
		}
		
		public String[][] select(int contador) throws SQLException{
			int d = 0;
			String[][] a = new String[contador][11];
			PessoaFisica pf = new PessoaFisica();
			String sql = "select nome,endereco,cidade,bairro,telefone,rg,sexo,cep,estado,celular,cpf from pf;";		
			Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(sql);
	         while(rs.next()) {
	        	 a[d][0] = rs.getString("nome");
	        	 a[d][1] = rs.getString("endereco");
	        	 a[d][2] = rs.getString("cidade");
	        	 a[d][3] = rs.getString("bairro");
	        	 a[d][4] = rs.getString("telefone");
	        	 a[d][5] = rs.getString("rg");
	        	 a[d][6] = rs.getString("sexo");   
	        	 a[d][7] = rs.getString("cep");
	        	 a[d][8] = rs.getString("estado");
	        	 a[d][9] = rs.getString("celular");
	        	 a[d][10] = rs.getString("cpf");
	        	 d++;
	         }

	         
			stmt.close();
			return a;
		}
		
	}


