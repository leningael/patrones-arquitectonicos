## Pasos para compilar y ejecutar el programa:
Tanto para la compilación como para la ejecución será necesario acceder a la carpeta del programa mediante la consola.

### Compilación:
Se debe ingresar el siguiente comando:   
javac Aplicacion/KWIC_App.java

### Ejecución:
Una vez generados los .class procedemos con la ejecución mediante el siguiente comando:  
java Aplicacion.KWIC_App parametro1 parametro2  
Donde el parametro1 es el nombre del archivo de texto que contiene las cadenas y debe de estar en la carpeta del proyecto.  
Y el parametro 2 es el archivo con las stop words.  
Como ejemplo supongamos que en la carpeta del programa se tiene el archivo cadenas.txt y stopwords.txt:  
java Aplicacion.KWIC_APP cadenas.txt stopwords.txt
