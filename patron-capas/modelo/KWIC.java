package modelo;

import java.util.ArrayList;
import java.util.Collections;

import datos.FileReader;

public class KWIC {
    public ArrayList<String> generaCombinaciones(String entrada){
        ArrayList<String> combinaciones = new ArrayList<>();
        FileReader fileReader = new FileReader();
        String cadena = fileReader.lecturaCadena(entrada);
        cadena = cadena.toLowerCase();
        StopWords stopWords = new StopWords();
        ArrayList<String> palabrasCadena = stopWords.eliminaStopWords(cadena, fileReader);
        cadena = String.join(" ", palabrasCadena);
        do{
            combinaciones.add(cadena);
            String primera = palabrasCadena.remove(0);
            palabrasCadena.add(primera);
            cadena = String.join(" ", palabrasCadena);
        }while(combinaciones.get(0).compareTo(cadena) != 0);
        Collections.sort(combinaciones);
        return combinaciones;
    }
}
