package controlador;

import modelo.Sujeto;
import vista.VistaVotaciones;

public class ControladorVotaciones implements Controlador{
    Sujeto modelo;
    VistaVotaciones vista;

    public ControladorVotaciones(Sujeto modelo){
        this.modelo = modelo;
        modelo.cargarCandidatos();
        vista = new VistaVotaciones(this, modelo);
        vista.inicializarVista();
        modelo.inicializar();
    }

    public void aumentar(String nombre) {
        int numVotos = modelo.getNumVotos(nombre);
        modelo.registrarVoto(nombre, numVotos+1);
        modelo.imprimirVoto(nombre);
    }
}