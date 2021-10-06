package modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
    private File archivoEntrada;
    private Scanner scArchivo;

    public ArrayList<String> lecturaCandidatos(){
        ArrayList<String> nombresProductos = new ArrayList<>();
        try{
            archivoEntrada = new File("archivos/candidatos.txt");
            scArchivo = new Scanner(archivoEntrada);
            while(scArchivo.hasNextLine()){
                String producto = scArchivo.nextLine();
                producto = eliminaEspacios(producto);               
                nombresProductos.add(producto);
            }
            scArchivo.close();
        }catch(FileNotFoundException e1){
            System.out.println("El archivo de productos no se ha encontrado.");
        }
        return nombresProductos;
    }

    public int conteoVotos(String ruta){
        int numVotos = 0;
        try{
            archivoEntrada = new File("archivos/"+ruta+".txt");
            if(archivoEntrada.exists()){
                scArchivo = new Scanner(archivoEntrada);
                while(scArchivo.hasNextLine()){
                    numVotos++;
                    scArchivo.nextLine();
                }
            }
            scArchivo.close();
        }catch(IOException e1){
            System.out.println("Error con el archivo que contiene los votos.");
        }
        return numVotos;
    }

    private String eliminaEspacios(String linea){
        String cadena;
        cadena = linea.trim();
        cadena = linea.replaceAll("\\s{2,}", " "); //Reemplaza 2 o más espacios en blanco por uno.
        return cadena;
    }
}
