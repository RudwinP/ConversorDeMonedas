package CoversorDeMonedas;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class ConversorDeTemperaturas {

	public static void main(String[] args) {
		seleccionarUnidadDeMedida();
	}

	public static void seleccionarUnidadDeMedida() {
		String[] unidades = { "Celsius", "Fahrenheit", "Kelvin" };
		String unidadSeleccionada = (String) JOptionPane.showInputDialog(null, "Seleccione la unidad de medida",
				"Conversor de temperaturas", JOptionPane.PLAIN_MESSAGE, null, unidades, unidades[0]);
		double temperatura = 0.0;
	    boolean esValido = false;
	    
	    do {
	        String temperaturaIngresada = JOptionPane.showInputDialog("Ingrese la temperatura a convertir:");
	        
	        try {
	            temperatura = Double.parseDouble(temperaturaIngresada);
	            if (temperatura >= -273.15) {
	                esValido = true;
	            } else {
	                JOptionPane.showMessageDialog(null, "La temperatura ingresada es menor que el cero absoluto (-273.15 °C). Ingrese un valor válido.");
	            }
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(null, "Debe ingresar un valor numérico.");
	        }
	    } while (!esValido);

		switch (unidadSeleccionada) {
		case "Celsius":
			mostrarResultados(temperatura, "Celsius");
			break;
		case "Fahrenheit":
			temperatura = convertirFahrenheitACelsius(temperatura);
			mostrarResultados(temperatura, "Celsius");
			break;
		case "Kelvin":
			temperatura = convertirKelvinACelsius(temperatura);
			mostrarResultados(temperatura, "Celsius");
			break;
		}
	}

	public static double convertirFahrenheitACelsius(double temperatura) {
		return (temperatura - 32) * 5 / 9;
	}

	public static double convertirKelvinACelsius(double temperatura) {
		return temperatura - 273.15;
	}

	public static void mostrarResultados(double temperatura, String unidad) {
		DecimalFormat formato = new DecimalFormat("#.00");
		String mensaje = temperatura + " " + unidad + " equivale a " + formato.format(temperatura + 273.15) + " Kelvin"
				+ "\n" + temperatura + " " + unidad + " equivale a " + formato.format(temperatura * 9 / 5 + 32)
				+ " Fahrenheit";

		int opcion = JOptionPane.showOptionDialog(null, mensaje, "Resultado de la conversión",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
				new Object[] { "Convertir otra temperatura", "Conversores", "Salir" }, null);

		switch (opcion) {
        case 0:
            seleccionarUnidadDeMedida();
            break;
        case 1:
            seleccionarConversor selector = new seleccionarConversor();
            selector.seleccionarConversor();
            break;
        case 2:
            System.exit(0);
            break;
        default:
            break;
    }

	}
}