package Laboratorio1;

public class Espacio {

    private boolean estado;
    private Prisionero prisionero;
    private TipoEspacio tipoEspacio;

    public Espacio(boolean estado, Prisionero prisionero, TipoEspacio tipoEspacio) {
        this.estado = estado;
        this.prisionero = prisionero;
        this.tipoEspacio = tipoEspacio;
    }

    public Espacio() {
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Prisionero getPrisionero() {
        return prisionero;
    }

    public void setPrisionero(Prisionero prisionero) {
        this.prisionero = prisionero;
    }

    public TipoEspacio getTipoEspacio() {
        return tipoEspacio;
    }

    public void setTipoEspacio(TipoEspacio tipoEspacio) {
        this.tipoEspacio = tipoEspacio;
    }

    @Override
    public String toString() {
        return "Espacio{" +
                "estado=" + estado +
                ", prisionero=" + prisionero +
                ", tipoEspacio=" + tipoEspacio +
                '}';
    }
}
