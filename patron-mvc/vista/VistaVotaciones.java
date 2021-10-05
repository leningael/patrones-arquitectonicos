package vista;

import controlador.Controlador;
import modelo.Observador;
import modelo.Sujeto;

public class VistaVotaciones implements Observador{
    Sujeto modelo;
    Controlador controlador;
    public VistaVotaciones(Controlador controlador, Sujeto modelo) {
        this.modelo = modelo;
        this.controlador = controlador;
    }
    
    public void actualizacion() {
        if(modelo != null){
            int numVotos = modelo.getNumVotos();
        }
    }
}
