package com.ya.connectionmanager;
import java.sql.Connection;

import java.sql.SQLException;

import java.sql.DriverManager;

	public class ConnectionManager {   
	private static final String URL = "jdbc:mysql://localhost:3306/Colegio";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "Umg$2024";
    
    public static Connection getConnection() {
        Connection conn = null;
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
            return conn;
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("No se encontró el controlador JDBC" + e.toString());
            return null;
        }
    }

}