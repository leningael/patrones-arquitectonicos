package modelo;

import java.util.ArrayList;
import datos.FileReader;

public class StopWords {
    public ArrayList<String> eliminaStopWords(String cadena, FileReader fileReader){
        ArrayList<String> stopWordsList = fileReader.lecturaStopWords();
        String[] palabras = cadena.split(" ");
        ArrayList<String> cadenaFinal = new ArrayList<>();
        boolean esStopWord;
        for(int i = 0; i < palabras.length; i++){
            esStopWord = false;
            for(int j = 0; j < stopWordsList.size() && !esStopWord; j++){
                if(palabras[i].compareTo(stopWordsList.get(j)) == 0)
                    esStopWord = true;
            }
            if(!esStopWord)
                cadenaFinal.add(palabras[i]);
        }
        return cadenaFinal;
    }
}
