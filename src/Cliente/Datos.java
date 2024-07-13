package Cliente;

import com.google.gson.Gson;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

// Clase Json que facilita leer el archivo config.json

class Json {

	private String apiKey;

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

}

public class Datos {

	// Lee el archivo config.json desde el src el cual contiene la Api Key

	static InputStream inputStream = Datos.class.getResourceAsStream("/config.json");
	static Reader reader = new InputStreamReader(inputStream);
	static Gson gson = new Gson();

	static Json apiKey = gson.fromJson(reader, Json.class);

	public static String getApiKey() {

		return apiKey.getApiKey();
	}

}
