/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;

import elementos.Cliente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import registradores.ClienteDB;

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
        if (alerta.getResult().equals(ButtonType.OK)) {
            Stage currentStage = (Stage) btnSalirI.getScene().getWindow();
            currentStage.close();
        }
    }

    @Override
    public void configurarController(IControlador controller) {
        if(controller.getClass().equals(CMenu.class)) {
            ((CMenu) controller).colocarNombre();
        }
    }

    @FXML
    private void ingresar(ActionEvent event) {
        String correo = txtfCorreoI.getText();
        String pass = txtfPasswordI.getText();

        if (correo.isEmpty() || pass.isEmpty()) {
            return;
        }

        ClienteDB db = new ClienteDB();

        if (
                correo.equalsIgnoreCase("admin@abarrotes.com")
                && pass.equalsIgnoreCase("201980")) {
            irA("/ventanas/VCRegistroArticulos.fxml", false);
            
            Stage currentStage = (Stage) btnSalirI.getScene().getWindow();
            currentStage.close();
            return;
        }

        if (validarUsuario(correo)) {
            usuario = db.getCliente(correo);
            irA("/ventanas/VCMenu.fxml", false);

            Stage currentStage = (Stage) btnSalirI.getScene().getWindow();
            currentStage.close();
        } else {
            Alert alerta = new Alert(Alert.AlertType.WARNING);

            alerta.setTitle("Datos incorrectos");
            alerta.setHeaderText("Asegurese haber ingresado sus datos correctamente");

            alerta.showAndWait();
        }
    }

    @FXML
    private void continuarRegistro(ActionEvent event) {
        String correo = txtfCorreoR.getText();
        String pass = txtfPasswordR.getText();
        String rpass = txtfPasswordRR.getText();
        
        if (correo.isEmpty() || pass.isEmpty() || rpass.isEmpty()) return;
        
        if (validarUsuario(correo)) { // Correo ya registrado
            Alert alerta = new Alert(Alert.AlertType.WARNING);

            alerta.setTitle("Datos existentes");
            alerta.setHeaderText("Este correo ya esta registrado");

            alerta.showAndWait();
            return;
        }
        
        if (pass.equals(rpass)) {
            usuario = new Cliente(correo, pass, null, null, null);
            
            irA("/ventanas/VCRegistroDatos.fxml", false);
            
            Stage currentStage = (Stage) btnSalirI.getScene().getWindow();
            currentStage.close();
        } else { // Contraseñas no coinciden
            Alert alerta = new Alert(Alert.AlertType.WARNING);

            alerta.setTitle("Datos incorrectos");
            alerta.setHeaderText("Las contraseñas no coinciden");

            alerta.showAndWait();
        }
    }

    private boolean validarUsuario(String correo) {
        boolean exists = false;
        ClienteDB db = new ClienteDB();

        if (db.getCliente(correo).getNombre() != null) {
            exists = true;
        }

        return exists;
    }
}
