/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author yefre
 */
public class Unidades {
    
    public void Unidades(){};
        
    private String[] unidadesSI = {"B", "KB", "MB", "GB", "TB"};
    private String[] unidadesIEC = {"B", "KiB", "MiB", "GiB", "TiB"};
    private double[] valoresSI = {1, 1_000, 1_000_000, 1_000_000_000, 1_000_000_000_000.0};
    private double[] valoresIEC = {1, 1_024, 1_048_576, 1_073_741_824, 1_099_511_627_776.0};
    
    public double convertirSI(double tam, String origen, String objetivo) {
        int inicio = getIndex(origen, unidadesSI);
        int fin = getIndex(objetivo, unidadesSI);
        if (inicio == -1 || fin == -1) {
            return -1; 
        }
        double bytes = tam * valoresSI[inicio];
        return bytes / valoresSI[fin];
    }
    
    public double convertirIEC(double tam, String origen, String objetivo) {
        int inicio = getIndex(origen, unidadesIEC);
        int fin = getIndex(objetivo, unidadesIEC);
        if (inicio == -1 || fin == -1) {
            return -1;
        }
        double bytes = tam * valoresIEC[inicio];
        return bytes / valoresIEC[fin];
    }
    
    private int getIndex(String unidad, String[] unidades) {
        for(int i=0; i < unidades.length; i++) {
            if (unidades[i].equalsIgnoreCase(unidad)) return i;
        }
        return -1;
    }


    
}
