import controlador.Controlador;
import controlador.ControladorVotaciones;
import modelo.Encuesta;
import modelo.Sujeto;

public class VotacionesApp {
    public static void main(String[] args) {
        Sujeto modelo = new Encuesta();
        Controlador controlador = new ControladorVotaciones(modelo);
    }    
}