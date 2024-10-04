package com.garrido.conversor.principal;

import com.garrido.conversor.modelos.ExchangeRate;
import com.google.gson.*;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {
        Scanner lectura = new Scanner(System.in);
        List<ExchangeRate> conversiones = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        while (true){
            System.out.println("Bienvenido/a al Conversor de Moneda\n");
            System.out.println("1) Dólar =>> Peso Mexicano");
            System.out.println("2) Peso Mexicano =>> Dólar");
            System.out.println("3) Dólar =>> Real Brasileño");
            System.out.println("4) Real Brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso Colombiano");
            System.out.println("6) Peso Colombiano =>> Dólar");
            System.out.println("7) Salir");
            System.out.println("Elija una opción valida:");


            var opcion = lectura.nextInt();
            String monedaAConvertir="";
            String monedaConvertida="";

            if(opcion==7){
                System.out.println("Gracias por utilizar el conversor de monedas");
                break;
            }

            switch (opcion) {
                case 1 -> {
                    monedaAConvertir = "USD";
                    monedaConvertida = "MXN";
                }
                case 2 -> {
                    monedaAConvertir = "MXN";
                    monedaConvertida = "USD";
                }
                case 3 -> {
                    monedaAConvertir = "USD";
                    monedaConvertida = "BRL";
                }
                case 4 -> {
                    monedaAConvertir = "BRL";
                    monedaConvertida = "USD";
                }
                case 5 -> {
                    monedaAConvertir = "USD";
                    monedaConvertida = "COP";
                }
                case 6 -> {
                    monedaAConvertir = "COP";
                    monedaConvertida = "USD";
                }
                default -> throw new IllegalArgumentException("Opción inválida");
            }

            String direccion = "https://v6.exchangerate-api.com/v6/ee043825bc3ac24fd94e3fa5/latest/" +
                    monedaAConvertir;

            try{
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(direccion))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
//                System.out.println(json);


                // Deserializar a una instancia de Conversion
                ExchangeRate conversion = gson.fromJson(json, ExchangeRate.class);

//                System.out.println(conversion);
                double resultado = conversion.conversion_rates().getValue(monedaConvertida);
                String txtMonedaConvertir = conversion.conversion_rates().getValueConvertTxt(monedaAConvertir);
                String txtMonedaConvertida = conversion.conversion_rates().getValueConvertedTxt(monedaConvertida);
                System.out.println("un " + txtMonedaConvertir + " es igual a " + resultado +" " + txtMonedaConvertida);

                conversiones.add(conversion);


            }catch (IllegalArgumentException e) {
                System.out.println("Error en la URI, verifique la dirección.");
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
        //System.out.println(conversiones);
        FileWriter escritura = new FileWriter("conversiones.json");
        escritura.write(gson.toJson(conversiones));
        escritura.close();
        System.out.println("Finalizó la ejecución del programa");


    }
}
