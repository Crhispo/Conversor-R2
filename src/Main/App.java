package Main;

import java.util.Scanner;

import Menu.Menu;

public class App {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int opcion;
		double valor;

		do {
			mostrarMenu();
			opcion = scanner.nextInt();

			if (opcion >= 1 && opcion <= 6) {
				System.out.print("Ingresa el valor: ");
				valor = scanner.nextDouble();
				Menu.Solicitud(opcion, valor);
			} else if (opcion == 7) {
				System.out.println("Gracias por usar el aplicativo.");
			} else {
				System.out.println("Opción no válida. Inténtalo nuevamente.");
			}

		} while (opcion != 7);

		scanner.close();
	}

	public static void mostrarMenu() {
		System.out.println("=== Conversor de Monedas ===");
		System.out.println("1. Dolares a Pesos argentinos");
		System.out.println("2. Pesos argentinos a Dolares");
		System.out.println("3. Dolares a Real brasileño");
		System.out.println("4. Real brasileño a Dolares");
		System.out.println("5. Dolares a Pesos Colombianos");
		System.out.println("6. Pesos Colombianos a Dolares");
		System.out.println("7. Salir");
		System.out.print("Elige una opción: ");
	}

}
