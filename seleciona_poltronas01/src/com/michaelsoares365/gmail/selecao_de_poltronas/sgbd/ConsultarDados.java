package com.michaelsoares365.gmail.selecao_de_poltronas.sgbd;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultarDados {
    public static void main(String[]args)throws SQLException,IOException {
    	Connection conexao=ConnectionFactory.getConnection();
    	String sql="select *from pessoas where nome like ?";
    	PreparedStatement stmt=conexao.prepareStatement(sql);
    	stmt.setString(1,"%a%");
    	ResultSet res=stmt.executeQuery();
    	while(res.next()) {
    		System.out.println(res.getString("nome"));
    	}
    	stmt.close();
    	conexao.close();
    }
}
