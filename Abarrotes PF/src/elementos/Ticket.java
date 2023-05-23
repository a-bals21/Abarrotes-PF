/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package elementos;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Angel Balderas
 */
public class Ticket {
    ArrayList<Articulo> listaArticulos;
    Usuario usuario;
    Date fecha;
    double totalCompras;
    
    public Ticket(ArrayList<Articulo> lista, double total, Usuario u) {
        this.listaArticulos = lista;
        this.totalCompras = total;
        this.usuario = u;
        this.fecha = new Date();
    }

    public ArrayList<Articulo> getListaArticulos() {
        return listaArticulos;
    }

    public void setListaArticulos(ArrayList<Articulo> listaArticulos) {
        this.listaArticulos = listaArticulos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotalCompras() {
        return totalCompras;
    }

    public void setTotalCompras(double totalCompras) {
        this.totalCompras = totalCompras;
    }
    
    
}
