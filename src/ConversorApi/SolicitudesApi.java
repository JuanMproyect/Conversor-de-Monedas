package ConversorApi;

import Modelo.Monedas;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SolicitudesApi {
    public Monedas conversor(String baseCode, String targetCode, Double monto) {
        String apiKey = "6ea051f7244157c7fd9a267a";
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + baseCode + "/" + targetCode + "/" + monto);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return new Gson().fromJson(response.body(), Monedas.class);
            } else {
                throw new RuntimeException("Error en la API: " + response.body());
            }
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException("Error al conectar con la API de conversión de monedas", e);
        }
    }
}