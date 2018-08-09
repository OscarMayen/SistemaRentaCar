
package com.dao;

import com.conexion.Conexion;
import com.modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *Nombre de la clase: DaoUsuario
 Fecha:8-08-2018
 Version: 1.0
 CopyTight: ITCA-FEPADE
 * @Author: GRUPO#3
 */
public class DaoUsuario extends Conexion
{
    public void insertarUsuario(Usuario usu) throws Exception
    {
        try 
        {
            this.conectar();
            String sql="insert into usuario" +
                        "(usuario,password,idPersona,idPerfil)" +
                        "values(?,?,?,?);";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1,usu.getUsuario());
            pre.setString(2, usu.getPassword());
            pre.setInt(3, usu.getIdPersona());
            pre.setInt(4,usu.getIdPerfil());
            
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
    
    public void modificarUsuario(Usuario usu) throws Exception
    {
        
        try 
        {
            this.conectar();
            String sql="update usuario set usuario=?,password=?,idPersona=?,"
                    + "idPerfil=? where idUsuario=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, usu.getUsuario());
            pre.setString(2, usu.getPassword());
            pre.setInt(3, usu.getIdPersona());
            pre.setInt(4, usu.getIdPerfil());
            pre.setInt(5, usu.getIdUsuario());
            
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
    
    public void eliminarUsuario(Usuario usu) throws Exception
    {
        try 
        {
            this.conectar();
            String sql="delete from usuario where idUsuario=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, usu.getIdUsuario());
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
