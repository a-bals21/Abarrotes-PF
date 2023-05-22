package controladores;

import elementos.Cliente;
import elementos.Direccion;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import registradores.ClienteDB;

public class CACliente extends IControlador implements Initializable {
    
    @FXML
    private javafx.scene.control.Button btnActualizar;
    @FXML
    private javafx.scene.control.Label lcorreo;
    @FXML
    private javafx.scene.control.TextField txtCorreo;
    @FXML
    private PasswordField txtPass;
    @FXML
    private PasswordField txtPassR;
    @FXML
    private javafx.scene.control.TextField txtNombre;
    @FXML
    private javafx.scene.control.TextField txtApellidoP;
    @FXML
    private javafx.scene.control.TextField txtTelefono;
    @FXML
    private javafx.scene.control.TextField txtCalle;
    @FXML
    private javafx.scene.control.TextField txtNumero;
    @FXML
    private javafx.scene.control.TextField txtColonia;
    @FXML
    private javafx.scene.control.TextField txtEstado;
    @FXML
    private javafx.scene.control.TextField txtCiudad;
    @FXML
    private javafx.scene.control.TextField txtCodigoPostal;

    @Override
    public void configurarController(IControlador controller) {
        ((CMenu) controller).colocarNombre();
    }

    @Override
    @FXML
    public void cerrarVentana() {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);

        alerta.setTitle("Salir");
        alerta.setHeaderText("¿Desea salir?");

        alerta.showAndWait();
        if (alerta.getResult().equals(ButtonType.OK)) {
            irA("/ventanas/VCMenu.fxml", false);
            Stage currentStage = (Stage) btnActualizar.getScene().getWindow();
            currentStage.close();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    
    public void colocarCorreo() {
        lcorreo.setText(usuario.getCorreo());
    }

    @FXML
    private void actualizarCliente(ActionEvent event) {
        String nombre = txtNombre.getText();
        String apellido = txtApellidoP.getText();
        String correo = txtCorreo.getText();
        String pass = txtPass.getText();
        String passR = txtPassR.getText();
        String telefono = txtTelefono.getText();
        String calle = txtCalle.getText();
        String numero = txtNumero.getText();
        String colonia = txtColonia.getText();
        String estado = txtEstado.getText();
        String ciudad = txtCiudad.getText();
        String codigoPostal = txtCodigoPostal.getText();
        
        if (validarUsuario(correo) && !usuario.getCorreo().equals(correo)) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);

            alerta.setTitle("Datos existentes");
            alerta.setHeaderText("Este correo ya esta registrado");

            alerta.showAndWait();
            return;
        }
        
        if(!pass.equals(passR)) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);

            alerta.setTitle("Datos incorrectos");
            alerta.setHeaderText("Las contraseñas no coinciden");

            alerta.showAndWait();
            return;
        }
        
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
                correo,
                pass,
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
        
        db.updateCliente(String.valueOf(usuario.getId()), aCliente);
        usuario = aCliente;
        
        Alert alerta = new Alert(Alert.AlertType.WARNING);
            
        alerta.setTitle("Información actualizada");
        alerta.setHeaderText("Su información ha sido actualizado");

        alerta.showAndWait();
    }
    
    public void colocarDatos() {
        Cliente c = (Cliente) usuario;
        Direccion d = c.getDireccion();
        
        txtNombre.setText(c.getNombre());
        txtApellidoP.setText(c.getApellidoP());
        txtCorreo.setText(c.getCorreo());
        txtPass.setText(c.getPassword());
        txtTelefono.setText(d.getTelefono());
        txtCalle.setText(d.getCalle());
        txtNumero.setText(d.getNumero());
        txtColonia.setText(d.getColonia());
        txtEstado.setText(d.getEstado());
        txtCiudad.setText(d.getCiudad());
        txtCodigoPostal.setText(d.getCodigoPostal());
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
