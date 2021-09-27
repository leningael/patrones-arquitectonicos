package Modelo;

import java.util.ArrayList;

import Patron.Filter;

public class StopWords extends Filter{

    @Override
    protected Object procesar(Object entrada) {
        ArrayList<ArrayList<String>> input = (ArrayList<ArrayList<String>>)entrada;
        ArrayList<ArrayList<String>> wordsOfEachPhrase = removeAllStopWords((ArrayList<String>)input.get(0), input.get(1));
        return wordsOfEachPhrase;
    }

    private ArrayList<ArrayList<String>> removeAllStopWords(ArrayList<String> cadenas, ArrayList<String> stopWordsList){
        ArrayList<ArrayList<String>> wordsOfEachPhrase = new ArrayList<>();
        for(int i = 0; i < cadenas.size(); i++)
            wordsOfEachPhrase.add(removeStopWords(cadenas.get(i), stopWordsList));
        return wordsOfEachPhrase;
    }

    private ArrayList<String> removeStopWords(String cadena, ArrayList<String> stopWordsList){
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
