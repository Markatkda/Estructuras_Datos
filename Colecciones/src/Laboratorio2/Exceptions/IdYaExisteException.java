package Laboratorio2.Exceptions;

public class IdYaExisteException extends Exception{
    public IdYaExisteException(String s) {
        super (s);
    }

    public IdYaExisteException() {
        super ();
    }
}
