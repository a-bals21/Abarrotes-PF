/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Angel Balderas
 */
public class CLogin extends IControlador implements Initializable {

    // menos ingeniero
    @FXML
    private TextField txtfCorreoI;
    @FXML
    private PasswordField txtfPasswordI;
    @FXML
    private TextField txtfCorreoR;
    @FXML
    private PasswordField txtfPasswordR;
    @FXML
    private PasswordField txtfPasswordRR;
    @FXML
    private Tab tabIngresa;
    @FXML
    private Tab TabRegistra;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @Override
    public void cerrarVentana() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void configurarController(IControlador controller) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
