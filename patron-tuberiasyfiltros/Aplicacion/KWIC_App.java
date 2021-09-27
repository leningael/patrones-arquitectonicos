package Aplicacion;

import java.util.ArrayList;
import java.util.Collections;

import Modelo.*;

import Patron.Pipe;

public class KWIC_App {
    public static void main(String[] args) {
        ArrayList<String> argumentos = new ArrayList<>();
        Collections.addAll(argumentos, args);
        Pipe pipe = new Pipe();
        pipe.registrar(new PhraseReader());
        pipe.registrar(new StopWords());
        pipe.registrar(new KWIC());
        ArrayList<ArrayList<String>> rotationsEachPhrase = (ArrayList<ArrayList<String>>)pipe.ejecutar(argumentos);
        imprimeResultado(rotationsEachPhrase);
    }

    private static void imprimeResultado(ArrayList<ArrayList<String>> allPhrases){
        System.out.println("Lista de Indices:\n");
        for(int i = 0; i < allPhrases.size(); i++){
            System.out.println("Palabra num. " + (i+1));
            for(int j = 0; j < allPhrases.get(i).size(); j++){
                System.out.println(allPhrases.get(i).get(j));
            }
            System.out.println();
        }
    }
}
