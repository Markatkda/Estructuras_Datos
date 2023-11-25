package Laboratorio2.Exceptions;

public class ParametroVacioException extends Exception{
    public ParametroVacioException(String s) {
        super (s);
    }

    public ParametroVacioException() {
        super ();
    }
}
