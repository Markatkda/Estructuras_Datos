package Laboratorio2.Services;

public interface ILogin {
    public boolean verificarBibliotecario(String usser, String password);

    public boolean verificarEstudiante(String usser, String password);
}
