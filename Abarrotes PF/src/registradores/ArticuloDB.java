/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registradores;

import elementos.Articulo;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Angel Balderas
 */
public class ArticuloDB implements ArticuloDAO {
    /* 
     * TABLA ARTICULOS
     * 1: id_articulo
     * 2: codigo_articulo
     * 3: nombre_articulo
     * 4: pPublico_articulo
     * 5: pProveedor_articulo
     * 6: existencias_articulo
     * 7: categoria_articulo
    */
    
    @Override
    public Articulo getArticulo(String id) {
        Articulo anArticulo = null;
        
        Connection conn = ConexionDB.getConexion();
        
        try{
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM ARTICULOS WHERE id_articulo = " + id);
            
            anArticulo = new Articulo(
                    rs.getString(2),
                    rs.getString(3),
                    rs.getFloat(4),
                    rs.getFloat(5),
                    rs.getInt(6),
                    rs.getString(7)
            );
            
            anArticulo.setId(rs.getInt(1));
            
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        
        return anArticulo;
    }

    @Override
    public int addArticulo(Articulo a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int deleteArticulo(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int updateArticulo(String id, Articulo a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public int updateStock(String id, int stock) {
        int status = -1;
        
        
        
        return status;
    }
    
    public int searchArticulo(Articulo a) {
        int status = -1;
        
        
        
        return status;
    }
    
    public ArrayList<Articulo> getArticulos(String where) {
        ArrayList<Articulo> articulos = null;
        
        return articulos;
    }
}
