package Laboratorio2.Model;

import java.util.Objects;

public class DetallePrestamo implements Comparable<DetallePrestamo>{

    //Atributos
    private String id;
    private Libro libro;

    // Constructor sin atributos
    public DetallePrestamo() {
    }

    // Constructor con atributos
    public DetallePrestamo(String id, Libro libro) {
        this.id = id;
        this.libro = libro;
    }

    // Getters y Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    // Metodos equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetallePrestamo that = (DetallePrestamo) o;
        return Objects.equals(id, that.id);
    }

    // hashcode
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // Metodo toString
    @Override
    public String toString() {
        return libro.getNombre();
    }

    @Override
    public int compareTo(DetallePrestamo o) {
        return this.id.compareTo(o.id);
    }
}
