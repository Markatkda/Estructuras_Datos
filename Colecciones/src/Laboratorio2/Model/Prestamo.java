package Laboratorio2.Model;

import java.util.HashMap;
import java.util.Objects;

public class Prestamo implements Comparable<Prestamo>{
    //Atributos
    private String id;
    private Usuario usuario;
    private HashMap<String, DetallePrestamo> listaDetallePrestamo = new HashMap<>();

    //Constructor sin atributos
    public Prestamo() {
    }

    //Constructor con atributos
    public Prestamo(String id, Usuario usuario, HashMap<String, DetallePrestamo> listaDetallePrestamo) {
        this.id = id;
        this.usuario = usuario;
        this.listaDetallePrestamo = listaDetallePrestamo;
    }

    //Getters y Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public HashMap<String, DetallePrestamo> getListaDetallePrestamo() {
        return listaDetallePrestamo;
    }

    public void setListaDetallePrestamo(HashMap<String, DetallePrestamo> listaDetallePrestamo) {
        this.listaDetallePrestamo = listaDetallePrestamo;
    }

    //Metodos equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prestamo prestamo = (Prestamo) o;
        return Objects.equals(id, prestamo.id);
    }

    // hashcode
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    //metodo toString


    @Override
    public String toString() {
        return "Prestamo{" +
                "id='" + id + '\'' +
                ", usuario=" + usuario +
                ", listaDetallePrestamo=" + listaDetallePrestamo +
                '}';
    }
    
    //Metodo para buscar un detalle de prestamo
    public DetallePrestamo buscarDetallePrestamo(String id){
        return listaDetallePrestamo.get(id);
    }


    @Override
    public int compareTo(Prestamo o) {
        return this.id.compareTo(o.id);
    }
}
