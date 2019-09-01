/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author JoseLuisArias
 */
public class operacionesFicheros {

       public static List<File> listarDirectoriosOrdenados
        
        (String ruta) {
              File directorio = new File(ruta);
              File[] arrayFiles = directorio.listFiles();

              // creacion comparador ordena por longitud del fichero
              Comparator<File> comparatorFicheros = new Comparator<File>() {
                     @Override
                     public int compare(File f1, File f2) {
                            if (f1.length() < f2.length()) {
                                   return -1;
                            } else {
                                   return 1;
                            }
                     }
              };
              List<File> listaFicheros = Arrays.asList(arrayFiles); // transforma array en lista

              // Forma 1
              Collections.sort(listaFicheros, comparatorFicheros);  // ordena con el comparador

              // Forma 2 Metodo anónimo 
              Collections.sort(listaFicheros, new Comparator<File>() {
                     @Override
                     public int compare(File f1, File f2) {
                            if (f1.length() < f2.length()) {
                                   return 1;

                            } else {
                                   return -1;
                            }
                     }
              });
              // Forma 3 Función  lambda
              Collections.sort(listaFicheros, (File f1, File f2) -> {
                     if (f1.length() < f2.length()) {
                            return 1;

                     } else {
                            return -1;
                     }
              });
              
              // Forma 4 Función  lambda con operador ?
              Collections.sort(listaFicheros, (File f1, File f2) -> f1.length() < f2.length() ? 1 : -1);

              return listaFicheros;
       }

}
