import java.io.IOException;
import java.nio.charset.CharacterCodingException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ConsultaDivisas consulta = new ConsultaDivisas();
        Scanner lectura = new Scanner(System.in);
        int entradaUsuario = 0;

        System.out.println("------------------------------------------------------------------------");
        System.out.println("Bienvenido al convertidor de monedas");
        System.out.println("------------------------------------------------------------------------\n");
        while (entradaUsuario != 9) {
            System.out.println("¡IMPORTANTE!: Este conversor utiliza el código de moneda ISO 4217 \n" +
                    "Para consultar los códifos puedes visitar el siguiente enlace: \n" +
                    "https://ayuda.xubio.com/wp-content/uploads/2020/12/Catalogo-de-Monedas.pdf\n");

            System.out.println("Por favor, seleccione una de las siguientes opciones");
            System.out.println("1. USD a MXN");
            System.out.println("2. MXN a USD");
            System.out.println("3. EUR a MXN");
            System.out.println("4. MXN a EUR");
            System.out.println("5. CAD a MXN");
            System.out.println("6. KRW a MXN");
            System.out.println("7. MXN a KRW");
            System.out.println("8. Convertir otras monedas");
            System.out.println("9. Salir del conversor");

            try {
                entradaUsuario = lectura.nextInt();
                lectura.nextLine();
                switch (entradaUsuario) {
                    case 1:
                        Conversion.conversionDivisas("USD", "MXN", consulta, lectura);
                        break;
                    case 2:
                        Conversion.conversionDivisas("MXN", "USD", consulta, lectura);
                        break;
                    case 3:
                        Conversion.conversionDivisas("EUR", "MXN", consulta, lectura);
                        break;
                    case 4:
                        Conversion.conversionDivisas("MXN", "EUR", consulta, lectura);
                        break;
                    case 5:
                        Conversion.conversionDivisas("CAD", "MXN", consulta, lectura);
                        break;
                    case 6:
                        Conversion.conversionDivisas("KRW", "MXN", consulta, lectura);
                        break;
                    case 7:
                        Conversion.conversionDivisas("MXN", "KRW", consulta, lectura);
                        break;
                    case 8:
                        double cantidad;
                        double cantidadConversion;
                        String divisaIn;
                        String divisaOut;

                        System.out.println("Ingrese el código de la moneda para convertir (moneda entrada)");
                        try {
                            divisaIn = String.valueOf(lectura.nextLine());
                            System.out.println("Ingrese el código de la moneda a convertir (moneda salida)");
                            divisaOut = String.valueOf(lectura.nextLine());
                            TasaDeCambio tasa = consulta.buscarDivisa(divisaIn, divisaOut);

                            if (tasa.base_code() == null || tasa.target_code() == null) {
                                System.out.println("No se encontró alguno de los códigos, favor de verificar sus datos");
                                System.out.println("Regresando al menu principal...");
                                System.out.println("------------------------------------------------------------------------\n");
                            } else {
                                System.out.println("Ingrese la cantidad que desea convertir");
                                cantidad = Double.parseDouble(lectura.nextLine());
                                cantidadConversion = cantidad * tasa.conversion_rate();
                                System.out.println(cantidad + " "+ divisaIn + " equivale a " +
                                        cantidadConversion + " " + divisaOut + ".\nTipo de cambio: " +
                                        tasa.conversion_rate() + "\n");
                                System.out.println("------------------------------------------------------------------------\n");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Por favor, ingrese una cantidad con número");
                        } catch (Exception e) {
                            System.out.println("Monedas no encontradas. Por favor, verifique sus códigos");
                            System.out.println("Regresando al menú principal...");
                            System.out.println("------------------------------------------------------------------------\n");
                        }
                        break;
                    case 9:
                        System.out.println("Saliendo de la aplicación...");
                        System.out.println("Gracias por usar el convertidor de monedas.");
                        System.out.println("Cerrando programa...");
                        break;
                    default:
                        System.out.println("Por favor, ingrese una opción válida.\n");
                        System.out.println("------------------------------------------------------------------------\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese una opción númerica válida.\n");
                System.out.println("------------------------------------------------------------------------\n");
                lectura.next();
                entradaUsuario = 0;
            } /*catch (Exception e) {
                System.out.println("Opción no válida, verifique su entrada");
                System.out.println("------------------------------------------------------------------------\n");
            }*/
        }
    }
}
