package vista;

import modelo.Metodos;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner entradaUsuario = new Scanner(System.in);
        int opcion;

        System.out.println("""
                ******************************************
                    CHALLENGE: Conversor de Monedas
                ******************************************
                """);
        System.out.println("\n Esta aplicación da soporte a " +
                "161 monedas mundiales que circulan habitualmente");
        System.out.println("---------------++++++++----------------");

        do {
            System.out.println("\n Menu de opciones: ");
            System.out.println("1. Dolar estadounidense (USD) => Peso argentino (ARS)");
            System.out.println("2. Peso argentino (ARS) => Dolar estadounidense (USD)");
            System.out.println("3. Dolar estadounidense (USD) => SOL Peruano (PEN)");
            System.out.println("4. SOL Peruano (PEN) => Dolar estadounidense (USD)");
            System.out.println("5. Dolar estadounidense (USD) => Peso colombiano (COP)");
            System.out.println("6. Peso colombiano (COP) => Dolar estadounidense (USD)");
            System.out.println("7. Dolar estadounidense (USD) => Peso mexicano (MXN)");
            System.out.println("8. Peso mexicano (MXN) => Dolar estadounidense (USD)");
            System.out.println("9. Salir de la aplicacion");
            System.out.println("Por favor, elija una opcion del menu: ");
            opcion = entradaUsuario.nextInt();

            switch (opcion) {
                case 1:
                    convertirMoneda("USD", "ARS", entradaUsuario);
                    break;
                case 2:
                    convertirMoneda("ARS", "USD", entradaUsuario);
                    break;
                case 3:
                    convertirMoneda("USD", "PEN", entradaUsuario);
                    break;
                case 4:
                    convertirMoneda("PEN", "USD", entradaUsuario);
                    break;
                case 5:
