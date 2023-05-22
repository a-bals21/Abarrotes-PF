package controladores;

import elementos.Cliente;
import elementos.Direccion;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import registradores.ClienteDB;

public class CRegistroDatos extends IControlador implements Initializable {
    @FXML
    private TextField txtfNombreCliente;
    @FXML
    private TextField txtfApellidoCliente;
    @FXML
    private TextField txtfTelefonoCliente;
    @FXML
    private TextField txtfCalleCliente;
    @FXML
    private TextField txtfNumCliente;
    @FXML
    private TextField txtfColoniaCliente;
    @FXML
    private TextField txtfEstadoCliente;
    @FXML
    private TextField txtfCiudadCliente;
    @FXML
    private TextField txtfCPCliente;
    @FXML
    private Tab tabDatos;
    @FXML
    private Tab tabCalle;
    @FXML
    private Tab tabCiudad;
    @FXML
    private Button btnCancelar;

    @Override
    public void configurarController(IControlador controller) {
        
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
            Stage currentStage = (Stage) btnCancelar.getScene().getWindow();
            currentStage.close();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    private void siguiente(ActionEvent event) {
        if(tabDatos.isSelected()) {
            tabDatos.getTabPane().getSelectionModel().select(tabCalle);
        } else {
            tabCalle.getTabPane().getSelectionModel().select(tabCiudad);
        }
    }

    @FXML
    private void registrarCliente(ActionEvent event) {
        String nombre = txtfNombreCliente.getText();
        String apellido = txtfApellidoCliente.getText();
        String telefono = txtfTelefonoCliente.getText();
        String calle = txtfCalleCliente.getText();
        String numero = txtfNumCliente.getText();
        String colonia = txtfColoniaCliente.getText();
        String estado = txtfEstadoCliente.getText();
        String ciudad = txtfCiudadCliente.getText();
        String codigoPostal = txtfCPCliente.getText();
        
        if(
                nombre.isEmpty() || apellido.isEmpty() || telefono.isEmpty() || calle.isEmpty() ||
                numero.isEmpty() || colonia.isEmpty() || estado.isEmpty() || ciudad.isEmpty() || codigoPostal.isEmpty()
                ) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);

            alerta.setTitle("Datos incompletos");
            alerta.setHeaderText("Llene todos los campos de texto");

            alerta.showAndWait();
            
            return;
        }
        
        if (!telefono.matches("\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d")) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            
            alerta.setTitle("Número telefónico");
            alerta.setHeaderText("El numero telefonico insertado no es válido");
            
            alerta.showAndWait();
            
            return;
        }
        
        if (!numero.matches("\\d+")) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            
            alerta.setTitle("Número");
            alerta.setHeaderText("El numero insertado no es válido");
            
            alerta.showAndWait();
            
            return;
        }
        
        if (!codigoPostal.matches("\\d\\d\\d\\d\\d")) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            
            alerta.setTitle("Código Postal");
            alerta.setHeaderText("El código postal ingresado no es válido");
            
            alerta.showAndWait();
            
            return;
        }
        
        ClienteDB db = new ClienteDB();
        
        Cliente aCliente = new Cliente(
                usuario.getCorreo(),
                usuario.getPassword(),
                nombre,
                apellido,
                new Direccion(
                        calle,
                        numero,
                        colonia,
                        codigoPostal,
                        ciudad,
                        estado,
                        telefono
                    )
            );
        
        db.addCliente(aCliente);
        
        Alert alerta = new Alert(Alert.AlertType.WARNING);
            
        alerta.setTitle("Registro Completado");
        alerta.setHeaderText("El registro del cliente ha sido completado");

        alerta.showAndWait();
        
        irA("/ventanas/VLogin.fxml", false);
        Stage currentStage = (Stage) btnCancelar.getScene().getWindow();
        currentStage.close();
    }
}
