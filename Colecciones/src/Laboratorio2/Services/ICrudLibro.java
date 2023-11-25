package Laboratorio2.Services;

import Laboratorio2.Exceptions.LibroException;
import Laboratorio2.Exceptions.NuloVacioException;
import Laboratorio2.Model.*;

public interface ICrudLibro {
    public void crearLibro(String id, String nombre, String autor, int fechaPublicacion) throws Exception;

    public Libro buscarLibro(String id);

    public void eliminarLibro(String id) throws LibroException;

    public void actualizarLibro(String id, String nombre, String autor, int fechaPublicacion);

    public boolean existeLibro(String id);

}
