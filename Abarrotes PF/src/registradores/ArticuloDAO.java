/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package registradores;

import elementos.Articulo;

/**
 *
 * @author Angel Balderas
 */
public interface ArticuloDAO {
    public Articulo getArticulo(String id);
    
    public int addArticulo(Articulo a);
    
    public int deleteArticulo(String id);
    
    public int updateArticulo(String id, Articulo a);
}
