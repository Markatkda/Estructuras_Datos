package Laboratorio2.Model;

import java.util.ArrayList;
import java.util.Objects;

public class Usuario implements Comparable<Usuario>{
    // Atributos
    private String nombre;
    private String cedula;
    private String usser;
    private String password;
    private TipoUsuario tipoUsuario;
    private ArrayList<Libro> listaPrestamos = new ArrayList<>();

    // Constructor sin atributos
    public Usuario() {
    }

    // Constructor con atributos


    public Usuario(String nombre, String cedula, String usser, String password, TipoUsuario tipoUsuario, ArrayList<Libro> listaPrestamos) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.usser = usser;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
        this.listaPrestamos = listaPrestamos;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getUsser() {
        return usser;
    }

    public void setUsser(String usser) {
        this.usser = usser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public ArrayList<Libro> getListaPrestamos() {
        return listaPrestamos;
    }

    public void setListaPrestamos(ArrayList<Libro> listaPrestamos) {
        this.listaPrestamos = listaPrestamos;
    }

    // Metodos equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(cedula, usuario.cedula);
    }


    // Metodos hashCode
    @Override
    public int hashCode() {
        return Objects.hash(cedula);
    }

    // Metodo toString
    @Override
    public String toString() {
        return "nombre: " + nombre + " - cedula: " + cedula;
    }

    // Metodo compareTo
    @Override
    public int compareTo(Usuario o) {
        return this.tipoUsuario.compareTo(o.tipoUsuario);
    }



}
