
package com.dao;

import com.conexion.Conexion;
import com.modelo.Empleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *Nombre de la clase: DaoEmpleado
 Fecha:09-08-2018
 Version: 1.0
 CopyTight: ITCA-FEPADE
 * @Author: GRUPO#3
 */
public class DaoEmpleado extends Conexion
{
    public void insertarEmpleado(Empleado em) throws Exception
    {
        try 
        {
            this.conectar();
            String sql="insert into empleado" +
                        "(salario,fechaInicio,idPersona,isss,estado,idDepartamento)" +
                        "values(?,?,?,?,?,?);";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setDouble(1,em.getSalario());
            pre.setString(2, em.getFechaInicio());
            pre.setInt(3, em.getIdPersona());
            pre.setString(4,em.getIsss());
            pre.setString(5, em.getEstado());
            pre.setInt(6, em.getIdDepartamento());
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
    
    public void modificarEmpleado(Empleado em) throws Exception
    {
        
        try 
        {
            this.conectar();
            String sql="update empleado set salario=?,fechaInicio=?,idPersona=?,"
                    + "isss=?,estado=?,idDepartamento where idEmpleado=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setDouble(1, em.getSalario());
            pre.setString(2, em.getFechaInicio());
            pre.setInt(3, em.getIdPersona());
            pre.setString(4, em.getIsss());
            pre.setString(5, em.getEstado());
            pre.setInt(6, em.getIdDepartamento());
            pre.setInt(7, em.getIdEmpleado());
            
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
    
    public void eliminarEmpleado(Empleado em) throws Exception
    {
        try 
        {
            this.conectar();
            String sql="delete from empleado where idEmpleado=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, em.getIdEmpleado());
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
    
    public List mostrarEmpleado() throws Exception
    {
         List empleados=new ArrayList();
         ResultSet res;
         try 
         {
            this.conectar();
            String sql = "select * from empleado";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            res=pre.executeQuery();
            while(res.next())
            {
                Empleado em=new Empleado();
                em.setIdEmpleado(res.getInt("idEmpleado"));
                em.setSalario(res.getDouble("salario"));
                em.setFechaInicio(res.getString("fechaInicio"));
                em.setIdPersona(res.getInt("idPersona"));
                em.setIsss(res.getString("isss"));
                em.setEstado(res.getString("estado"));
                em.setIdDepartamento(res.getInt("idDepartamento"));
                empleados.add(em);
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
         return empleados;
     }
    
    
}
