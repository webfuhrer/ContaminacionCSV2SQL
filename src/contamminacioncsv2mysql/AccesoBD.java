/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contamminacioncsv2mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mañanas
 */
public class AccesoBD {
    static String usuario="root";
    static String password="";
    static String url="jdbc:mysql://localhost:3306/contaminacion";
/*  private int magnitud, estacion;
    private String fecha;
    private ArrayList<String> datos_contaminacion;*/
    public static void crearTabla(ArrayList<String> lista_datos_contaminacion)
    {
        int numero_campos_datos=lista_datos_contaminacion.size();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        
        String query="CREATE TABLE IF NOT EXISTS t_contaminacion\n" +
"(\n" +
"magnitud int(2),\n" +
"    estacion int(2),\n" +
"    fecha varchar(12),\n" 
                +crearCamposCantidades(numero_campos_datos)+
"    \n" +
");";
            System.out.println(query);
                Properties info=new Properties();
                info.setProperty("user", usuario);
                info.setProperty("password",password);
                try {
                    Connection conexion=DriverManager.getConnection(url, info);
                    Statement stmt=conexion.createStatement();
                    stmt.executeUpdate(query);
                    stmt.close();
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
                }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static String crearCamposCantidades(int numero_campos_datos) {
       String sql="";
       for (int i=0; i<numero_campos_datos; i++)
       {
           sql+="hora"+i+" varchar(6),";
       }
       sql=sql.substring(0, sql.length()-1);
       return sql;
    }

    static void insertarDatos(Contaminante c) {
        Properties info=new Properties();
               info.setProperty("user", usuario);
                info.setProperty("password",password);
        try {
            Connection conexion=DriverManager.getConnection(url, info);
            Statement stmt=conexion.createStatement();
            String query="INSERT INTO t_contaminacion VALUES"
                    + "('"+c.getMagnitud()+"', '"+c.getEstacion()+"', '"
                    + c.getFecha()+"', "+creaInserciones(c.getDatos_contaminacion())+")";
            System.out.println(query);
            stmt.executeUpdate(query);
            stmt.close();
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static String creaInserciones(ArrayList<String> datos_contaminacion) {
      // String sql="'3', '4', '8',...";
      String sql="";
      for (int i=0; i<datos_contaminacion.size(); i++)
      {
          sql+="'"+datos_contaminacion.get(i)+"',";
      }
      sql=sql.substring(0, sql.length()-1);
      return sql;
    }
}
