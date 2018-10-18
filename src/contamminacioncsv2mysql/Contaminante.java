/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contamminacioncsv2mysql;

/**
 *
 * @author Mañanas
 */
import java.util.ArrayList;

/**
 *
 * @author luis
 */
public class Contaminante {
    private int magnitud, estacion;
    private String fecha;
    private ArrayList<String> datos_contaminacion;

    public Contaminante(int magnitud, int estacion, String fecha, ArrayList<String> datos_contaminacion) {
        this.magnitud = magnitud;
        this.estacion = estacion;
        this.fecha = fecha;
        this.datos_contaminacion = datos_contaminacion;
    }

    public int getMagnitud() {
        return magnitud;
    }

    public int getEstacion() {
        return estacion;
    }

    public String getFecha() {
        return fecha;
    }

    public ArrayList<String> getDatos_contaminacion() {
        return datos_contaminacion;
    }
    
}