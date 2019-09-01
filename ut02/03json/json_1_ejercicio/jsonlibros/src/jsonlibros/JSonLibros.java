/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonlibros;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JSonLibros {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) {

        // test parte a
        try {
            MetodosJSON.crearFichero("salidaLibros");
        } catch (IOException ex) {
            System.err.println("error ficchero");
        }
        // test parte b

        try {
            int totalLibros = MetodosJSON.cuentatotalLibros("salidaLibros");
            System.out.println("Total libors:" + totalLibros);

        } catch (FileNotFoundException ex) {
            System.out.println("Fiechro no encontrado");
        }

        try {
            List<String> listaTitulos = MetodosJSON.mostrarTitulos("salidaLibros");

            for (String titulo : listaTitulos) {
                System.out.println(titulo);

            }

        } catch (FileNotFoundException ex) {
            System.out.println("fichero no ncontrado");
        }

        try {
            // parte D
            String retornoAutordeLibro = MetodosJSON.retornaUnAutordeUnLibro("salidalibros", 1, 1);
            System.out.println("Autor->" + retornoAutordeLibro);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JSonLibros.class.getName()).log(Level.SEVERE, null, ex);

        } catch (IndexOutOfBoundsException ex) {
            System.err.println("Indice No válido");
        }

        try {
            List<String> nombreDeTodosLosAutores = MetodosJSON.retornaNombreDeTodosLosAutores("salidalibros");
            for (String nombreAutor : nombreDeTodosLosAutores) {
                System.out.println(nombreAutor);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JSonLibros.class.getName()).log(Level.SEVERE, null, ex);

        }

        try {
            List<String> nombreDeTodosLosAutores = MetodosJSON.retornaNombreDeTodosLosAutoresOrdenadoAlfabeticamente("salidalibros");
            for (String nombreAutor : nombreDeTodosLosAutores) {
                System.out.println("Ordenado--->" + nombreAutor);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JSonLibros.class.getName()).log(Level.SEVERE, null, ex);

        }

        try {
            int precioLibrosEnStock = MetodosJSON.precioLibrosEnStock("salidaLibros");
            System.out.println("Precio libros en Stock:" + precioLibrosEnStock);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JSonLibros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        

    }
}
