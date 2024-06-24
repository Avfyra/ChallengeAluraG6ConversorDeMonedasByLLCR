import java.util.Scanner;

public class Conversion {

    public static void conversionDivisas(String divisaInicial, String divisaFinal,
                                         ConsultaDivisas consulta, Scanner lectura) {
        double cantidad;
        double cantidadConversion;

        TasaDeCambio tasa = consulta.buscarDivisa(divisaInicial, divisaFinal);
        try {
            System.out.println("Ingresa la cantidad que deseas convertir de " +
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

  /*  public static void conversionUsuario () {
        *//*double cantidad;
        double cantidadConversion;
        String divisaIn;
        String divisaOut;

        System.out.println("Ingresa el código de la moneda para convertir (moneda entrada)");
        try {
            divisaIn = String.valueOf(lectura.nextLine());
            System.out.println("Ingresa el código de la moneda a convertir (moneda salida)");
            divisaOut = String.valueOf(lectura.nextLine());
            TasaDeCambio tasa = consulta.buscarDivisa(divisaIn, divisaOut);

            if (tasa.base_code() == null || tasa.target_code() == null) {
                System.out.println("No se encontró alguno de los códigos, favor de verificar sus datos");
            } else {
                System.out.println("Ingresa la cantidad que desea convertir");
                cantidad = Double.parseDouble(lectura.nextLine());
                cantidadConversion = cantidad * tasa.conversion_rate();
                System.out.println(cantidad + " "+ divisaIn + "equivale a " +
                        cantidadConversion + " " + divisaOut + ". Tipo de cambio" +
                        tasa.conversion_rate());
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingrese una cantidad con número");
        } catch (IllegalArgumentException e) {
            System.out.println("Por favor, verifique sus códigos");
        }
    }*/
}
