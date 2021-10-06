package modelo;


public class Candidato{
    String nombre;
    int numVotos;

    public Candidato(String nombre) {
        this.nombre = nombre;
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
    }
}
