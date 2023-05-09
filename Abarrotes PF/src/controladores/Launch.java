/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package controladores;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Angel Balderas
 */
public class Launch extends Application {
    Parent root = null;
    Scene escena = null;
    
    //Se ejecuta al intanciarse la escena (Configuración inicial)
    @Override
    public void init() {
        
    }
    
    /**
     * Inicia la escena principal, el Login
     * @param primaryStage 
     */
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ventanas/VLogin.fxml"));
            root = loader.load();

            escena = new Scene(root);

            primaryStage.setScene(escena);
            primaryStage.setTitle("Abarrotes");
            primaryStage.setMaximized(false);
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(Launch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Al cerrar la aplicación (Para terminar procesos)
    @Override
    public void stop() {
        System.out.println("Cerrando Programa");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
