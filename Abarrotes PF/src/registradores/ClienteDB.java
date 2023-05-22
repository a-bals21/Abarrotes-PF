/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registradores;

import elementos.Cliente;
import elementos.Direccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Angel Balderas
 */
public class ClienteDB implements ClienteDAO {
    /* 
     * TABLA CLIENTES
     * 1: id_cliente
     * 2: nombre_cliente
     * 3: apellidoP_cliente
     * 4: correo_cliente
     * 5: password_cliente
    */
    
    /* 
     * TABLA DIRECCIONES
     * 1: id_direccion
     * 2: calle_direccion
     * 3: numero_direccion
     * 4: colonia_direccion
     * 5: codigoPostal_direccion
     * 6: ciudad_direccion
     * 7: estado_direccion
     * 8: telefono_direccion
     * 9: id_cliente
    */
    
    @Override
    public Cliente getCliente(String correo) {
        Cliente aCliente = null;
        Direccion itsDir = null;
        Connection conn = ConexionDB.getConexion();
        
        try{
            PreparedStatement pstm = conn.prepareStatement(
                    "SELECT * FROM CLIENTES WHERE correo_cliente = ?"
            );
            pstm.setString(1, correo);
            ResultSet rs = pstm.executeQuery();
            
            aCliente = new Cliente(
                    rs.getInt(1),       // ID del usuario
                    rs.getString(4),    // Correo del usuario
                    rs.getString(5),    // Contraseña del usuario
                    rs.getString(2),    // Nombre del usuario
                    rs.getString(3)   // Apellido paterno del usuario
            );
            
            
            // Solicitud de direccion del usuario
            
            pstm = conn.prepareStatement(
                    "SELECT * FROM DIRECCIONES WHERE id_cliente = ?"
            );
            pstm.setInt(1, aCliente.getId());
            rs = pstm.executeQuery();
            
            itsDir = new Direccion(
                    rs.getString(2),    // Calle
                    rs.getString(3),    // Número
                    rs.getString(4),    // Colonia
                    rs.getString(5),    // Codigo Postal
                    rs.getString(6),    // Ciudad
                    rs.getString(7),    // Estado
                    rs.getString(8)     // Telefono
            );
            
            aCliente.setDireccion(itsDir);
            
            conn.close();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        
        return aCliente;
    }

    @Override
    public int addCliente(Cliente c) {
        int status = -1;
        Connection conn = ConexionDB.getConexion();
        
        try {
            PreparedStatement pstm = conn.prepareStatement(
                    "INSERT INTO CLIENTES(correo_cliente, password_cliente, nombre_cliente, apellidoP_cliente)"
                            + "VALUES (?,?,?,?)"
            );
            
            pstm.setString(1,c.getCorreo());
            pstm.setString(2,c.getPassword());
            pstm.setString(3,c.getNombre());
            pstm.setString(4,c.getApellidoP());
            
            status = pstm.executeUpdate();
            
            pstm = conn.prepareStatement(
                    "INSERT INTO DIRECCIONES(calle_direccion, numero_direccion, colonia_direccion, codigoPostal_direccion, ciudad_direccion, estado_direccion, telefono_direccion, id_cliente)"
                            + "VALUES (?,?,?,?,?,?,?,?)"
            );
            
            Direccion dir = c.getDireccion();
            
            pstm.setString(1,dir.getCalle());
            pstm.setString(2,dir.getNumero());
            pstm.setString(3,dir.getColonia());
            pstm.setString(4,dir.getCodigoPostal());
            pstm.setString(5,dir.getCiudad());
            pstm.setString(6,dir.getEstado());
            pstm.setString(7,dir.getTelefono());
            pstm.setInt(8,getCliente(c.getCorreo()).getId());
            
            pstm.executeUpdate();
            
            
            conn.close();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        
        return status;
    }

    @Override
    public int deleteCliente(String id) {
        int status = -1;
        Connection conn = ConexionDB.getConexion();
        
        try {
            PreparedStatement pstm = conn.prepareStatement(
                    "DELETE FROM CLIENTES WHERE id_cliente = ?"
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
    public int updateCliente(String id, Cliente c) {
        int status = -1;
        Connection conn = ConexionDB.getConexion();
        
        try {
            PreparedStatement pstm = conn.prepareStatement(
                    "UPDATE CLIENTES SET "
                            + "nombre_cliente = ?, apellidoP_cliente = ?, correo_cliente = ?, password_cliente = ?"
                            + "WHERE id_cliente = ?"
            );
            
            pstm.setString(1, c.getNombre());
            pstm.setString(2, c.getApellidoP());
            pstm.setString(3, c.getCorreo());
            pstm.setString(4, c.getPassword());
            
            pstm.setString(5, id);
            
            status = pstm.executeUpdate();
            
            pstm = conn.prepareStatement(
                    "UPDATE DIRECCIONES SET "
                            + "calle_direccion = ?, numero_direccion = ?, colonia_direccion = ?,"
                            + "codigoPostal_direccion = ?, ciudad_direccion = ?, estado_direccion = ?,"
                            + "telefono_direccion = ?"
                            + "WHERE id_cliente = ?"
            );
            
            Direccion dir = c.getDireccion();
            
            pstm.setString(1, dir.getCalle());
            pstm.setString(2, dir.getNumero());
            pstm.setString(3, dir.getColonia());
            pstm.setString(4, dir.getCodigoPostal());
            pstm.setString(5, dir.getCiudad());
            pstm.setString(6, dir.getEstado());
            pstm.setString(7, dir.getTelefono());
            
            pstm.setString(8, id);
            
            pstm.executeUpdate();
            
            conn.close();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        
        return status;
    }
}
