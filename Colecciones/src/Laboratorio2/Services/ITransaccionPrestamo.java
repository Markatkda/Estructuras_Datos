package Laboratorio2.Services;

import Laboratorio2.Exceptions.NuloVacioException;
import Laboratorio2.Model.Libro;
import Laboratorio2.Model.Usuario;

public interface ITransaccionPrestamo {

    public void prestarLibro(Libro libro, Usuario usuario) throws Exception;

    public void devolverLibro(Libro libro, Usuario usuario) throws Exception;
}
