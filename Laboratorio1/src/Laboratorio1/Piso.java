package Laboratorio1;

import java.util.Arrays;
import java.util.Objects;

public class Piso {

    private int numeroPiso;
    private Espacio[][] matrizEspacios = new Espacio[5][6];

    public Piso(int numeroPiso, Espacio[][] matrizEspacios) {
        this.numeroPiso = numeroPiso;
        this.matrizEspacios = matrizEspacios;
    }

    public Piso() {
    }

    public int getNumeroPiso() {
        return numeroPiso;
    }

    public void setNumeroPiso(int numeroPiso) {
        this.numeroPiso = numeroPiso;
    }

    public Espacio[][] getMatrizEspacios() {
        return matrizEspacios;
    }

    public void setMatrizEspacios(Espacio[][] matrizEspacios) {
        this.matrizEspacios = matrizEspacios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piso piso = (Piso) o;
        return numeroPiso == piso.numeroPiso;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroPiso);
    }

    @Override
    public String toString() {
        return "Piso{" +
                "numeroPiso=" + numeroPiso +
                ", matrizEspacios=" + Arrays.toString(matrizEspacios) +
                '}';
    }
}
