/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contamminacioncsv2mysql;

import java.util.ArrayList;

/**
 *
 * @author Mañanas
 */
public class ContamminacionCSV2MySQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Contaminante> lista_contaminantes=AccesoFichero.obtenerContaminantes();
        AccesoBD.crearTabla(lista_contaminantes.get(0).getDatos_contaminacion());
        for (int i=0; i<lista_contaminantes.size(); i++)
        {
            Contaminante c=lista_contaminantes.get(i);
            AccesoBD.insertarDatos(c);  
        }
          
    }
    
}
