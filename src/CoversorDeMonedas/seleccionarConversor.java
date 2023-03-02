package CoversorDeMonedas;

import javax.swing.JOptionPane;

public class seleccionarConversor {
    
    public static void main(String[] args) {
        seleccionarConversor();
    }

    
    public static void seleccionarConversor() {
        String[] conversores = { "Conversor de monedas", "Conversor de temperatura"};
        String conversorSeleccionado = (String) JOptionPane.showInputDialog(null, "Seleccione el conversor",
            "Seleccionar conversor", JOptionPane.PLAIN_MESSAGE, null, conversores, conversores[0]);
        switch (conversorSeleccionado) {
            case "Conversor de monedas":
                Conversor conversor = new Conversor(); // Creamos un objeto de la clase Conversor
                conversor.seleccionarMonedas();
                break;
            case "Conversor de temperatura":
            	ConversorDeTemperaturas temp = new ConversorDeTemperaturas(); // Creamos un objeto de la clase ConversorDeTemperaturas
                temp.seleccionarUnidadDeMedida();
                break;
        }
    }
}

