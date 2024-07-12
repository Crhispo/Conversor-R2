package Main;

import Cliente.Cliente;
import Cliente.Datos;

public class App {

    public static void main(String[] args) {
        Datos datos = new Datos();
        String apiKey = Datos.getApiKey();
        System.out.println("Valor de apiKey desde App.java: " + apiKey);
        Cliente cliente = new Cliente();
        Cliente.Status();
    }
}
