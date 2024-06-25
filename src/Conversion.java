import java.util.Scanner;

public class Conversion {

    public static void conversionDivisas(String divisaInicial, String divisaFinal,
                                         ConsultaDivisas consulta, Scanner lectura) {
        double cantidad;
        double cantidadConversion;

        TasaDeCambio tasa = consulta.buscarDivisa(divisaInicial, divisaFinal);
        try {
            System.out.println("Ingrese la cantidad que desea convertir de " +
                    divisaInicial);
            cantidad = Double.parseDouble(lectura.nextLine());
            cantidadConversion = cantidad * tasa.conversion_rate();
            System.out.println(cantidad + " "+ divisaInicial + " equivale a " +
                    cantidadConversion + " " + divisaFinal + ".\nTipo de cambio: " +
                    tasa.conversion_rate() + "\n");
            System.out.println("------------------------------------------------------------------------");
        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingrese una cantidad con número");
        }
    }
}
