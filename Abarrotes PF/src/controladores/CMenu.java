/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;

import elementos.Cliente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Angel Balderas
 */
public class CMenu extends IControlador implements Initializable {

    @FXML
    private Button btnVolverMenu;
    @FXML
    private Label lNombreCliente;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    

    @Override
    public void configurarController(IControlador controller) {
        if(controller.getClass().equals(CACliente.class)) {
            ((CACliente) controller).colocarCorreo();
            ((CACliente) controller).colocarDatos();
        } else {
        }
    }

    @Override
    @FXML
    public void cerrarVentana() {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);

        alerta.setTitle("Salir");
        alerta.setHeaderText("¿Desea salir?");

        alerta.showAndWait();
        if (alerta.getResult().equals(ButtonType.OK)) {
            irA("/ventanas/VLogin.fxml", false);
            
            Stage currentStage = (Stage) btnVolverMenu.getScene().getWindow();
            currentStage.close();
        }
    }

    @FXML
    private void actualizarCliente(MouseEvent event) {
        irA("/ventanas/VACliente.fxml", false);
        
        Stage currentStage = (Stage) btnVolverMenu.getScene().getWindow();
        currentStage.close();
    }

    @FXML
    private void hacerCompra(MouseEvent event) {
        irA("/ventanas/VCompra.fxml", false);
        
        Stage currentStage = (Stage) btnVolverMenu.getScene().getWindow();
        currentStage.close();
    }
    
    public void colocarNombre() {
        lNombreCliente.setText(
                ((Cliente) usuario).getNombre() + " " +
                ((Cliente) usuario).getApellidoP()
        );
    }
}
