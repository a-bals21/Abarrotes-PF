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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Angel Balderas
 */
public class CLogin extends IControlador implements Initializable {
    @FXML
    private Button btnSalirI;
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
    private Tab tabRegistra;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @Override
    @FXML
    public void cerrarVentana() {        
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        
        alerta.setTitle("Salir");
        alerta.setHeaderText("¿Desea salir?");
        
        alerta.showAndWait();
        if(alerta.getResult().equals(ButtonType.OK)) {
            Stage currentStage = (Stage) btnSalirI.getScene().getWindow();
            currentStage.close();
        }
    }

    @Override
    public void configurarController(IControlador controller) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
