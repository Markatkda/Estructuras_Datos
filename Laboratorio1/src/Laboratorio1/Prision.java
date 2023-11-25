package Laboratorio1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Prision {

    private String nombre;
    private int id;
    private ArrayList<Prisionero> listaPrisioneros;
    private ArrayList<Piso> listaPisos;

    public Prision(String nombre, int id, ArrayList<Prisionero> listaPrisioneros, ArrayList<Piso> listaPisos) {
        this.nombre = nombre;
        this.id = id;
        this.listaPrisioneros = listaPrisioneros;
        this.listaPisos = listaPisos;
    }

    public Prision() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Prisionero> getListaPrisioneros() {
        return listaPrisioneros;
    }

    public void setListaPrisioneros(ArrayList<Prisionero> listaPrisioneros) {
        this.listaPrisioneros = listaPrisioneros;
    }

    public ArrayList<Piso> getListaPisos() {
        return listaPisos;
    }

    public void setListaPisos(ArrayList<Piso> listaPisos) {
        this.listaPisos = listaPisos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prision prision = (Prision) o;
        return id == prision.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Prision{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                ", listaPrisioneros=" + listaPrisioneros +
                ", listaPisos=" + listaPisos +
                '}';
    }

    //----------------------------------------------------------


}
