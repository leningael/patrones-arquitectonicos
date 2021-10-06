package modelo;

public interface Sujeto {
    void registrarObservador(Observador o);
    void removerObservador(Observador o);
    int getNumVotos(String nombre);
    String getNombreCandidato(int indice);
    void registrarVoto(String nombre, int numVotos);
    void inicializar();
    void imprimirVoto(String nombre);
    void cargarCandidatos();
}