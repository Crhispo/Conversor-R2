package Cliente;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

class Resultado {
	private String base_code;
	private String target_code;
	private double conversion_result;

	public String getBase_code() {
		return base_code;
	}

	public void setBase_code(String base_code) {
		this.base_code = base_code;
	}

	public String getTarget_code() {
		return target_code;
	}

	public void setTarget_code(String target_code) {
		this.target_code = target_code;
	}

	public double getConversion_result() {
		return conversion_result;
	}

	public void setConversion_result(double conversion_result) {
		this.conversion_result = conversion_result;
	}

}

public class Cliente {

	static String YOUR_API_KEY = Datos.getApiKey();

	// Crea una instancia de HttpClient
	static HttpClient httpClient = HttpClient.newHttpClient();

	public Cliente() {
	}

	public static void Consulta(String E, String S, double Valor) {

		// Define la URL de la solicitud
		String url = "https://v6.exchangerate-api.com/v6/" + YOUR_API_KEY + "/pair/" + E + "/" + S + "/" + Valor;

		// Crea una solicitud GET
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
		try {
			// Realiza la solicitud y obtiene la respuesta
			HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

			// Verifica el código de estado de la respuesta
			if (response.statusCode() == 200) {

				Gson gson = new Gson();
				Resultado resultado = gson.fromJson(response.body(), Resultado.class);
				System.out.println(" ");
				System.out.println("El valor de: " + Valor + " [" + resultado.getBase_code()
						+ "] corresponde al valor final de =>>> " + resultado.getConversion_result() + " ["
						+ resultado.getTarget_code() + "] ");
				System.out.println(" ");

			} else {
				System.out.println("La solicitud no fue exitosa (código " + response.statusCode() + ").");
			}
		} catch (IOException | InterruptedException e) {
			System.err.println("Error al realizar la solicitud: " + e.getMessage());

		}

	}
}
