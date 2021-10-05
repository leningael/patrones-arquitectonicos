import controlador.Controlador;
import controlador.ControladorVotaciones;
import modelo.Candidato;
import modelo.Sujeto;

public class VotacionesApp {
    public static void main(String[] args) {
        Sujeto modelo = new Candidato();
        Controlador controlador = new ControladorVotaciones(modelo);
    }    
}