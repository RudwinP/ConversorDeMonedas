package CoversorDeMonedas;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class Conversor {

    public static void main(String[] args) {
    	seleccionarConversor selector = new seleccionarConversor(); // Creamos un objeto de la clase seleccionarConversor
    	selector.seleccionarConversor();
        seleccionarMonedas();
        ConversorDeTemperaturas temp = new ConversorDeTemperaturas(); // Creamos un objeto de la clase ConversorDeTemperaturas
        temp.seleccionarUnidadDeMedida();
        
       
    }


    public static void seleccionarMonedas() {
        String[] monedas = { "Dólar", "Euro", "Yen japonés", "Won sul-coreano", "Libra esterlina" };
        String monedaOrigen = (String) JOptionPane.showInputDialog(null, "Seleccione la moneda origen",
                "Conversor de monedas", JOptionPane.PLAIN_MESSAGE, null, monedas, monedas[0]);
        String monedaDestino = (String) JOptionPane.showInputDialog(null, "Seleccione la moneda destino",
                "Conversor de monedas", JOptionPane.PLAIN_MESSAGE, null, monedas, monedas[0]);
        double cantidad = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                cantidad = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad a convertir:"));
                validInput = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: debe ingresar un valor numérico válido");
            }
        }
        
        double resultado = convertir(monedaOrigen, monedaDestino, cantidad);
        mostrarResultados(cantidad, monedaOrigen, resultado, monedaDestino);
    }

    public static double convertir(String monedaOrigen, String monedaDestino, double cantidad) {
        double tasaOrigen = 0;
        double tasaDestino = 0;

        switch (monedaOrigen) {
        case "Dólar":
            tasaOrigen = 1;
            break;
        case "Euro":
            tasaOrigen = 0.95;
            break;
        case "Yen japonés":
            tasaOrigen = 136.00;
            break;
        case "Won sul-coreano":
            tasaOrigen = 1322.00;
            break;
        case "Libra esterlina":
            tasaOrigen = 0.84;
            break;
        }

        switch (monedaDestino) {
        case "Dólar":
            tasaDestino = 1;
            break;
        case "Euro":
            tasaDestino = 1.19;
            break;
        case "Yen japonés":
            tasaDestino = 109.87;
            break;
        case "Won sul-coreano":
            tasaDestino = 1131.80;
            break;
        case "Libra esterlina":
            tasaDestino = 0.72;
            break;
        }

        double resultado = cantidad * (tasaDestino / tasaOrigen);

        return resultado;
    }

    public static void mostrarResultados(double cantidad, String monedaOrigen, double resultado, String monedaDestino) {
        DecimalFormat formato = new DecimalFormat("#.00");
        String mensaje = cantidad + " " + monedaOrigen + " equivale a " + formato.format(resultado) + " "
                + monedaDestino;
        int opcion = JOptionPane.showOptionDialog(null, mensaje, "Resultado de la conversión",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                new Object[] { "Convertir otra cantidad", "Conversores","Salir"}, null);

        switch (opcion) {
        case 0:
            seleccionarMonedas();
            break;
        case 1:
            seleccionarConversor selector = new seleccionarConversor();
            selector.seleccionarConversor();
            break; // Agregar el break aquí
        case 2:
            System.exit(0);
            break;
        default:
            break;
    }
    }
}
