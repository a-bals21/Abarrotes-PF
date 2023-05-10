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

/**
 * FXML Controller class
 *
 * @author Angel Balderas
 */
public class CRArticulos implements Initializable {

    @FXML
    private TextField txtfNombreArt;
    @FXML
    private TextField txtfPrecioPublico;
    @FXML
    private TextField txtfPrecioProveedor;
    @FXML
    private TextField txtfCantTotal;
    @FXML
    private ComboBox cboxCategoria;
    @FXML
    private TextField txtfCodigoArt;
    @FXML
    private Button btnRegistrarArt;
    @FXML
    private Button btnVolverArt;
    @FXML
    private TextField txtfBuscarArt;
    @FXML
    private Button btnActualizarArt;
    @FXML
    private Button btnEliminarArt;
    @FXML
    private Tab tabArticulos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
