/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registradores;

import elementos.Articulo;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
            PreparedStatement stm = conn.prepareStatement(
                    "SELECT * FROM ARTICULOS WHERE id_articulo = ?"
            );
            stm.setString(1, id);
            ResultSet rs = stm.executeQuery();
            
            anArticulo = new Articulo(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getFloat(4),
                    rs.getFloat(5),
                    rs.getInt(6),
                    rs.getString(7)
            );
            
            conn.close();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        
        return anArticulo;
    }

    @Override
    public int addArticulo(Articulo a) {
        int status = -1;
        Connection conn = ConexionDB.getConexion();
        
        try {
            PreparedStatement pstm = conn.prepareStatement(
                    "INSERT INTO ARTICULOS(codigo_articulo, nombre_articulo, pPublico_articulo, pProveedor_articulo, existencias_articulo, categoria_articulo)"
                            + "VALUES (?,?,?,?,?,?)"
            );
            
            pstm.setString(1, a.getCodigo());
            pstm.setString(2, a.getNombre());
            pstm.setFloat(3, a.getPPublico());
            pstm.setFloat(4, a.getPProveedor());
            pstm.setInt(5, a.getExistencias());
            pstm.setString(6, a.getCategoria());
            
            status = pstm.executeUpdate();
            
            conn.close();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        
        return status;
    }

    @Override
    public int deleteArticulo(String id) {
        int status = -1;
        Connection conn = ConexionDB.getConexion();
        
        try {
            PreparedStatement pstm = conn.prepareStatement(
                    "DELETE FROM ARTICULOS WHERE id_articulo = ?"
            );
            pstm.setString(1, id);
            status = pstm.executeUpdate();
            
            conn.close();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        
        return status;
    }

    @Override
    public int updateArticulo(String id, Articulo a) {
        int status = -1;
        Connection conn = ConexionDB.getConexion();
        
        try {
            PreparedStatement pstm = conn.prepareStatement(
                    "UPDATE ARTICULOS SET "
                            + "codigo_articulo = ?, nombre_articulo = ?, pPublico_articulo = ?,"
                            + "pProveedor_articulo = ?, existencias_articulo = ?, categoria_articulo = ?"
                            + "WHERE id_cliente = ?"
            );
            
            pstm.setString(1, a.getCodigo());
            pstm.setString(2, a.getNombre());
            pstm.setFloat(3, a.getPPublico());
            pstm.setFloat(4, a.getPProveedor());
            pstm.setInt(5, a.getExistencias());
            pstm.setString(6, a.getCategoria());
            
            pstm.setString(7, id);
            
            status = pstm.executeUpdate();
            
            conn.close();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        
        return status;
    }
    
    public int updateStock(String id, int r) {
        int status = -1;
        Connection conn = ConexionDB.getConexion();
        
        try {
            PreparedStatement pstm = conn.prepareStatement(
                    "UPDATE ARTICULOS SET existencias_articulo = ?"
                            + "WHERE id_cliente = ?"
            );
            
            pstm.setInt(1, r);
            
            pstm.setString(2, id);
            
            status = pstm.executeUpdate();
            
            conn.close();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }        
        
        return status;
    }
    
    public int searchArticulo(Articulo a) {
        int id = -1;
        
        Connection conn = ConexionDB.getConexion();
        
        try{
            PreparedStatement pstm = conn.prepareStatement(
                    "SELECT * FROM ARTICULOS WHERE codigo_articulo like ?"
            );
            
            pstm.setString(1, "%"+a.getCodigo()+"%");
            ResultSet rs = pstm.executeQuery();
            
            id = rs.getInt(1);
            
            conn.close();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        
        return id;
    }
    
    public ArrayList<Articulo> getArticulos(String where) {
        ArrayList<Articulo> articulos = new ArrayList<Articulo>();
        Connection conn = ConexionDB.getConexion();
        
        try{
            PreparedStatement stm = conn.prepareStatement(
                    "SELECT * FROM ARTICULOS WHERE " + where
            );
            ResultSet rs = stm.executeQuery();
                        
            while (rs.next()) {
                articulos.add(
                        new Articulo(
                                rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getFloat(4),
                                rs.getFloat(5),
                                rs.getInt(6),
                                rs.getString(7)
                                )
                );
            }
            
            conn.close();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        
        return articulos;
    }
}
