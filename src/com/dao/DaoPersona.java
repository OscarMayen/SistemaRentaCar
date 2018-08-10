
package com.dao;

import com.conexion.Conexion;
import com.modelo.Persona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *Nombre de la clase: DaoPersona
 * Fecha:18-07-2018
 * Version: 1.0
 * CopyTight: ITCA-FEPADE
 * @Author: GRUPO#3
 */
public class DaoPersona extends Conexion
{
     public void insertarPersona(Persona per) throws Exception
    {
        try 
        {
            this.conectar();
            String sql="insert into persona" +
                        "(nombre,apellido,dui,nit,sexo,fechaNac,direccion,telefono,email,idTipoPersona)" +
                        "values(?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1,per.getNombre());
            pre.setString(2, per.getApellido());
            pre.setString(3, per.getDui());
            pre.setString(4,per.getNit());
            pre.setString(5, per.getSexo());
            pre.setString(6, per.getFechaNac());
            pre.setString(7,per.getDireccion());
            pre.setString(8, per.getTelefono());
            pre.setString(9, per.getEmail());
            pre.setInt(10, per.getIdTipoPersona());
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
    
     public void modificarPersona(Persona per) throws Exception
    {
        
        try 
        {
            this.conectar();
            String sql="update persona set nombre=?,apellido=?,dui=?,nit=?,sexo=?,fechaNac=?,"
                    + "direccion=?,telefono=?,email=?, idTipoPersona=? where idPersona=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, per.getNombre());
            pre.setString(2, per.getApellido());
            pre.setString(3, per.getDui());
            pre.setString(4, per.getNit());
            pre.setString(5, per.getSexo());
            pre.setString(6, per.getFechaNac());
            pre.setString(7, per.getDireccion());
            pre.setString(8, per.getTelefono());
            pre.setString(9, per.getEmail());
            pre.setInt(10, per.getIdTipoPersona());
            pre.setInt(11, per.getIdPersona());
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
     
     public void eliminarPersona(Persona per) throws Exception
    {
        try 
        {
            this.conectar();
            String sql="delete from persona where idPersona=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, per.getIdPersona());
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
     
     public List mostrarPersona() throws Exception
    {
         List personas=new ArrayList();
         ResultSet res;
         try 
         {
            this.conectar();
            String sql = "select * from persona";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            res=pre.executeQuery();
            while(res.next())
            {
                Persona per=new Persona();
                per.setIdPersona(res.getInt("idPersona"));
                per.setNombre(res.getString("nombre"));
                per.setApellido(res.getString("apellido"));
                per.setDui(res.getString("dui"));
                per.setNit(res.getString("nit"));
                per.setSexo(res.getString("sexo"));
                per.setFechaNac(res.getString("fechaNac"));
                per.setDireccion(res.getString("direccion"));
                per.setTelefono(res.getString("telefono"));
                per.setEmail(res.getString("email"));
                per.setIdTipoPersona(res.getInt("idTipoPersona"));
                personas.add(per);
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
         return personas;
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
