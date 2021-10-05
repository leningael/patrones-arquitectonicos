package controlador;

import modelo.Sujeto;
import vista.VistaVotaciones;

public class ControladorVotaciones implements Controlador{
    Sujeto modelo;
    VistaVotaciones vista;

    public ControladorVotaciones(Sujeto modelo){
        this.modelo = modelo;
        vista = new VistaVotaciones(this, modelo);
        //vista.crearVista();
        modelo.inicializar();
    }

    public void aumentar() {
        int numVotos = modelo.getNumVotos();
        modelo.setNumVotos(numVotos+1);
    }
}