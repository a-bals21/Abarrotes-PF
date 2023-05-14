/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registradores;

import elementos.Cliente;

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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int addCliente(Cliente c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int deleteCliente(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int updateCliente(String id, Cliente c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
