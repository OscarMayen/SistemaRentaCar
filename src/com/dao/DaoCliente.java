
package com.dao;

import com.conexion.Conexion;
import com.modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *Nombre de la clase: DaoCliente
 Fecha:18-07-2018
 Version: 1.0
 CopyTight: ITCA-FEPADE
 * @Author: GRUPO#3
 */
public class DaoCliente extends Conexion
{
   public void insertarCliente(Cliente cli) throws Exception
    {
        try 
        {
            this.conectar();
            String sql="insert into cliente" +
                        "(fechaIngreso,licencia,lugarDeTrabajo,tipoCliente,idPersona,estado)" +
                        "values(?,?,?,?,?,?);";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1,cli.getFechaIngreso());
            pre.setString(2, cli.getLicencia());
            pre.setString(3, cli.getLugarDeTrabajo());
            pre.setString(4,cli.getTipoCliente());
            pre.setInt(5, cli.getIdPersona());
            pre.setString(6, cli.getEstado());
            pre.executeUpdate();
        } 
        catch (Exception e) 
        {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
    }
   
   public void modificarCliente(Cliente cli) throws Exception
    {
        
        try 
        {
            this.conectar();
            String sql="update cliente set fechaIngreso=?,licencia=?,lugarDeTrabajo=,"
                    + "tipoCliente=?,idPersona=?,estado=? where idCliente=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, cli.getFechaIngreso());
            pre.setString(2, cli.getLicencia());
            pre.setString(3, cli.getLugarDeTrabajo());
            pre.setString(4, cli.getTipoCliente());
            pre.setInt(5, cli.getIdPersona());
            pre.setString(6, cli.getEstado());
            pre.setInt(7, cli.getIdCliente());
            
            pre.executeUpdate();       
        } 
        catch (Exception e) 
        {
            throw  e; 
        }
        finally
        {
            this.desconectar();
        }
    }
   
   public void eliminarCliente(Cliente cli) throws Exception
    {
        try 
        {
            this.conectar();
            String sql="delete from cliente where idCliente=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, cli.getIdCliente());
            pre.executeUpdate();
            
        } 
        catch (Exception e) 
        {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
    }
   
   public List mostrarCliente() throws Exception
     {
         List clientes=new ArrayList();
         ResultSet res;
         try 
         {
            this.conectar();
            String sql = "select * from cliente";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            res=pre.executeQuery();
            while(res.next())
            {
                Cliente cli=new Cliente();
                cli.setIdCliente(res.getInt("idCliente"));
                cli.setFechaIngreso(res.getString("fechaIngreso"));
                cli.setLicencia(res.getString("licencia"));
                cli.setLugarDeTrabajo(res.getString("lugarDeTrabajo"));
                cli.setTipoCliente(res.getString("tipoCliente"));
                cli.setIdPersona(res.getInt("idPersona"));
                cli.setEstado(res.getString("estado"));
                clientes.add(cli);
            }
         } 
         catch (Exception e) 
         {
             throw e;
         }
         finally
         {
             this.desconectar();
         }
         return clientes;
     }
   
   
   
   
   
    public int recuperarUltimo() throws Exception{
        
        int idR=0;
        ResultSet res;
        try {
            this.conectar();
            String sql="select Max(idPersona) from persona;";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            res = pre.executeQuery();
            if(res.next()){
               idR=res.getInt(1);
            }
            
        } catch (Exception e) {
        }
     return idR;   
    }
     
   
     
}
