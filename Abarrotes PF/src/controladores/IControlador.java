/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package controladores;

import elementos.Usuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Angel Balderas
 */
public abstract class IControlador {

    private Usuario usuario = null;
    
    /**
     * Cambia la escena actual por la escena que se encuentre en {@code path},
     * llevando al usuario actual. El parametro {@code max} define si la siguiente ventana
     * estará maximizada
     * @param path direccion del FXML
     * @param max define si la ventana estará máximizada
     */
    public void irA(String path, Boolean max) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
            
            Parent root = loader.load();
            Scene escena = new Scene(root);
            Stage stage = new Stage();

            IControlador controlador = loader.getController();

            stage.setScene(escena);
            stage.setTitle("Abarrotes");
            stage.setMaximized(max);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();

            controlador.recibirUsuario(usuario);
            configurarController(controlador);
        } catch (IOException ex) {
            Logger.getLogger(IControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Cambia la escena actual por la escena que se encuentre en {@code path},
     * llevando al usuario actual.
     * @param path direccion del FXML
     */
    public void irA(String path) {
        irA(path, true);
    }
    
    /**
     * Cambia el {@code Usuario} actual por el que se recibe
     * @param u 
     */
    public void recibirUsuario(Usuario u) {
        this.usuario = u;
    }
    
    /**
     * Ejecuta metodos adicionales (si es que se agregan) que implementes en 
     * el {@code controller} al cual se vaya a mover
     * @param controller 
     */
    public abstract void configurarController(IControlador controller);
    
    /**
     * Implementar el tipo de "cerrar ventana" que tendrá la ventana actual.
     * Cerrar Programa o redireccion a otra ventana
     */
    public abstract void cerrarVentana();
}
