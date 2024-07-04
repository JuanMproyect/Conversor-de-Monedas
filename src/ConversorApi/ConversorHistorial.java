package ConversorApi;

import Main.Principal;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ConversorHistorial extends Principal {
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private static final List<String> historial = new ArrayList<>();

    public static void mostrarResultado(double montoInicial, double montoConvertido, String baseCode,
                                        String targetCode) {
        DecimalFormat df = new DecimalFormat("0.00");
        String resultado = "El monto es: " + df.format(montoConvertido) + " " + targetCode;
        System.out.println(resultado);

        String timestamp = dtf.format(LocalDateTime.now());
        String registro = "Conversión: " + df.format(montoInicial) + " " + baseCode + " a "
                + df.format(montoConvertido) + " " + targetCode + " el " + timestamp;
        historial.add(registro);
    }

    public static void mostrarHistorial() {
        System.out.println("\nHistorial de Conversiones:");
        for (String registro : historial) {
            System.out.println(registro);
        }
    }
}
