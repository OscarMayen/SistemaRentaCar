
package com.dao;

import com.conexion.Conexion;
import com.modelo.TipoPersona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *Nombre de la clase: DaoTipoPersona
 Fecha: 12-07-2018
 Version:1.0
 CopyRight:ITCA-FEDEPADE
 * @author: GRUPO#3
 */
public class DaoTipoPersona extends Conexion
{
    
     public void insertarTipoPersona(TipoPersona tipoP) throws Exception
    {
        try 
        {
            this.conectar();
            String sql="insert into tipopersona(tipo)values(?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1,tipoP.getTipo());
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
    
    
    public void modificarTipoPersona(TipoPersona tipoP) throws Exception
    {
        
        try 
        {
            this.conectar();
            String sql="update tipopersona set tipo=? where idTipoPersona=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, tipoP.getTipo());
            pre.setInt(2, tipoP.getIdTipoPersona());
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

     public void eliminarTipoPersona(TipoPersona tipoP) throws Exception
    {
        try 
        {
            this.conectar();
            String sql="delete from tipopersona where idTipoPersona=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, tipoP.getIdTipoPersona());
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
     
     public List mostrarTipoPersona() throws Exception
     {
         List tipoPesonas=new ArrayList();
         ResultSet res;
         try 
         {
            this.conectar();
            String sql = "select * from tipopersona";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            res=pre.executeQuery();
            while(res.next())
            {
                TipoPersona tipoP=new TipoPersona();
                tipoP.setIdTipoPersona(res.getInt("idTipoPersona"));
                tipoP.setTipo(res.getString("tipo"));
                
                tipoPesonas.add(tipoP);
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
         return tipoPesonas;
     }
    
}
