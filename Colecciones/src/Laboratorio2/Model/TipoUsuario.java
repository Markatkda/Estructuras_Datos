package Laboratorio2.Model;

public enum TipoUsuario {

    ESTUDIANTE(0), BIBLIOTECARIO(1);

    /**
     * atributos
     */
    private int numTipo;

    /**
     * Constructor
     * @param tipo
     */
    private TipoUsuario(int tipo) {
        numTipo = tipo;
    }

    /**
     * Metodo Get
     * @return
     */
    public int getNumTipo() {
        return numTipo;
    }
}
