package Laboratorio2.Controller;

import Laboratorio2.Application.Aplicacion;
import Laboratorio2.Exceptions.ParametroVacioException;
import Laboratorio2.Model.Biblioteca;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController {

    /**
     * atributos
     */
    Biblioteca biblioteca = Singleton.getInstance().getBiblioteca();

    Singleton singleton = Singleton.getInstance();
    Aplicacion aplicacion;

    //Metodo set de aplicacion
    public void setAplicacion(Aplicacion aplicacion){
        this.aplicacion = aplicacion;
        singleton.setAplicacion(aplicacion);
    }


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCrearCuenta;

    @FXML
    private TextField txtUsser;

    @FXML
    private Button btnIngresar;

    @FXML
    private PasswordField txtPassword;

    @FXML
    void ingresarUsuario(ActionEvent event) throws ParametroVacioException {
        //singleton.mostrarCrudLibroBibliotecaE("/Laboratorio2/View/CrudLibroBiblioteca.fxml");
        verificarInicioSesion();
    }


    @FXML
    void crearUsuario(ActionEvent event) {
        singleton.mostrarCrudUsuario("/Laboratorio2/View/CrudUsuario.fxml");
    }


    @FXML
    void initialize() {
        assert btnCrearCuenta != null : "fx:id=\"btnCrearCuenta\" was not injected: check your FXML file 'Login.fxml'.";
        assert txtUsser != null : "fx:id=\"txtUsser\" was not injected: check your FXML file 'Login.fxml'.";
        assert btnIngresar != null : "fx:id=\"btnIngresar\" was not injected: check your FXML file 'Login.fxml'.";
        assert txtPassword != null : "fx:id=\"txtPassword\" was not injected: check your FXML file 'Login.fxml'.";
        txtUsser.setPromptText("Ingrese su usuario");
        txtPassword.setPromptText("Ingrese su contraseña");
    }

    /**
     * Metodo que me permite verificar el inicio de sesion
     */
    private void verificarInicioSesion() throws ParametroVacioException {
        String usser = txtUsser.getText();
        String password = txtPassword.getText();

        if (!usser.equals("") && !password.equals("")){
            //si el tipo de usuario es estudiante entonces me abre una ventana especial para estudiantes
            if (singleton.verificarEstudiante(usser, password)) {
                singleton.mostrarCrudLibroBibliotecaE("/Laboratorio2/View/CrudLibroBiblioteca.fxml");

                //si el tipo de usuario es comprador entonces me abre una ventana especial para anunciantes
            }else if (singleton.verificarBibliotecario(usser, password)) {
                singleton.mostrarCrudLibroBibliotecaB("/Laboratorio2/View/CrudLibroBiblioteca.fxml");

            }else {
                //si no cumple las anteriores opciones entonces ingreso algo mal
                System.out.println("La informacion digitada no es correcta "+ password+usser);
            }
        }else {
            //si intenta iniciar sesion pero los campos estan vacios
            throw new ParametroVacioException("Alguno de los parámetros indicados es está vacío");
        }

    }
}
