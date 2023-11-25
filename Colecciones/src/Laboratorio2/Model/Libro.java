package Laboratorio2.Model;

import java.util.Objects;

public class Libro implements Comparable<Libro> {
    // Atributos
    private String id;
    private String nombre;
    private String autor;
    private int fechaPublicacion;

    // Constructor sin atributos
    public Libro() {
    }

    // Constructor con atributos
    public Libro(String id, String nombre, String autor, int fechaPublicacion) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(int fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    // Metodos equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return Objects.equals(id, libro.id);
    }

    // Metodos hashCode
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // Metodo toString
    @Override
    public String toString() {
        return "Libro{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", autor='" + autor + '\'' +
                ", fechaPublicacion=" + fechaPublicacion +
                '}';
    }

    // Metodo compareTo
    @Override
    public int compareTo(Libro o) {
        return this.id.compareTo(o.id);
    }
}
