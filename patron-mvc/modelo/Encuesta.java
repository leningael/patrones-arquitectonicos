package modelo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class Encuesta implements Sujeto{
    ArrayList<Observador> observadores = new ArrayList<Observador>();
    HashMap<String, Candidato> candidatos = new HashMap<>();
    FileReader fileReader = new FileReader();
    FilePrinter filePrinter = new FilePrinter();
    ArrayList<String> nombresCandidatos = new ArrayList<>();

    public void cargarCandidatos(){
        filePrinter.imprimirBitacora(this.getClass().getName(), new Object(){}.getClass().getEnclosingMethod().getName());
        nombresCandidatos = fileReader.lecturaCandidatos();
        registrarCandidato(nombresCandidatos.get(0));
        registrarCandidato(nombresCandidatos.get(1));
        registrarCandidato(nombresCandidatos.get(2));
    }

    public void inicializar() {
        int numVotos;
        numVotos = fileReader.conteoVotos(nombresCandidatos.get(0));
        registrarVoto(nombresCandidatos.get(0), numVotos);
        numVotos = fileReader.conteoVotos(nombresCandidatos.get(1));
        registrarVoto(nombresCandidatos.get(1), numVotos);
        numVotos = fileReader.conteoVotos(nombresCandidatos.get(2));
        registrarVoto(nombresCandidatos.get(2), numVotos);
    }

    public void registrarCandidato(String nombre){
        candidatos.put(nombre, new Candidato(nombre));
    }

    public String getNombreCandidato(int indice){
        return nombresCandidatos.get(indice);
    }

    public void registrarVoto(String nombre, int numVotos){
        filePrinter.imprimirBitacora(this.getClass().getName(), new Object(){}.getClass().getEnclosingMethod().getName());
        candidatos.get(nombre).setNumVotos(numVotos);
        notificarVista(nombre);
    }

    public void imprimirVoto(String nombre){
        String timeStamp = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss").format(Calendar.getInstance().getTime());
        filePrinter.imprimirVoto(nombre, timeStamp);
    }

    public int getNumVotos(String nombre){
        return candidatos.get(nombre).numVotos;
    }

    public void registrarObservador(Observador o) {
        observadores.add(o);
    }

    public void removerObservador(Observador o) {
        int i = observadores.indexOf(o);
        if (i >= 0)
            observadores.remove(i);
    }
    
    public void notificarVista(String nombre){
        filePrinter.imprimirBitacora(this.getClass().getName(), new Object(){}.getClass().getEnclosingMethod().getName());
        for(int i = 0; i < observadores.size(); i++){
            Observador observador = (Observador)observadores.get(i);
            observador.actualizacion(nombre);
        }
    }
}
