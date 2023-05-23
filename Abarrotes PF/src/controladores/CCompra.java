/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;

import elementos.Articulo;
import elementos.Ticket;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import registradores.ArticuloDB;
import registradores.GuardadorTicket;

/**
 * FXML Controller class
 *
 * @author Angel Balderas
 */
public class CCompra extends IControlador implements Initializable {

    private ArrayList<Articulo> compras = new ArrayList<>();
    private ArrayList<Articulo> busquedas = new ArrayList<>();
    private double totalCompras = 0;
    private GuardadorTicket guardador;

    @FXML
    private ComboBox<String> cboxCategoria;
    @FXML
    private javafx.scene.control.TextField txtBuscar;
    @FXML
    private TableView<Articulo> tabCarrito;
    @FXML
    private TableColumn<?, ?> colNombreC;
    @FXML
    private TableColumn<?, ?> colPrecioC;
    @FXML
    private TableColumn<?, ?> colCantidadC;
    @FXML
    private TableColumn<Articulo, String> colTotalC;
    @FXML
    private TableView<Articulo> tabBuscar;
    @FXML
    private TableColumn<?, ?> colNombreB;
    @FXML
    private TableColumn<?, ?> colPrecioB;
    @FXML
    private TableColumn<?, ?> colExistenciasB;
    @FXML
    private javafx.scene.control.TextField txtCantidad;
    @FXML
    private Button btnVolver;
    @FXML
    private Label lTotal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cboxCategoria.getItems().addAll(
                "TODO",
                "S/C",
                "LIMPIEZA",
                "BOTANA",
                "COMIDA",
                "FRUTA/VERDURA",
                "BEBIDA"
        );

        cboxCategoria.getSelectionModel().select("TODO");

        txtCantidad.setText("1");

        this.colNombreC.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colNombreB.setCellValueFactory(new PropertyValueFactory("nombre"));

        this.colPrecioB.setCellValueFactory(new PropertyValueFactory("pPublico"));
        this.colPrecioC.setCellValueFactory(new PropertyValueFactory("pPublico"));
        this.colExistenciasB.setCellValueFactory(new PropertyValueFactory("existencias"));

        this.colCantidadC.setCellValueFactory(new PropertyValueFactory("cantidad"));
        this.colTotalC.setCellValueFactory((TableColumn.CellDataFeatures<Articulo, String> p)
                -> new ReadOnlyObjectWrapper(p.getValue().getPPublico() * p.getValue().getCantidad())
        );
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
            Stage currentStage = (Stage) btnVolver.getScene().getWindow();
            currentStage.close();
        }
    }

    @FXML
    private void buscar(KeyEvent event) {
        ArticuloDB db = new ArticuloDB();
        String busqueda = txtBuscar.getText();
        String categoria = cboxCategoria.getValue();

        if (!categoria.equals("TODO")) {
            this.busquedas = db.getArticulos("(nombre_articulo like \"%" + busqueda + "%\" OR "
                    + "codigo_articulo like \"%" + busqueda + "%\") AND "
                    + "categoria_articulo = \"" + categoria + "\"");
        } else {
            this.busquedas = db.getArticulos("(nombre_articulo like \"%" + busqueda + "%\" OR "
                    + "codigo_articulo like \"%" + busqueda + "%\")");
        }

        actualizarTablaBuscar();
    }

    private void actualizarTablaCompra() {
        ObservableList<Articulo> olArticulos = FXCollections.observableArrayList();
        totalCompras = 0;

        for (Articulo temp : this.compras) {
            olArticulos.add(temp);
            totalCompras += (temp.getCantidad() * temp.getPPublico());
        }

        lTotal.setText("Total: $ " + totalCompras);
        tabCarrito.setItems(olArticulos);
    }

    private void actualizarTablaBuscar() {
        ObservableList<Articulo> olArticulos = FXCollections.observableArrayList();

        for (Articulo temp : this.busquedas) {
            olArticulos.add(temp);
        }

        tabBuscar.setItems(olArticulos);
    }

    private Ticket generarTicket() {
        Ticket aTicket = null;

        aTicket = new Ticket(
                compras,
                totalCompras,
                this.usuario
        );

        return aTicket;
    }

    private void guardarTicket() {
        guardador = new GuardadorTicket(generarTicket());

        if (guardador.generarPDF()) {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);

            alerta.setTitle("Ticket generado");
            alerta.setHeaderText("El ticket ha sido generado exitosamente");
            
            alerta.show();
        }
    }

    private boolean validarStock(Articulo a, int c) {
        boolean isStock = false;

        if (compras.contains(a)) {
            for (Articulo temp : compras) {
                if (temp.equals(a)) {
                    c += temp.getCantidad();
                }
            }
        }

        if (c <= a.getExistencias()) {
            isStock = true;
        }

        return isStock;
    }

    private void actualizarStock() {
        ArticuloDB db = new ArticuloDB();

        for (Articulo temp : compras) {
            int ne = temp.getExistencias() - temp.getCantidad();
            db.updateStock(String.valueOf(temp.getId()), ne);
        }
    }

    @FXML
    private void quitarArticulo(ActionEvent event) {
        Articulo anArticulo = tabCarrito.getSelectionModel().getSelectedItem();

        compras.remove(anArticulo);

        actualizarTablaCompra();
    }

    @FXML
    private void agregarArticulo(ActionEvent event) {
        Articulo anArticulo = tabBuscar.getSelectionModel().getSelectedItem();
        String cantidad = txtCantidad.getText();

        if (anArticulo.getExistencias() == 0) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);

            alerta.setTitle("Existencias insuficientes");
            alerta.setHeaderText("Ya no contamos con existencias de este producto");

            alerta.showAndWait();
            return;
        }

        if (!cantidad.matches("\\d+")) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);

            alerta.setTitle("Datos incorrectos");
            alerta.setHeaderText("La cantidad solo debe ser númerica");

            alerta.showAndWait();
            return;
        }

        if (!validarStock(anArticulo, Integer.parseInt(cantidad))) {
            Alert alerta = new Alert(Alert.AlertType.WARNING);

            alerta.setTitle("Existencias insuficientes");
            alerta.setHeaderText("Las existencias de este producto es menor a la cantidad solicitada.\n"
                    + "Este producto cuenta con " + anArticulo.getExistencias() + "unidades");

            alerta.showAndWait();
            return;
        }

        anArticulo.setCantidad(Integer.parseInt(cantidad));

        compras.add(anArticulo);

        actualizarTablaCompra();

        txtCantidad.setText("1");
    }

    @FXML
    private void realizarCompra(ActionEvent event) {
        if (compras.isEmpty()) {
            return;
        }

        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);

        alerta.setTitle("Cerrar compra");
        alerta.setHeaderText("¿Desea finalizar su compra?");

        alerta.showAndWait();
        if (!alerta.getResult().equals(ButtonType.OK)) {
            return;
        }

        alerta = new Alert(Alert.AlertType.INFORMATION);

        alerta.setTitle("Compra realizada");
        alerta.setHeaderText("Su compra ha sido realizada, se generará su ticket");

        alerta.showAndWait();
        
        guardarTicket();

        actualizarStock();
        compras.clear();
        actualizarTablaCompra();
    }
}
