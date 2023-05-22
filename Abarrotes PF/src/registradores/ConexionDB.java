/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registradores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Angel Balderas
 */
public class ConexionDB {
    private static final String DRIVER = "jdbc:sqlite:";
    private static final String PATH = "./archivos/DB_Abarrotes.db";
    private static ConexionDB instance = new ConexionDB();
    
    private ConexionDB(){}
    
    public static Connection getConexion() {
        Connection conexion = null;
        
        try {
            conexion = DriverManager.getConnection(DRIVER+PATH);
        } catch(SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        
        return conexion;
    }
    
}
