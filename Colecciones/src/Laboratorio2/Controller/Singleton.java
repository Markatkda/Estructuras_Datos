package Laboratorio2.Controller;

import Laboratorio2.Application.*;
import Laboratorio2.Exceptions.LibroException;
import Laboratorio2.Model.*;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class Singleton {
    /**
     * atributos
     */
    Biblioteca biblioteca;
    private Aplicacion aplicacion;


    private static class SingletonHolder{
        private final static Singleton eInstance = new Singleton();
    }
    public static Singleton getInstance(){
        return SingletonHolder.eInstance;
    }

    /**
     * metodo set de aplicacion
     * @param aplicacion
     */
    public void setAplicacion(Aplicacion aplicacion){
        this.aplicacion = aplicacion;
    }

    /**
     * metodo get de empresa
     * @return
     */
    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public Singleton(){
        inicializarDatos();
    }


    //---------------------------Inicializacion de datos--------------//

    /**
     * metodo que inicializa los datos de la biblioteca
     */
    private void inicializarDatos (){
        biblioteca = new Biblioteca();
        biblioteca.setNombre("Subastas Quindio");

        try {
            this.biblioteca.crearUsuario("marce", "123", "Marcela", "1", TipoUsuario.BIBLIOTECARIO);
            this.biblioteca.crearUsuario("sofi", "123", "Sofia", "2", TipoUsuario.ESTUDIANTE);
            this.biblioteca.crearUsuario("juan", "123", "Juan", "3", TipoUsuario.ESTUDIANTE);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            this.biblioteca.crearLibro("1", "El principito", "Antoine de Saint-Exupéry", 1943);
            this.biblioteca.crearLibro("2", "El alquimista", "Paulo Coelho", 1988);
            this.biblioteca.crearLibro("3", "El señor de los anillos", "J. R. R. Tolkien", 1954);
            this.biblioteca.crearLibro("4", "El código Da Vinci", "Dan Brown", 2003);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        System.out.println("Biblioteca Inicializada "+ biblioteca.getNombre());

    }


    ///---------------------------Metodos de cambio de ventanas--------------//
    /**
     * metodo que envia una ruta a aplicacion para que muestre la vista: Login
     * @param ruta
     */
    public void mostrarLogin(String ruta){
        aplicacion.mostrarLogin(ruta);
    }

    /**
     * metodo que envia una ruta a aplicacion para que muestre la vista: CrudUsuario
     * @param ruta
     */
    public void mostrarCrudUsuario(String ruta) {
        aplicacion.mostrarCrudUsuario(ruta);
    }

    /**
     * metodo que envia una ruta a aplicacion para que muestre la vista: CrudLibroBiblioteca
     * para estudiantes
     * @param ruta
     */
    public void mostrarCrudLibroBibliotecaE(String ruta) {
        aplicacion.mostrarCrudLibroBibliotecaE(ruta);
    }

    /**
     * metodo que envia una ruta a aplicacion para que muestre la vista: CrudLibroBiblioteca
     * para bibliotecarios
     * @param ruta
     */
    public void mostrarCrudLibroBibliotecaB(String ruta) {
        aplicacion.mostrarCrudLibroBibliotecaB(ruta);
    }


    ///---------------------------METODOS QUE LLAMAN A LA BIBLIOTECA--------------//
    //---------------------------Metodos de Login--------------//

    /**
     * metodo que verifica si el usuario es estudiante
     * @param usser
     * @param password
     * @return
     */
    public boolean verificarEstudiante(String usser, String password) {
        return biblioteca.verificarEstudiante(usser, password);
    }

    /**
     * metodo que verifica si el usuario es bibliotecario
     * @param usser
     * @param password
     * @return
     */
    public boolean verificarBibliotecario(String usser, String password) {
        return biblioteca.verificarBibliotecario(usser, password);
    }

    //---------------------------Metodos de usuario--------------//

    /**
     * metodo que crea un usuario
     * @param usser
     * @param password
     * @param nombre
     * @param cedula
     * @param tipoUsuario
     * @throws Exception
     */
    public void crearUsuario(String usser, String password, String nombre, String cedula, TipoUsuario tipoUsuario) throws Exception {
        biblioteca.crearUsuario(usser, password, nombre, cedula, tipoUsuario);
    }

    /**
     *
     * @param usser
     * @param password
     * @param nombre
     * @param cedula
     * @param tipoUsuario
     */
    public void actualizarUsuario(String usser, String password, String nombre, String cedula, TipoUsuario tipoUsuario) {
        biblioteca.actualizarUsuario(usser, password, nombre, cedula, tipoUsuario);
    }

    /**
     *
     * @param cedula
     * @throws Exception
     */
    public void eliminarUsuario(String cedula) throws Exception {
        biblioteca.eliminarUsuario(cedula);
    }

    /**
     * metodo que busca un usuario
     * @param cedula
     * @return Usuario
     */
    public Usuario buscarUsuario(String cedula) {
        return biblioteca.buscarUsuario(cedula);
    }

    /**
     * metodo que retorna la lista de usuarios
     * @return ArrayList<Usuario>
     */
    public ArrayList<Usuario> listaUsuarios() {
        return biblioteca.getListaUsuarios();

    }

    /**
     * metodo que retorna la lista de usuarios estudiantes
     * @return TreeSet<Usuario>
     */
    public TreeSet<Usuario> obtenerListaUsuariosEstudiantes() {
        return biblioteca.getListaEstudiantes();
        //return biblioteca.getListaLogin;
    }

    /**
     * metodo que retorna la lista de usuarios bibliotecarios
     * @return TreeSet<Usuario>
     */
    public Set<Usuario> obtenerListaUsuariosBibliotecarios() {
        return biblioteca.getListaBibliotecarios();
    }

    //---------------------------Metodos de libro--------------//

    /**
     * metodo que crea un libro
     * @param idLibro
     * @param nombreLibro
     * @param autorLibro
     * @param year
     * @throws Exception
     */
    public void crearLibro(String idLibro, String nombreLibro, String autorLibro, int year) throws Exception {
        biblioteca.crearLibro(idLibro, nombreLibro, autorLibro, year);
    }

    /**
     * metodo que busca un libro
     * @param idLibro
     * @return Libro
     */
    public Libro buscarLibro(String idLibro) {
        return biblioteca.buscarLibro(idLibro);
    }

    /**
     * metodo que elimina un libro
     * @param idLibro
     * @throws LibroException
     */
    public void eliminarLibro(String idLibro) throws LibroException {
        biblioteca.eliminarLibro(idLibro);
    }

    /**
     * metodo que actualiza un libro
     * @param idLibro
     * @param nombreLibro
     * @param autorLibro
     * @param year
     */
    public void actualizarLibro(String idLibro, String nombreLibro, String autorLibro, int year) {
        biblioteca.actualizarLibro(idLibro, nombreLibro, autorLibro, year);
    }

    /**
     * metodo que retorna la lista de libros
     * @return ArrayList<Libro>
     */
    public Set<Libro> listaLibros() {
        return biblioteca.getListaLibros();

    }

    /**
    * metodo que retorna la lista de libros por nombre
    * @return TreeSet<Libro>
    */
    public Set<Libro> obtenerListaLibrosAutor() {
        return biblioteca.getLibrosPorAutor();
    }

    /**
     * metodo que retorna la lista de libros por fecha
     * @return TreeSet<Libro>
     */
    public Set<Libro> obtenerListaLibrosFecha() {
        return biblioteca.getLibrosPorFecha();
    }


    //---------------------------Metodos de prestamo--------------//

    /**
     * metodo que retorna la lista de libros prestados
     * @param cedula
     * @return ArrayList<Libro>
     */
    public ArrayList<Libro> listaLibrosPrestados(String cedula) {
        return biblioteca.listaLibrosPrestados(cedula);
    }

    /**
     * metodo que presta un libro
     * @param libro
     * @param usuario
     * @throws Exception
     */
    public void prestarLibro(Libro libro, Usuario usuario) throws Exception {

        biblioteca.prestarLibro(libro, usuario);
    }

    /**
     * metodo que retorna la lista de prestamos
     * @return HashMap
     */
    public HashMap<String, Prestamo> listaPrestamos() {
        return biblioteca.getListaPrestamos();
    }

    /**
     * metodo que devuelve un libro
     * @return HashMap
     */
    public void devolverLibro(Libro libro, Usuario usuario) throws Exception {

        biblioteca.devolverLibro(libro, usuario);
    }

    /**
     * metodo que retorna el usuario que inicio sesion
     * @return
     */
    public ArrayList<Usuario> obtenerlistaLogin() {
        return biblioteca.getListaLogin();
    }

    /**
     * metodo que cierra sesion del usuario
     */
    public void cerrarSesion() {
        biblioteca.cerrarSesion();
    }

}
