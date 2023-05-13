package controladores;

import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class CACliente extends IControlador implements Initializable {

    private TextField txtCorreoC;

    private PasswordField passContraseñaD;

    private PasswordField passRepContraseñaD;

    private TextField txtNombreD;

    private TextField txtApePaternoD;

    private TextField txtTelefonoD;

    private TextField txtCalleC;

    private TextField txtNumeroC;

    private TextField txtColoniaC;

    private TextField txtEstadoCD;

    private TextField txtCiudadCD;

    private TextField txtCodPostalCD;

    @Override
    public void configurarController(IControlador controller) {

    }

    @Override
    public void cerrarVentana() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
