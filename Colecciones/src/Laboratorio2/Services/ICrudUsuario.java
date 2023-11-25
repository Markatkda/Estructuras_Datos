package Laboratorio2.Services;

import Laboratorio2.Exceptions.NuloVacioException;
import Laboratorio2.Exceptions.UsuarioException;
import Laboratorio2.Model.TipoUsuario;
import Laboratorio2.Model.Usuario;

public interface ICrudUsuario {
    public void crearUsuario(String usser, String password, String nombre, String cedula, TipoUsuario tipoUsuario) throws Exception;

    public Usuario buscarUsuario(String cedula);

    public void eliminarUsuario(String cedula) throws Exception;

    public void actualizarUsuario(String nuevoUsser, String nuevaPassword, String nuevoNombre, String cedula, TipoUsuario nuevoTipo);

    public boolean existeUsuario(String cedula);

    public boolean existeUsser(String usser) throws Exception;


}
