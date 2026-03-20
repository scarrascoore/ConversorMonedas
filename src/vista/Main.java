package vista;

import modelo.Metodos;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        mostrarMenu();
    }

    public static void mostrarMenu() {
        Scanner entradaUsuario = new Scanner(System.in);
        int opcion = -1;

        System.out.print("""                
                ******************************************
                    CHALLENGE: Conversor de Monedas
                ******************************************
                """);
        System.out.print("\nEsta aplicación da soporte a monedas \n" +
                "mundiales que circulan habitualmente");
        System.out.println("\n---------------------------------------\n");

        do {
            System.out.println("MENU DE OPCIONES: ");
            System.out.println("1. Dólar estadounidense (USD) => Peso argentino (ARS)");
            System.out.println("2. Peso argentino (ARS) => Dólar estadounidense (USD)");
            System.out.println("3. Dólar estadounidense (USD) => Sol peruano (PEN)");
            System.out.println("4. Sol peruano (PEN) => Dólar estadounidense (USD)");
            System.out.println("5. Dólar estadounidense (USD) => Peso colombiano (COP)");
            System.out.println("6. Peso colombiano (COP) => Dólar estadounidense (USD)");
            System.out.println("7. Dólar estadounidense (USD) => Peso mexicano (MXN)");
            System.out.println("8. Peso mexicano (MXN) => Dólar estadounidense (USD)");
            System.out.println("9. Salir de la aplicación");
            System.out.print("\nPor favor, elija una opción del menú: ");

            try {
                opcion = entradaUsuario.nextInt();

                switch (opcion) {
                    case 1 -> convertir("USD", "ARS", entradaUsuario);
                    case 2 -> convertir("ARS", "USD", entradaUsuario);
                    case 3 -> convertir("USD", "PEN", entradaUsuario);
                    case 4 -> convertir("PEN", "USD", entradaUsuario);
                    case 5 -> convertir("USD", "COP", entradaUsuario);
                    case 6 -> convertir("COP", "USD", entradaUsuario);
                    case 7 -> convertir("USD", "MXN", entradaUsuario);
                    case 8 -> convertir("MXN", "USD", entradaUsuario);
                    case 9 -> System.out.println("¡Cerrando aplicación...!");
                    default -> System.out.println("Opción inválida. Intenta nuevamente.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Debes ingresar un número.");
                entradaUsuario.nextLine();
            }

            System.out.println();

        } while (opcion != 9);

        entradaUsuario.close();
    }

    public static void convertir(String from, String to, Scanner scanner) {
        try {
            System.out.printf("Ingresa la cantidad de %s a convertir: ", from);
            double amount = scanner.nextDouble();

            Metodos conversion = new Metodos(from, to, amount);
            double resultado = conversion.convert();

            System.out.println("-------------------------------");
            System.out.println("        -  RESULTADO  -    ");
            System.out.printf("  ➡ %.2f %s = %.2f %s%n", amount, from, resultado, to);
            System.out.println("-------------------------------");

        } catch (InputMismatchException e) {
            System.out.println("Cantidad inválida. Debes ingresar un número.");
            scanner.nextLine();
        } catch (IOException | InterruptedException e) {
            System.out.println("Error de conexión o conversión: " + e.getMessage());
        }
    }
}
