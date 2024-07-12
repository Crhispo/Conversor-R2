package Cliente;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Cliente {

    static String config = Datos.getApiKey();
    static String YOUR_API_KEY = config;

    public Cliente() {
    }

    public static void Status() {

        // Crea una instancia de HttpClient
        HttpClient httpClient = HttpClient.newHttpClient();

        // Define la URL de la solicitud
        String url = "https://v6.exchangerate-api.com/v6/" + YOUR_API_KEY + "/pair/EUR/GBP";

        // Crea una solicitud GET
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        try {
            // Realiza la solicitud y obtiene la respuesta
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // Verifica el código de estado de la respuesta
            if (response.statusCode() == 200) {
                System.out.println("La solicitud fue exitosa (código 200).");
                // Aquí puedes procesar la respuesta según tus necesidades
            } else {
                System.out.println("La solicitud no fue exitosa (código " + response.statusCode() + ").");
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Error al realizar la solicitud: " + e.getMessage());
        }
    }
}
