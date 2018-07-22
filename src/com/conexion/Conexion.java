
package com.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *Nombre de la clase: Conexion
 * Fecha: 07-07-2018
 * Version:1.0
 * CopyRight:ITCA-FEDEPADE
 * @author: Oscar Mayen
 */
/* Prueba */
public class Conexion 
{
    private Connection con;

    
    //Metodo GET y SET
    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
    //METODO CONECTAR
    
    public void conectar() throws Exception
    {
        try 
        {
           Class.forName("com.mysql.jdbc.Driver"); 
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rentacar?user=root&password=grupo10");
          
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Error al conectar" + e.toString());
        }
        
    }
    
    //METODO DESCONECTAR
    public  void desconectar() throws Exception
    {
        try 
        {
            if(con!=null)
            {
                if(con.isClosed()==false)
                {
                    con.close();
                }
            
            }    
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }
}
