package Main;

import ConversorApi.ConversorHistorial;
import ConversorApi.SolicitudesApi;
import Modelo.Monedas;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        SolicitudesApi consulta = new SolicitudesApi();

        Monedas monedas = null;
        int opcion = 0;
        Double monto = 0.0;

        do {
            System.out.println("*********************************\n");
            System.out.println("Bienvenido al conversor de monedas!\n");
            System.out.println("1. Dolar a Peso Argentino");
            System.out.println("2. Peso Argentino a Dolar");
            System.out.println("3. Dolar a Real Brasileño");
            System.out.println("4. Real Brasileño a Dolar");
            System.out.println("5. Dolar a Peso Colombiano");
            System.out.println("6. Peso Colombiano a Dolar");
            System.out.println("7. Dolar a Lempira");
            System.out.println("8. Lempira a Dolar");
            System.out.println("9. Mostrar Historial de Conversiones");
            System.out.println("10. Salir del programa");
            System.out.print("\nIngrese una de las opciones: ");

            try {
                opcion = Integer.parseInt(entrada.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el monto a convertir: ");
                        monto = Double.parseDouble(entrada.nextLine());
                        monedas = consulta.conversor("USD", "ARS", monto);
                        ConversorHistorial.mostrarResultado(monto, monedas.conversion_result(),
                                "USD", "ARS");
                        break;
                    case 2:
                        System.out.print("Ingrese el monto a convertir: ");
                        monto = Double.parseDouble(entrada.nextLine());
                        monedas = consulta.conversor("ARS", "USD", monto);
                        ConversorHistorial.mostrarResultado(monto, monedas.conversion_result(),
                                "ARS", "USD");
                        break;
                    case 3:
                        System.out.print("Ingrese el monto a convertir: ");
                        monto = Double.parseDouble(entrada.nextLine());
                        monedas = consulta.conversor("USD", "BRL", monto);
                        ConversorHistorial.mostrarResultado(monto, monedas.conversion_result(),
                                "USD", "BRL");
                        break;
                    case 4:
                        System.out.print("Ingrese el monto a convertir: ");
                        monto = Double.parseDouble(entrada.nextLine());
                        monedas = consulta.conversor("BRL", "USD", monto);
                        ConversorHistorial.mostrarResultado(monto, monedas.conversion_result(),
                                "BRL", "USD");
                        break;
                    case 5:
                        System.out.print("Ingrese el monto a convertir: ");
                        monto = Double.parseDouble(entrada.nextLine());
                        monedas = consulta.conversor("USD", "COP", monto);
                        ConversorHistorial.mostrarResultado(monto, monedas.conversion_result(),
                                "USD", "COP");
                        break;
                    case 6:
                        System.out.print("Ingrese el monto a convertir: ");
                        monto = Double.parseDouble(entrada.nextLine());
                        monedas = consulta.conversor("COP", "USD", monto);
                        ConversorHistorial.mostrarResultado(monto, monedas.conversion_result(),
                                "COP", "USD");
                        break;
                    case 7:
                        System.out.print("Ingrese el monto a convertir: ");
                        monto = Double.parseDouble(entrada.nextLine());
                        monedas = consulta.conversor("USD", "HNL", monto);
                        ConversorHistorial.mostrarResultado(monto, monedas.conversion_result(),
                                "USD", "HNL");
                        break;
                    case 8:
                        System.out.print("Ingrese el monto a convertir: ");
                        monto = Double.parseDouble(entrada.nextLine());
                        monedas = consulta.conversor("HNL", "USD", monto);
                        ConversorHistorial.mostrarResultado(monto, monedas.conversion_result(),
                                "HNL", "USD");
                        break;
                    case 9:
                        ConversorHistorial.mostrarHistorial();
                        break;
                    case 10:
                        System.out.println("\nFinalizando programa....");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción no válida!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: No se permiten letras!");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (opcion != 10);
    }
}