/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;

import elementos.Articulo;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import registradores.ArticuloDB;

/**
 * FXML Controller class
 *
 * @author Angel Balderas
 */
public class CRArticulos extends IControlador implements Initializable {

    private boolean estaRegistrando = true;
    private ArrayList<Articulo> articulos = new ArrayList<>();
    private Articulo articuloActualizar = null;
    @FXML
    private ChoiceBox<String> cboxCategoria;
    @FXML
    private Button btnVolverArt;
    @FXML
    private TableView<Articulo> tabArticulos;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtPPublico;
    @FXML
    private TextField txtPProveedor;
    @FXML
    private TextField txtExistencias;
    @FXML
    private TextField txtBuscar;
    @FXML
    private TextField txtCodigo;
    @FXML
    private TableColumn<?, ?> colCodigo;
    @FXML
    private TableColumn<?, ?> colNombre;
    @FXML
    private TableColumn<?, ?> colPrecio;
    @FXML
    private TableColumn<?, ?> colExistencias;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cboxCategoria.getItems().addAll(
                "S/C",
                "LIMPIEZA",
                "BOTANA",
                "COMIDA",
                "FRUTA/VERDURA",
                "BEBIDA"
        );

        cboxCategoria.getSelectionModel().select("S/C");

        this.colCodigo.setCellValueFactory(new PropertyValueFactory("codigo"));
        this.colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colPrecio.setCellValueFactory(new PropertyValueFactory("pPublico"));
        this.colExistencias.setCellValueFactory(new PropertyValueFactory("existencias"));
    }

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
            Stage currentStage = (Stage) btnVolverArt.getScene().getWindow();
            currentStage.close();
        }
    }

    @FXML
    private void ingresaArticulo(ActionEvent event) {
        String nombre = txtNombre.getText();
        String codigo = txtCodigo.getText();
        String ppub = txtPPublico.getText();
        String ppro = txtPProveedor.getText();
        String existencias = txtExistencias.getText();
        String categoria = cboxCategoria.getValue();

        if (nombre.isEmpty() || codigo.isEmpty() || ppub.isEmpty()
                || ppro.isEmpty() || existencias.isEmpty() || categoria.isEmpty()) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);

            alerta.setTitle("Datos incorrectos");
            alerta.setHeaderText("Asegurese de llenar todos los campos de texto");

            alerta.showAndWait();
            return;
        }

        if (!ppub.matches("\\d+(.\\d+){0,1}") || !ppro.matches("\\d+(.\\d+){0,1}")) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);

            alerta.setTitle("Datos incorrectos");
            alerta.setHeaderText("El formato de precios es incorrecto");

            alerta.showAndWait();
            return;
        }

        if (!existencias.matches("\\d+")) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);

            alerta.setTitle("Datos incorrectos");
            alerta.setHeaderText("El dato de existencias es incorrecto (solo números)");

            alerta.showAndWait();
            return;
        }

        Articulo anArticulo = new Articulo(
                codigo,
                nombre,
                Float.parseFloat(ppub),
                Float.parseFloat(ppro),
                Integer.parseInt(existencias),
                categoria
        );

        ArticuloDB db = new ArticuloDB();
        
        if (estaRegistrando) {
            if (validarArticulo(anArticulo)) {
                Alert alerta = new Alert(Alert.AlertType.WARNING);

                alerta.setTitle("Articulo existente");
                alerta.setHeaderText("El articulo (código) ya se encuentra registrado.");

                alerta.showAndWait();
                return;
            } else {

                db.addArticulo(anArticulo);
            }

            limpiarCampos();
            return;
        }

        if (validarArticulo(anArticulo) && !articuloActualizar.getCodigo().equals(codigo)) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);

            alerta.setTitle("Articulo existente");
            alerta.setHeaderText("El articulo (código) ya se encuentra registrado.");

            alerta.showAndWait();
        } else {

            db.updateArticulo(String.valueOf(articuloActualizar.getId()), anArticulo);

            limpiarCampos();
            estaRegistrando = true;
        }
    }

    @FXML
    private void actualizar(ActionEvent event) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);

        alerta.setTitle("Actualizar Articulo");
        alerta.setHeaderText("¿Desea actualizar este articulo?");

        alerta.showAndWait();
        if (!alerta.getResult().equals(ButtonType.OK)) {
            return;
        }

        articuloActualizar = tabArticulos.getSelectionModel().getSelectedItem();
        estaRegistrando = false;

        txtNombre.setText(articuloActualizar.getNombre());
        txtCodigo.setText(articuloActualizar.getCodigo());
        txtPPublico.setText(String.valueOf(articuloActualizar.getPPublico()));
        txtPProveedor.setText(String.valueOf(articuloActualizar.getPProveedor()));
        txtExistencias.setText(String.valueOf(articuloActualizar.getExistencias()));
        cboxCategoria.getSelectionModel().select(articuloActualizar.getCategoria());
    }

    @FXML
    private void eliminar(ActionEvent event) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);

        alerta.setTitle("Eliminar articulo");
        alerta.setHeaderText("¿Desea eliminar este articulo?");

        alerta.showAndWait();
        if (!alerta.getResult().equals(ButtonType.OK)) {
            return;
        }

        Articulo anArticulo = tabArticulos.getSelectionModel().getSelectedItem();

        if (anArticulo != null) {
            ArticuloDB db = new ArticuloDB();

            db.deleteArticulo(String.valueOf(anArticulo.getId()));
            articulos.remove(anArticulo);
        }

        actualizarTabla();
    }

    private boolean validarArticulo(Articulo a) {
        boolean exists = false;
        ArticuloDB db = new ArticuloDB();

        if (db.getArticulo(String.valueOf(db.searchArticulo(a))).getNombre() != null) {
            exists = true;
        }

        return exists;
    }

    public void limpiarCampos() {
        txtNombre.clear();
        txtCodigo.clear();
        txtPPublico.clear();
        txtPProveedor.clear();
        txtExistencias.clear();
        cboxCategoria.getSelectionModel().select("S/C");
    }

    public void actualizarTabla() {
        ObservableList<Articulo> olArticulos = FXCollections.observableArrayList();

        for (Articulo temp : this.articulos) {
            olArticulos.add(temp);
        }

        tabArticulos.setItems(olArticulos);
    }

    @FXML
    private void buscarArticulos(KeyEvent event) {
        ArticuloDB db = new ArticuloDB();
        String busqueda = txtBuscar.getText();

        articulos = db.getArticulos("nombre_articulo like \"%" + busqueda + "%\" OR "
                + "codigo_articulo like \"%" + busqueda + "%\"");

        actualizarTabla();
    }
}
