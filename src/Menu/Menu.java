package Menu;

import Cliente.Cliente;

public class Menu {

	Cliente cliente = new Cliente();

	public static void Solicitud(int Opcion, double Valor) {
		switch (Opcion) {
		// Dolares a Pesos argentinos
		case 1:
			ValoresConversor("USD", "ARS", Valor);
			break;
		// Pesos argentinos a Dolares
		case 2:
			ValoresConversor("ARS", "USD", Valor);
			break;
		// Dolares a Real brasileño
		case 3:
			ValoresConversor("USD", "BRL", Valor);
			break;
		// Real brasileño a Dolares
		case 4:
			ValoresConversor("BRL", "USD", Valor);
			break;
		// Dolares a Pesos Colombianos
		case 5:
			ValoresConversor("USD", "COP", Valor);
			break;
		// Pesos Colombianos a Dolares
		case 6:
			ValoresConversor("COP", "USD", Valor);
			break;
		}
	}

	public static void ValoresConversor(String Entrada, String Salida, double Monto) {
		Cliente.Consulta(Entrada, Salida, Monto);
	}

}