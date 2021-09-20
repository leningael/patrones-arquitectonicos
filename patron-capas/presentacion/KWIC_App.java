package presentacion;

import java.util.ArrayList;

import modelo.KWIC;

public class KWIC_App {
    public static void main(String[] args) {
        KWIC algoritmoKWIC = new KWIC();
        ArrayList<String> cadenas = algoritmoKWIC.generaCombinaciones(args[0]);
        imprimeResultado(cadenas);
    }

    private static void imprimeResultado(ArrayList<String> cadenas){
        System.out.println("Lista de Indices:\n");
        for(int i = 0; i < cadenas.size(); i++){
            System.out.println(cadenas.get(i));
        }
    }
}
