package modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FilePrinter {
    FileWriter archivoSalida;
    PrintWriter escribir;
    
    public void imprimirVoto(String nombre, String fecha){
        try{
            archivoSalida = new FileWriter("archivos/"+nombre+".txt", true);
            escribir = new PrintWriter(archivoSalida);
            escribir.println(fecha);
            escribir.close();
            archivoSalida.close();
        }catch(IOException e1){
            System.out.println("Error en la creación del archivo de salida");
        }
        
    }
}
