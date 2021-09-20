package datos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
    private File archivoEntrada;
    private Scanner scArchivo;
    
    public String lecturaCadena(String cadena){
        String linea = new String();
        try{
            archivoEntrada = new File(cadena);
            scArchivo = new Scanner(archivoEntrada);
            linea = scArchivo.nextLine();                
            linea = eliminaEspacios(linea);
            scArchivo.close();
        }catch(FileNotFoundException e1){
            System.out.println("El archivo de la cadena especificado no existe.");
        }
        return linea;
    }

    public ArrayList<String> lecturaStopWords(){
        ArrayList<String> stopWords = new ArrayList<>();
        try{
            archivoEntrada = new File("datos/stopwords.txt");
            scArchivo = new Scanner(archivoEntrada);
            while(scArchivo.hasNextLine()){
                String linea = scArchivo.nextLine();
                linea = eliminaEspacios(linea);               
                stopWords.add(linea);
            }
            scArchivo.close();
        }catch(FileNotFoundException e1){
            System.out.println("El archivo de stop words especificado no existe.");
        }
        return stopWords;
    }

    private String eliminaEspacios(String linea){
        String cadena;
        cadena = linea.trim();
        cadena = linea.replaceAll("\\s{2,}", " "); //Reemplaza 2 o más espacios en blanco por uno.
        return cadena;
    }
}