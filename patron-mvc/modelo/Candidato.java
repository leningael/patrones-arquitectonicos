package modelo;

import java.util.ArrayList;
import java.util.List;

public class Candidato implements Sujeto{
    List<Observador> observadores = new ArrayList<Observador>();
    String nombre;
    int numVotos;

    public void inicializar() {

    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getNumVotos() {
        return numVotos;
    }
    public void setNumVotos(int numVotos) {
        this.numVotos = numVotos;
        notificarVista();
    }

    public void registrarObservador(Observador o) {
        observadores.add(o);
    }

    public void removerObservador(Observador o) {
        int i = observadores.indexOf(o);
        if (i >= 0)
            observadores.remove(i);
    }
    
    public void notificarVista(){
        for(int i = 0; i < observadores.size(); i++){
            Observador observador = (Observador)observadores.get(i);
            observador.actualizacion();
        }
    }
}
