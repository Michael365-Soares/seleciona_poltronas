package com.michaelsoares365.gmail.selecao_de_poltronas.sgbd;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class ConnectionFactory {
	
	public static Connection getConnection()throws SQLException,IOException {
		Properties prop=getProperties();
		String url=prop.getProperty("banco.url");
		String usuario=prop.getProperty("banco.usuario");
		String senha=prop.getProperty("banco.senha");
		return DriverManager.getConnection(url,usuario,senha);
	}
	
	
    private static Properties getProperties() throws IOException  {
    	Properties prop=new Properties();
    	FileInputStream file=new FileInputStream("C://Users//micha//Documents//conexao.properties");
    	prop.load(file);
    	return prop;
    }
}
