
package com.dao;

import com.conexion.Conexion;
import com.modelo.Persona;
import java.sql.PreparedStatement;

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
    
    
    
}
