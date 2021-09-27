package Modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Patron.Filter;

public class FileReader extends Filter{

    @Override
    protected Object procesar(Object entrada) {
        ArrayList<String> input = (ArrayList<String>)entrada;
        ArrayList<ArrayList<String>> output = new ArrayList<>(); 
        output.add(lecturaFrases(input.get(0)));
        output.add(lecturaStopWords(input.get(1)));
        return output;
    }
    
    private ArrayList<String> lecturaFrases(String entrada){
        ArrayList<String> phrases = new ArrayList<>();
        try{
            File archivoEntrada = new File(entrada);
            Scanner  scArchivo = new Scanner(archivoEntrada);
            while(scArchivo.hasNextLine()){
                String linea = scArchivo.nextLine();
                linea = eliminaEspacios(linea);   
                linea = linea.toLowerCase();            
                phrases.add(linea);
            }
            scArchivo.close();
        }catch(FileNotFoundException e1){
            System.out.println("El archivo con las frases especificado no existe.");
        }
        return phrases;
    }

    private String eliminaEspacios(String linea){
        String cadena;
        cadena = linea.trim();
        cadena = linea.replaceAll("\\s{2,}", " "); //Reemplaza 2 o más espacios en blanco por uno.
        return cadena;
    }

    private ArrayList<String> lecturaStopWords(String entrada){
        ArrayList<String> stopWords = new ArrayList<>();
        try{
            File archivoEntrada = new File(entrada);
            Scanner scArchivo = new Scanner(archivoEntrada);
            while(scArchivo.hasNextLine()){
                String linea = scArchivo.nextLine();    
                stopWords.add(linea);
            }
            scArchivo.close();
        }catch(FileNotFoundException e1){
            System.out.println("El archivo de stop words especificado no existe.");
        }
        return stopWords;
    }
}