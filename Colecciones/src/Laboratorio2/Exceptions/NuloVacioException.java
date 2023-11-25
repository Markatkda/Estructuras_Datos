package Laboratorio2.Exceptions;

public class NuloVacioException extends Exception{
    public NuloVacioException(String s) {
        super (s);
    }

    public NuloVacioException() {
        super ();
    }
}