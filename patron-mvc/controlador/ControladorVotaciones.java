package controlador;

import modelo.FilePrinter;
import modelo.Sujeto;
import vista.VistaVotaciones;

public class ControladorVotaciones implements Controlador{
    Sujeto modelo;
    VistaVotaciones vista;
    FilePrinter filePrinter = new FilePrinter();

    public ControladorVotaciones(Sujeto modelo){
        this.modelo = modelo;
        modelo.cargarCandidatos();
        vista = new VistaVotaciones(this, modelo);
        vista.inicializarVista();
        modelo.inicializar();
    }

    public void aumentar(String nombre) {
        filePrinter.imprimirBitacora(this.getClass().getName(), new Object(){}.getClass().getEnclosingMethod().getName());
        int numVotos = modelo.getNumVotos(nombre);
        modelo.registrarVoto(nombre, numVotos+1);
        modelo.imprimirVoto(nombre);
    }
}