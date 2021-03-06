
package com.dao;

import com.conexion.Conexion;
import com.modelo.Perfil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.util.List;



/**
 *Nombre de la clase: DaoPerfil
 * Fecha:14-07-2018
 * Version: 1.0
 * CopyTight: ITCA-FEPADE
 * @Author: GRUPO#3
 */
public class DaoPerfil extends Conexion 
{
    
    public void insertarPerfil(Perfil perfil) throws Exception
    {
        try 
        {
            this.conectar();
            String sql="insert into perfil(perfil)values(?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1,perfil.getPerfil());
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
    
    
    public void modificarPerfil(Perfil perfil) throws Exception
    {
        
        try 
        {
            this.conectar();
            String sql="update perfil set perfil=? where idPerfil=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, perfil.getPerfil());
            pre.setInt(2, perfil.getIdPerfil());
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

     public void eliminarPerfil(Perfil perfil) throws Exception
    {
        try 
        {
            this.conectar();
            String sql="delete from perfil where idPerfil=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, perfil.getIdPerfil());
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
     
     public ArrayList<Perfil> mostrarPerfil() throws Exception
    {
        ArrayList<Perfil> perfiles = new ArrayList();
        ResultSet res=null;
        try {
            this.conectar();
            String sql="Select * from perfil";
            PreparedStatement pre=this.getCon().prepareCall(sql);
            res = pre.executeQuery();
            while (res.next()){
                Perfil perfil=new Perfil();
                perfil.setIdPerfil(res.getInt("idPerfil"));
                perfil.setPerfil(res.getString("perfil"));
                perfiles.add(perfil);
                
            }
            
        } catch (Exception e) {
        }
     return perfiles;   
    }
    
}
