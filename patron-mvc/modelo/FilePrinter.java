package modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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

    public void imprimirBitacora(String clase, String metodo){
        String timeStamp = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss").format(Calendar.getInstance().getTime());
        try{
            archivoSalida = new FileWriter("archivos/bitacora.txt", true);
            escribir = new PrintWriter(archivoSalida);
            escribir.println("Fecha: " + timeStamp + " clase: " + clase + " metodo: " + metodo);
            escribir.close();
            archivoSalida.close();
        }catch(IOException e1){
            System.out.println("Error en la creación del archivo de salida");
        }
    }
}
