/**
 * Sample Skeleton for 'CrudLibroBiblioteca.fxml' Controller Class
 */
package Laboratorio2.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import Laboratorio2.Application.Aplicacion;
import Laboratorio2.Exceptions.LibroException;
import Laboratorio2.Model.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CrudLibroBiblioteca {

    Biblioteca biblioteca = Singleton.getInstance().getBiblioteca();

    Singleton singleton = Singleton.getInstance();
    Aplicacion aplicacion;

    //Metodo set de aplicacion
    public void setAplicacion(Aplicacion aplicacion){
        this.aplicacion = aplicacion;
        singleton.setAplicacion(aplicacion);
    }

    //para la tabla del crud y los libros prestados
    private ObservableList<Libro> vistaListaLibros = FXCollections.observableArrayList();

    private ObservableList<Libro> vistaLibrosPrestados = FXCollections.observableArrayList();
    //para el combobox
    private ObservableList<Usuario> vistaListaUsuarios = FXCollections.observableArrayList();
    //para el combobox filtros autor y fecha
    private ObservableList<String> vistaListaFiltros = FXCollections.observableArrayList();

    private ObservableList<Prestamo> vistaListaPrestamos = FXCollections.observableArrayList();

    private ObservableList<Usuario> vistaLogin = FXCollections.observableArrayList();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="col_IdLibroP"
    private TableColumn<Libro, String> col_IdLibroP; // Value injected by FXMLLoader

    @FXML // fx:id="tblLibrosPrestados"
    private TableView<Libro> tblLibrosPrestados; // Value injected by FXMLLoader

    @FXML // fx:id="colNombreLibroC"
    private TableColumn<Libro, String> colNombreLibroC; // Value injected by FXMLLoader

    @FXML // fx:id="btnActualizarLibro"
    private Button btnActualizarLibro; // Value injected by FXMLLoader

    @FXML // fx:id="colNombreLibroD"
    private TableColumn<Libro, String> colNombreLibroD; // Value injected by FXMLLoader

    @FXML // fx:id="btnDevolverLibro"
    private Button btnDevolverLibro; // Value injected by FXMLLoader

    @FXML // fx:id="dateFechaLibro"
    private DatePicker dateFechaLibro; // Value injected by FXMLLoader

    @FXML // fx:id="tblLibrosCreados"
    private TableView<Libro> tblLibrosCreados; // Value injected by FXMLLoader

    @FXML // fx:id="btnBuscarLibro"
    private Button btnBuscarLibro; // Value injected by FXMLLoader

    @FXML // fx:id="colAutorLibroP"
    private TableColumn<Libro, String> colAutorLibroP; // Value injected by FXMLLoader

    @FXML // fx:id="colFechaLibroP"
    private TableColumn<Libro, String> colFechaLibroP; // Value injected by FXMLLoader

    @FXML // fx:id="tabCrearLibro"
    private Tab tabCrearLibro; // Value injected by FXMLLoader

    @FXML // fx:id="txtIdLibro"
    private TextField txtIdLibro; // Value injected by FXMLLoader

    @FXML // fx:id="btnSolicitarPrestamo"
    private Button btnSolicitarPrestamo; // Value injected by FXMLLoader

    @FXML // fx:id="txtAutorLibro"
    private TextField txtAutorLibro; // Value injected by FXMLLoader

    @FXML // fx:id="colNombreLibroP"
    private TableColumn<Libro, String> colNombreLibroP; // Value injected by FXMLLoader

    @FXML // fx:id="colAutorLibroC"
    private TableColumn<Libro, String> colAutorLibroC; // Value injected by FXMLLoader

    @FXML // fx:id="colAutorLibroD"
    private TableColumn<Libro, String> colAutorLibroD; // Value injected by FXMLLoader

    @FXML // fx:id="colFechaLibroC"
    private TableColumn<Libro, String> colFechaLibroC; // Value injected by FXMLLoader

    @FXML // fx:id="colFechaLibroD"
    private TableColumn<Libro, String> colFechaLibroD; // Value injected by FXMLLoader

    @FXML // fx:id="tblLibrosDisponibles"
    private TableView<Libro> tblLibrosDisponibles; // Value injected by FXMLLoader

    @FXML // fx:id="btnCrearLibro"
    private Button btnCrearLibro; // Value injected by FXMLLoader

    @FXML // fx:id="txtNombreLibro"
    private TextField txtNombreLibro; // Value injected by FXMLLoader

    @FXML // fx:id="btnCerrarSesionP"
    private Button btnCerrarSesionP; // Value injected by FXMLLoader

    @FXML // fx:id="tabPrestamos"
    private Tab tabMisLibros; // Value injected by FXMLLoader

    @FXML // fx:id="cboxEstudiantes"
    private ComboBox<Usuario> cboxEstudiantes; // Value injected by FXMLLoader

    @FXML // fx:id="col_idLibroD"
    private TableColumn<Libro, String> col_idLibroD; // Value injected by FXMLLoader

    @FXML // fx:id="col_IdLibroC"
    private TableColumn<Libro, String> col_IdLibroC; // Value injected by FXMLLoader

    @FXML // fx:id="cboxOrden"
    private ComboBox<String> cboxOrden; // Value injected by FXMLLoader

    @FXML // fx:id="tabBiblioteca"
    private Tab tabBiblioteca; // Value injected by FXMLLoader

    @FXML // fx:id="btnEliminarLibro"
    private Button btnEliminarLibro; // Value injected by FXMLLoader

    @FXML // fx:id="btnCerrarSesionD"
    private Button btnCerrarSesionD; // Value injected by FXMLLoader

    @FXML // fx:id="tabCrudLibro"
    private TabPane tabCrudLibro; // Value injected by FXMLLoader

    @FXML
    private ComboBox<Usuario> cboxUsuarioPrestamo;

    @FXML   // fx:id="tabPrestamos
    private Tab tabPrestamos;

    @FXML
    private TableView<Prestamo> tblPrestamos;

    @FXML
    private TableColumn<Prestamo, String> col_idPrestamo;

    @FXML
    private TableColumn<Prestamo, DetallePrestamo> col_prestamo;

    @FXML
    private TableColumn<Prestamo, Usuario> col_usuarioPrestamo;

    @FXML
    private Button btnCerrarSesionPrestamo;

    @FXML
    void cerrarSesionPrestamo(ActionEvent event) {
        singleton.mostrarLogin("/Laboratorio2/View/Login.fxml");
    }

    @FXML
    void CrearLibro(ActionEvent event) throws Exception {
        crearLibro();
        observarLibrosCreados();
        observarDatosAutor();
        observarDatosFecha();
        limpiarCampos();

    }

    @FXML
    void BuscarLibro(ActionEvent event) {
        buscarLibro();
    }

    @FXML
    void EliminarLibro(ActionEvent event) throws LibroException {
        eliminarLibro();
        observarLibrosCreados();
        observarDatosAutor();
        observarDatosFecha();
        limpiarCampos();

    }

    @FXML
    void ActualizarLibro(ActionEvent event) {
        actualizarLibro();
        observarLibrosCreados();
        observarDatosAutor();
        observarDatosFecha();
        limpiarCampos();
    }

    @FXML
    void cerrarSesionP(ActionEvent event) {
        singleton.mostrarLogin("/Laboratorio2/View/Login.fxml");
        singleton.cerrarSesion();
    }


    @FXML
    void cerrarSesionD(ActionEvent event) {
        singleton.mostrarLogin("/Laboratorio2/View/Login.fxml");
        singleton.cerrarSesion();
    }


    @FXML
    void SolicitarPrestamo(ActionEvent event) throws Exception {

        Libro libro = tblLibrosDisponibles.getSelectionModel().getSelectedItem();

        Usuario usuario = cboxUsuarioPrestamo.getValue();

        singleton.prestarLibro(libro, usuario);
        observarLibrosDisponibles();
        observarPrestamos();
        observarLibrosPrestados(usuario.getCedula());

        limpiarCampos();

    }

    @FXML
    void DevolverLibro(ActionEvent event) throws Exception {

        Libro libro = tblLibrosPrestados.getSelectionModel().getSelectedItem();

        Usuario usuario = cboxEstudiantes.getValue();

        singleton.devolverLibro(libro, usuario);

        observarLibrosPrestados(usuario.getCedula());
        observarPrestamos();
        limpiarCampos();


    }



    @FXML
    void ordenarLibros(ActionEvent event) {
        if (cboxOrden.getValue().equals("Autor")) {
            observarDatosAutor();
        }else{
            if (cboxOrden.getValue().equals("Fecha")) {
                observarDatosFecha();
            }else {
                observarLibrosDisponibles();
            }
        }



    }

    @FXML
    void VerListaPrestamos(ActionEvent event) {
        Usuario usuario = cboxEstudiantes.getValue();
        String cedula = usuario.getCedula();
        observarLibrosPrestados(cedula);

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        limpiarCampos();
        seleccionarElemento();
        seleccionarElemento2();
        seleccionarElemento3();

        observarPrestamos();
        observarLibrosCreados();
        observarLibrosDisponibles();
        vistaListaFiltros.setAll("Autor", "Fecha");
        cboxOrden.setItems(vistaListaFiltros);

        vistaLogin.setAll(singleton.obtenerlistaLogin());
        //vistaListaUsuarios.setAll(singleton.obtenerListaUsuariosEstudiantes());
        cboxEstudiantes.setItems(vistaLogin);
        cboxUsuarioPrestamo.setItems(vistaLogin);




    }

    //---------------------------Metodos de la estructura--------------//
    public TabPane getTabCrudLibro() {
        return tabCrudLibro;
    }

    public Button getBtnDevolverLibro() {
        return btnDevolverLibro;
    }

    public Button getBtnSolicitarPrestamo() {
        return btnSolicitarPrestamo;
    }

    public  ComboBox<Usuario> getCboxEstudiante(){return cboxUsuarioPrestamo;}


    //---------------------------Metodos de crear LIBRO--------------//

    public void crearLibro() throws Exception {
        String idLibro = txtIdLibro.getText();
        String nombreLibro = txtNombreLibro.getText();
        String autorLibro = txtAutorLibro.getText();

        java.time.LocalDate selectedDate = dateFechaLibro.getValue();
        int year = selectedDate.getYear();

        singleton.crearLibro(idLibro, nombreLibro, autorLibro, year);
    }

    public void buscarLibro(){
        String idLibro = txtIdLibro.getText();
        Libro libro = singleton.buscarLibro(idLibro);
        if(libro != null){
            txtNombreLibro.setText(libro.getNombre());
            txtAutorLibro.setText(libro.getAutor());
            dateFechaLibro.setValue(java.time.LocalDate.of(libro.getFechaPublicacion(), 1, 1));
        }
    }

    public void eliminarLibro() throws LibroException {
        String idLibro = txtIdLibro.getText();
        singleton.eliminarLibro(idLibro);
    }


    public void actualizarLibro(){
        String idLibro = txtIdLibro.getText();
        String nombreLibro = txtNombreLibro.getText();
        String autorLibro = txtAutorLibro.getText();

        java.time.LocalDate selectedDate = dateFechaLibro.getValue();
        int year = selectedDate.getYear();

        singleton.actualizarLibro(idLibro, nombreLibro, autorLibro, year);
    }




    //---------------------------Metodos adicionales--------------//
    public void observarLibrosCreados() {
        //para tab: crear Libro
        col_IdLibroC.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombreLibroC.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colAutorLibroC.setCellValueFactory(new PropertyValueFactory<>("autor"));
        colFechaLibroC.setCellValueFactory(new PropertyValueFactory<>("fechaPublicacion"));

        vistaListaLibros.setAll(singleton.listaLibros());
        tblLibrosCreados.setItems(vistaListaLibros);

    }

    public void observarLibrosDisponibles(){
        col_idLibroD.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombreLibroD.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colAutorLibroD.setCellValueFactory(new PropertyValueFactory<>("autor"));
        colFechaLibroD.setCellValueFactory(new PropertyValueFactory<>("fechaPublicacion"));

        vistaListaLibros.setAll(singleton.listaLibros());
        tblLibrosDisponibles.setItems(vistaListaLibros);
    }

    public void observarDatosAutor(){
        col_idLibroD.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombreLibroD.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colAutorLibroD.setCellValueFactory(new PropertyValueFactory<>("autor"));
        colFechaLibroD.setCellValueFactory(new PropertyValueFactory<>("fechaPublicacion"));

        vistaListaLibros.setAll(singleton.obtenerListaLibrosAutor());
        tblLibrosDisponibles.setItems(vistaListaLibros);
    }

    public void observarDatosFecha(){
        col_idLibroD.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombreLibroD.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colAutorLibroD.setCellValueFactory(new PropertyValueFactory<>("autor"));
        colFechaLibroD.setCellValueFactory(new PropertyValueFactory<>("fechaPublicacion"));

        vistaListaLibros.setAll(singleton.obtenerListaLibrosFecha());
        tblLibrosDisponibles.setItems(vistaListaLibros);

    }

    public void observarLibrosPrestados(String cedula) {
        //para tab: prestamos
        col_IdLibroP.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombreLibroP.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colAutorLibroP.setCellValueFactory(new PropertyValueFactory<>("autor"));
        colFechaLibroP.setCellValueFactory(new PropertyValueFactory<>("fechaPublicacion"));

        vistaLibrosPrestados.setAll(singleton.listaLibrosPrestados(cedula));
        tblLibrosPrestados.setItems(vistaLibrosPrestados);

    }

    private void observarPrestamos() {

        col_idPrestamo.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_usuarioPrestamo.setCellValueFactory(new PropertyValueFactory<>("usuario"));
        col_prestamo.setCellValueFactory(new PropertyValueFactory<>("listaDetallePrestamo"));

        HashMap<String, Prestamo> listaPrestamos = singleton.listaPrestamos();
        ArrayList<Prestamo> listaValorPrestamos = new ArrayList<>(listaPrestamos.values());
        vistaListaPrestamos.setAll(listaValorPrestamos);
        tblPrestamos.setItems(vistaListaPrestamos);


    }

    public void seleccionarElemento(){
        //para la tabla de crear libros
        tblLibrosCreados.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Libro>() {
                    @Override
                    public void changed(ObservableValue<? extends Libro> arg0, Libro oldValue, Libro libroSeleccionado) {
                        if(libroSeleccionado != null){
                            txtIdLibro.setText(libroSeleccionado.getId());
                            txtNombreLibro.setText(libroSeleccionado.getNombre());
                            txtAutorLibro.setText(libroSeleccionado.getAutor());
                            dateFechaLibro.setValue(java.time.LocalDate.of(libroSeleccionado.getFechaPublicacion(), 1, 1));
                        }
                    }
                }
        );
    }

    public void seleccionarElemento2(){

        //para la tabla de prestamos
        tblLibrosPrestados.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Libro>() {
                    @Override
                    public void changed(ObservableValue<? extends Libro> arg0, Libro oldValue, Libro libroSeleccionado) {

                    }
                }
        );
    }

    public void seleccionarElemento3(){
        //para la tabla de libros disponibles
        tblLibrosDisponibles.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Libro>() {
                    @Override
                    public void changed(ObservableValue<? extends Libro> arg0, Libro oldValue, Libro libroSeleccionado) {

                    }
                }
        );
    }

    /**
     * metodo que limpia los campos de texto
     */
    public void limpiarCampos() {

        txtIdLibro.setText("");
        txtIdLibro.setPromptText("Id del libro");
        txtNombreLibro.setText("");
        txtNombreLibro.setPromptText("Nombre del libro");
        txtAutorLibro.setText("");
        txtAutorLibro.setPromptText("Autor del libro");
        dateFechaLibro.setValue(null);
        dateFechaLibro.setPromptText("Fecha de publicacion");

        cboxUsuarioPrestamo.setPromptText("Seleccione un estudiante");
        cboxEstudiantes.setPromptText("Seleccione un estudiante");
        cboxOrden.setPromptText("Seleccione un filtro");


        tblLibrosCreados.getSelectionModel().clearSelection();
        tblLibrosPrestados.getSelectionModel().clearSelection();
        tblLibrosDisponibles.getSelectionModel().clearSelection();
        tblPrestamos.getSelectionModel().clearSelection();



    }








}

