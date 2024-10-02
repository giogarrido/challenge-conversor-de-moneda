package com.garrido.conversor.principal;

import com.garrido.conversor.modelos.Conversion;
import com.garrido.conversor.modelos.ConversionRates;
import com.google.gson.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);


        while (true){
            System.out.println("Elija una opción valida:");
/*            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .setPrettyPrinting()
                    .create();*/
            var opcion = lectura.nextInt();
            var monedaAConvertir="";
            var monedaConvertida="";

            if(opcion==7){
                System.out.println("Gracias por utilizar el conversor de monedas");
                break;
            }
            switch (opcion){
                case 1 :
                    monedaAConvertir="USD";
                    monedaConvertida="MXN";
                    break;

                case 2 :
                    monedaAConvertir="MXN";
                    monedaConvertida="USD";
                    break;

                case 3 :
                    monedaAConvertir="USD";
                    monedaConvertida="BRL";
                    break;

                case 4 :
                    monedaAConvertir="BRL";
                    monedaConvertida="USD";
                    break;

                case 5 :
                    monedaAConvertir="USD";
                    monedaConvertida="COP";
                    break;

                case 6 :
                    monedaAConvertir="COP";
                    monedaConvertida="USD";
                    break;

            }

            String direccion = "https://v6.exchangerate-api.com/v6/ee043825bc3ac24fd94e3fa5/latest/" +
                    monedaAConvertir;

            try{
//                HttpClient client = HttpClient.newHttpClient();
//                HttpRequest request = HttpRequest.newBuilder()
//                        .uri(URI.create(direccion))
//                        .build();
//                HttpResponse<String> response = client
//                        .send(request, HttpResponse.BodyHandlers.ofString());
//
//                String json = response.body();
//                System.out.println(json);

                URL url = new URL(direccion);
                HttpURLConnection request = (HttpURLConnection) url.openConnection();
                request.connect();

//                JsonParser jp = new JsonParser();
//                JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
//                JsonObject jsonobj = root.getAsJsonObject();


                // Obtener el contenido de la respuesta en JSON
                InputStreamReader reader = new InputStreamReader(request.getInputStream());

                // Crear instancia de Gson
                Gson gson = new Gson();

                // Deserializar a una instancia de Conversion
                Conversion conversion = gson.fromJson(reader, Conversion.class);

                // Cerrar el InputStreamReader
                reader.close();

                System.out.println(conversion);
                System.out.println("un " + monedaAConvertir);
                double resultado = conversion.conversion_rates().getValue(monedaConvertida);
                System.out.println("Es igual a " + resultado +" " + monedaConvertida);


            }catch (IllegalArgumentException e) {
                System.out.println("Error en la URI, verifique la dirección.");
            } catch (IOException e) {
                throw new RuntimeException(e);

            }


        }

    }
}
