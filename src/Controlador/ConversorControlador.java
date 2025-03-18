/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author yefre
 */

import Modelo.Unidades;
import Vista.ConversorVista;
import javax.swing.JOptionPane;

public class ConversorControlador {
    
    private Unidades modelo;
    private ConversorVista vista;

    public ConversorControlador(Unidades modelo, ConversorVista vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.llenarComboBox();
    }

    public void convertirSI() {
        try {
            double cantidad = Double.parseDouble(vista.getTxtCantidad().getText());
            String unidadOrigen = vista.getCbOrigen().getSelectedItem().toString();
            String unidadDestino = vista.getCbObjetivo().getSelectedItem().toString();

            double resultado = modelo.convertirSI(cantidad, unidadOrigen, unidadDestino);
            vista.getTxtResultado().setText(String.format("%.6f %s", resultado, unidadDestino));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada Incorrecta :(.");
        }
    }

    public void convertirIEC() {
        try {
            double cantidad = Double.parseDouble(vista.getTxtCantidad().getText());
            String unidadOrigen = vista.getCbOrigen().getSelectedItem().toString();
            String unidadDestino = vista.getCbObjetivo().getSelectedItem().toString();

            double resultado = modelo.convertirIEC(cantidad, unidadOrigen, unidadDestino);
            vista.getTxtResultado().setText(String.format("%.6f %s", resultado, unidadDestino));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada Incorrecta :(.");
        }
    }
    
    private void llenarComboBox() {
        vista.getCbOrigen().removeAllItems();
        vista.getCbObjetivo().removeAllItems();
        String[] unidadesSI = {"B", "KB", "MB", "GB", "TB"};
        String[] unidadesIEC = {"B", "KiB", "MiB", "GiB", "TiB"};
        
        for (String unidad : unidadesSI) {
            vista.getCbOrigen().addItem(unidad);
            vista.getCbObjetivo().addItem(unidad);
        }
        for (String unidad : unidadesIEC) {
            vista.getCbOrigen().addItem(unidad);
            vista.getCbObjetivo().addItem(unidad);
        }
    }
    
    public void limpiar(){
        vista.getTxtResultado().setText("0");
        vista.getTxtCantidad().setText("0");
    }
}

