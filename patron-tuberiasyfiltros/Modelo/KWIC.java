package Modelo;

import java.util.ArrayList;
import java.util.Collections;

import Patron.Filter;

public class KWIC extends Filter{

    @Override
    protected Object procesar(Object entrada) {
        ArrayList<ArrayList<String>> rotationsEachPhrase = doAllRotations((ArrayList<ArrayList<String>>) entrada);
        return rotationsEachPhrase;
    }
    
    private ArrayList<ArrayList<String>> doAllRotations(ArrayList<ArrayList<String>> wordsOfEachPhrase){
        ArrayList<ArrayList<String>> rotationsEachPhrase = new ArrayList<>();
        for(int i = 0; i < wordsOfEachPhrase.size(); i++)
            rotationsEachPhrase.add(doRotationPhrase(wordsOfEachPhrase.get(i)));
        return rotationsEachPhrase;
    }

    private ArrayList<String> doRotationPhrase(ArrayList<String> wordsPhrase){
        ArrayList<String> rotationsPhrase = new ArrayList<>();
        ArrayList<String> phrase = wordsPhrase;
        String cadena = String.join(" ", phrase);
        do{
            rotationsPhrase.add(cadena);
            String primera = wordsPhrase.remove(0);
            wordsPhrase.add(primera);
            cadena = String.join(" ", wordsPhrase);
        }while(rotationsPhrase.get(0).compareTo(cadena) != 0);
        Collections.sort(rotationsPhrase);
        return rotationsPhrase;
    }
}
