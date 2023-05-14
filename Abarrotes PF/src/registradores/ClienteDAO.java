/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package registradores;

import elementos.Cliente;

/**
 *
 * @author Angel Balderas
 */
public interface ClienteDAO {
    public Cliente getCliente(String correo);
    
    public int addCliente(Cliente c);
    
    public int deleteCliente(String id);
    
    public int updateCliente(String id, Cliente c);
}
