/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package elementos;

/**
 *
 * @author Angel Balderas
 */
public class Direccion {
    private String calle;
    private String numero;
    private String colonia;
    private String codigoPostal;
    private String ciudad;
    private String estado;
    private String telefono;
    
    public Direccion(String c, String n, String col, String cp, String ciu, String edo, String tel) {
        this.calle = c;
        this.numero = n;
        this.colonia = col;
        this.codigoPostal = cp;
        this.ciudad = ciu;
        this.estado = edo;
        this.telefono = tel;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String c) {
        this.calle = c;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String n) {
        this.numero = n;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String col) {
        this.colonia = col;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String cp) {
        this.codigoPostal = cp;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciu) {
        this.ciudad = ciu;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String edo) {
        this.estado = edo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String tel) {
        this.telefono = tel;
    }
    
    
}
