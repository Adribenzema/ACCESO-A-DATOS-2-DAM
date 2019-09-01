/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonString;
import javax.json.JsonWriter;

/**
 *
 * @author Jose Luis Arias
 */
public class JsonEx {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        // TODO code application logic here
        //JsonObject jsonObjetc = Json.createObjectBuilder().
        
        

        
        
        
        JsonObject value = Json.createObjectBuilder()
                .add("nombre", "Sara")
                .add("apellido", "Garcia")
                .add("edad", 21)
                .add("direccion", Json.createObjectBuilder()
                        .add("calle", "Uria 12")
                        .add("ciudad", "Avilés")
                        .add("provincia", "Asturias")
                        .add("codigo", "33401"))
                .add("telefono", Json.createArrayBuilder()
                        .add(Json.createObjectBuilder()
                                .add("tipo", "casa")
                                .add("numero", "985-213344"))
                        .add(Json.createObjectBuilder()
                                .add("tipo", "fax")
                                .add("numero", "985-213355")))
                .build();
        
        
        // ejemplo con obtetos mutables  (builders)
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        JsonObjectBuilder objeto1 = Json.createObjectBuilder().add("nombre", "Sara");
        JsonObjectBuilder objeto2 = Json.createObjectBuilder().add("nombre", "Carmen");
        JsonArray jsonArray = arrayBuilder.add(objeto1).add(objeto2).build();
        

        
        
        
        
        
        
        System.out.println(value.toString());

        JsonObject value2 = Json.createObjectBuilder()
                .add("nombre", "Maria")
                .add("apellido", "Pérez")
                .add("edad", 21)
                .add("direccion", Json.createObjectBuilder()
                        .add("calle", "Covadonga 2")
                        .add("ciudad", "Oviedo")
                        .add("provincia", "Asturias")
                        .add("codigo", 33011))
                .add("telefono", Json.createArrayBuilder()
                        .add(Json.createObjectBuilder()
                                .add("tipo", "casa")
                                .add("numero", "984-213344"))
                        .add(Json.createObjectBuilder()
                                .add("tipo", "fax")
                                .add("numero", "984-213355")))
                .build();

        // ejemplo acceso al "nombre" de un JsonObject
       
      
        
        JsonString nombre = value.getJsonString("nombre");
        System.out.println("nombre:"+nombre.toString());
        
        
        JsonNumber edad = value.getJsonNumber("edad");
        
        System.out.println("edad:"+edad.toString());
        

        // ejemplo acceso a "ciudad"
        
        String ciudad = value.getJsonObject("direccion").getString("ciudad");
        System.out.println(ciudad);

        // Crear un Array de Json        
        JsonArray arrayJson = Json.createArrayBuilder().add(value)
                .add(value2)
                .build();
        


        // Escribe el fichero Json
        FileWriter ficheroSalida = new FileWriter("salida.json");
        JsonWriter jsonWriter = Json.createWriter(ficheroSalida);
        jsonWriter.writeArray(arrayJson);
        ficheroSalida.flush();
        ficheroSalida.close();

        // Ejemplo entrada
        FileReader entrada = new FileReader("salida.json");
        JsonReader jsonReader = Json.createReader(entrada);
        JsonArray readedArray = jsonReader.readArray();

         // Ver todos los nombres del fichero leido
        for (int i = 0; i < readedArray.size(); i++) {

            String nombreLeido = readedArray.getJsonObject(i).getString("nombre");
            System.out.println(i + ":nombre: " + nombreLeido);
        }


    }

}
