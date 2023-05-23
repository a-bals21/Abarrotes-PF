/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registradores;

import elementos.Articulo;
import elementos.Cliente;
import elementos.Ticket;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Angel Balderas
 */
public class GuardadorTicket {

    private final String INFO_TIENDA = "ABARROTES TIZIMIN\nEn la calle XX entre calles XX y XX";
    private final String PATH = ".\\archivos\\";
    private Ticket ticket;

    public GuardadorTicket(Ticket t) {
        this.ticket = t;
    }

    public void setTicket(Ticket t) {
        this.ticket = t;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public boolean generarPDF() {
        boolean mayGen = false;
        
        System.out.println("Generando ticket (archivo)");
        
        File file = new File(PATH + "ticket.txt");
        
        try {
            file.createNewFile();
            
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write(INFO_TIENDA + "\n");
            
            bw.newLine();
            
            bw.write("CLIENTE: " + ((Cliente)ticket.getUsuario()).getNombre() + "\n");
            
            bw.newLine();
            
            bw.write("FECHA: "+ticket.getFecha().toString()+"\n");
            
            bw.newLine();
            
            bw.write("Producto Cant Precio Total\n");
            
            for (Articulo temp: ticket.getListaArticulos()) {
                bw.write(
                        (temp.getNombre().length() < 8 ? 
                                temp.getNombre() : 
                                temp.getNombre().substring(0, 7)) + "   " +
                                temp.getCantidad() + " $" +
                                temp.getPPublico()+ " $" +
                                (temp.getCantidad() * temp.getPPublico()) + "\n"
                        );
            }
            
            bw.newLine();
            
            bw.write("TOTAL: $" + ticket.getTotalCompras() + "\n\nGRACIAS POR SU COMPRA");
            
            bw.close();
            
            if (file.exists()) {
                mayGen = true;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return mayGen;
    }
}
