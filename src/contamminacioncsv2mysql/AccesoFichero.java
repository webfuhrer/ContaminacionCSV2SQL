/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contamminacioncsv2mysql;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mañanas
 */
public class AccesoFichero {
    static ArrayList<Contaminante> obtenerContaminantes()  {
        ArrayList<Contaminante> lista_contaminantes=new ArrayList<>();
        String ruta_fichero="D:\\contaminacion\\horario.csv";
        try {
            FileReader fr=new FileReader(ruta_fichero);
            BufferedReader br=new BufferedReader(fr);
            String linea=br.readLine();//Cabecera
            linea=br.readLine();
            while(linea!=null)
            {
                String[] campos=linea.split(";");
                int estacion=Integer.parseInt(campos[2]);
                int magnitud=Integer.parseInt(campos[3]);
                
                String f=campos[7]+"/"+campos[6]+"/"+campos[5];
                ArrayList<String> lista_valores=new ArrayList();
                for (int i=8; i<campos.length; i=i+2)
                {
                    lista_valores.add(campos[i]);
                }
                Contaminante c=new Contaminante(magnitud, estacion, f, lista_valores);
                lista_contaminantes.add(c);
                linea=br.readLine();
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AccesoFichero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AccesoFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_contaminantes;
    }
}
