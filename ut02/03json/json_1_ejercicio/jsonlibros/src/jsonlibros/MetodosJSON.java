package jsonlibros;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.json.JsonWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alumno
 */
public class MetodosJSON {

    /**
     *
     * @param rutaFichero
     * @throws IOException
     */
    public static void crearFichero(String rutaFichero) throws IOException {
        JsonObject libro1 = Json.createObjectBuilder()
                .add("titulo", "Sueños IA")
                .add("totalPaginas", 210)
                .add("precio", 10)
                .add("autores", Json.createArrayBuilder()//creamos el corchete
                        .add(Json.createObjectBuilder()
                                .add("nombre", "Javier")
                                .add("apellido", "Perez")
                        )//},  
                        .add(Json.createObjectBuilder()
                                .add("nombre", "María")
                                .add("apellido", "Rodriguez")
                        )//}, 
                )//],
                .add("generos", Json.createArrayBuilder()//generos:[
                        .add(Json.createObjectBuilder()//creamos{
                                .add("generos", "novela")
                        )//},
                        .add(Json.createObjectBuilder()
                                .add("genero", "ficcion")
                        )//},

                )//]
                .build();//para cerrarlo:  }]

        JsonObject libro2 = Json.createObjectBuilder()
                .add("titulo", "libros JSON")
                .add("totalPaginas", 210)
                .add("precio", 10)
                .add("autores", Json.createArrayBuilder()//creamos el corchete
                        .add(Json.createObjectBuilder()
                                .add("nombre", "Clara")
                                .add("apellido", "Perez")
                        )//},  
                        .add(Json.createObjectBuilder()
                                .add("nombre", "Elena")
                                .add("apellido", "Rodriguez")
                        )//}, 
                )//],
                .add("generos", Json.createArrayBuilder()//generos:[
                        .add(Json.createObjectBuilder()//creamos{
                                .add("generos", "novela")
                        )//},
                        .add(Json.createObjectBuilder()
                                .add("genero", "ficcion")
                        )//},

                )//]
                .build();//para cerrarlo:  }]

        JsonObject libro3 = Json.createObjectBuilder()
                .add("titulo", "libros JSON")
                .add("totalPaginas", 210)
                .add("precio", 10)
                .add("autores", Json.createArrayBuilder()//creamos el corchete
                        .add(Json.createObjectBuilder()
                                .add("nombre", "Clara")
                                .add("apellido", "Perez")
                        )//},  
                        .add(Json.createObjectBuilder()
                                .add("nombre", "Elena")
                                .add("apellido", "Rodriguez")
                        )//}, 
                )//],
                .add("generos", Json.createArrayBuilder()//generos:[
                        .add(Json.createObjectBuilder()//creamos{
                                .add("generos", "novela")
                        )//},
                        .add(Json.createObjectBuilder()
                                .add("genero", "ficcion")
                        )//},

                )//]
                .build();//para cerrarlo:  }]

        JsonObject libro4 = Json.createObjectBuilder()
                .add("titulo", "libros JSON")
                .add("totalPaginas", 210)
                .add("precio", 10)
                .add("autores", Json.createArrayBuilder()//creamos el corchete
                        .add(Json.createObjectBuilder()
                                .add("nombre", "Clara")
                                .add("apellido", "Perez")
                        )//},  
                        .add(Json.createObjectBuilder()
                                .add("nombre", "Elena")
                                .add("apellido", "Rodriguez")
                        )//}, 
                )//],
                .add("generos", Json.createArrayBuilder()//generos:[
                        .add(Json.createObjectBuilder()//creamos{
                                .add("generos", "novela")
                        )//},
                        .add(Json.createObjectBuilder()
                                .add("genero", "ficcion")
                        )//},

                )//]
                .build();//para cerrarlo:  }]

        //crea Array
        JsonArray arrayJsonLibros = Json.createArrayBuilder().add(libro1)
                .add(libro2).add(libro3).add(libro4)
                .build();

        // Escribe el fichero Json
        FileWriter ficheroSalida = new FileWriter(rutaFichero);
        JsonWriter jsonWriter = Json.createWriter(ficheroSalida);
        jsonWriter.writeArray(arrayJsonLibros);
        ficheroSalida.flush();
        ficheroSalida.close();
    }

    /**
     *
     * @param rutaFichero
     * @return
     * @throws FileNotFoundException
     */
    public static int cuentatotalLibros(String rutaFichero) throws FileNotFoundException {
        JsonArray arrayLibros = leerFicheroJSON(rutaFichero);
        return arrayLibros.size();
    }

    /**
     *
     * @param rutaFichero
     * @return
     * @throws FileNotFoundException
     */
    protected static List<String> mostrarTitulos(String rutaFichero) throws FileNotFoundException {

        List<String> listaTitulos = new ArrayList<String>();

        JsonArray arraytitulosLibros = leerFicheroJSON(rutaFichero);

        for (int i = 0; i < arraytitulosLibros.size(); i++) {
            String titulo = arraytitulosLibros.getJsonObject(i).getString("titulo");
            listaTitulos.add(titulo);
        }
        return listaTitulos;
    }

    /**
     *
     * @param rutaFichero
     * @return
     * @throws FileNotFoundException
     */
    private static JsonArray leerFicheroJSON(String rutaFichero) throws FileNotFoundException {
        FileReader entrada = new FileReader(rutaFichero);
        JsonReader jsonReader = Json.createReader(entrada);
        JsonArray arrayJSON = jsonReader.readArray();
        return arrayJSON;
    }

    /**
     * retornaNombreDeTodosLosAutores
     *
     * @param rutaFichero
     * @return
     * @throws FileNotFoundException
     */
    protected static List<String> retornaNombreDeTodosLosAutores(String rutaFichero) throws FileNotFoundException {
        List<String> listaAutores = new ArrayList<String>();
        JsonArray arrayJSONLibros = leerFicheroJSON(rutaFichero);

        for (int contadorLibros = 0; contadorLibros < arrayJSONLibros.size(); contadorLibros++) {

            for (int contadorAutores = 0; contadorAutores < arrayJSONLibros.getJsonObject(contadorLibros).getJsonArray("autores").size(); contadorAutores++) {
                listaAutores.add(arrayJSONLibros.getJsonObject(contadorLibros).getJsonArray("autores").getJsonObject(contadorAutores).getString("nombre"));
            }
        }
        return listaAutores;

    }

    // wJERCICIO  retornaNombreDeTodosLosAutores ordenados
    /**
     *
     * @param rutaFichero
     * @param posicionLibro
     * @param posicionAutor
     * @return
     * @throws FileNotFoundException
     * @throws IndexOutOfBoundsException
     */
    protected static String retornaUnAutordeUnLibro(String rutaFichero, int posicionLibro, int posicionAutor) throws FileNotFoundException, IndexOutOfBoundsException {

        JsonArray arrayJSONLibros = leerFicheroJSON(rutaFichero);
        return arrayJSONLibros.getJsonObject(posicionLibro).getJsonArray("autores").getJsonObject(posicionAutor).getString("nombre");
    }

    /**
     * retornaNombreDeTodosLosAutoresOrdenadoAlfabeticamente
     *
     * @param rutaFichero
     * @return
     * @throws FileNotFoundException
     */
    protected static List<String> retornaNombreDeTodosLosAutoresOrdenadoAlfabeticamente(String rutaFichero) throws FileNotFoundException {
        List<String> listaAutores = new ArrayList<String>();
        JsonArray arrayJSONLibros = leerFicheroJSON(rutaFichero);

        for (int contadorLibros = 0; contadorLibros < arrayJSONLibros.size(); contadorLibros++) {

            for (int contadorAutores = 0; contadorAutores < arrayJSONLibros.getJsonObject(contadorLibros).getJsonArray("autores").size(); contadorAutores++) {
                listaAutores.add(arrayJSONLibros.getJsonObject(contadorLibros).getJsonArray("autores").getJsonObject(contadorAutores).getString("nombre"));
            }
        }
        listaAutores.sort(new Comparator<String>() {
            @Override
            public int compare(String cadena1, String cadena2) {
                return cadena1.compareTo(cadena2);  // criterio ordenación cadenas
            }
        });
        return listaAutores;

    }

    /**
     * librosEnStock
     *
     * @param rutaFichero
     * @return
     * @throws FileNotFoundException
     */

    public static int precioLibrosEnStock(String rutaFichero) throws FileNotFoundException {

        JsonArray arrayJSONLibros = leerFicheroJSON(rutaFichero);
        int precioLibro = 0;
        int precioTotalLibros = 0;
        for (int i = 0; i < arrayJSONLibros.size(); i++) {
            precioLibro = arrayJSONLibros.getJsonObject(i).getInt("precio");
            precioTotalLibros += precioLibro;
        }
        return precioTotalLibros;
    }
}
