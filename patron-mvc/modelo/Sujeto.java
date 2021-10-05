package modelo;

public interface Sujeto {
    void registrarObservador(Observador o);
    void removerObservador(Observador o);
    int getNumVotos();
    void setNumVotos(int numVotos);
    void inicializar();
}