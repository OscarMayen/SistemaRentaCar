
package com.dao;

import com.conexion.Conexion;
import com.modelo.Vehiculo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *Nombre de la clase: DaoVehiculo
 Fecha:18-08-2018
 Version: 1.0
 CopyTight: ITCA-FEPADE
 * @Author: GRUPO#3
 */
public class DaoVehiculo extends Conexion
{
    public void insertarVehiculo(Vehiculo vehiculo) throws Exception
    {
        try 
        {
            this.conectar();
            String sql="insert into vehiculo(marca,color,tipoVehiculo,anio,capacidad,numMotor,numChasis," +
                        "numPlacas,tarjetaVencimiento,paisProcedencia,idAgencia,precioAlquiler,estado)" +
                        "values(?,?,?,?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1,vehiculo.getMarca());
            pre.setString(2, vehiculo.getColor());
            pre.setString(3, vehiculo.getTipoVehiculo());
            pre.setInt(4,vehiculo.getAño());
            pre.setInt(5, vehiculo.getCapacidad());
            pre.setString(6, vehiculo.getNumMotor());
            pre.setString(7,vehiculo.getNumChasis());
            pre.setString(8,vehiculo.getNumPlacas());
            pre.setString(9, vehiculo.getTarjetaVencimiento());
            pre.setString(10, vehiculo.getPaisProcedencia());
            pre.setInt(11,vehiculo.getIdAgencia());
            pre.setDouble(12,vehiculo.getPrecioAlquiler());
            pre.setString(13, vehiculo.getEstado());
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
    
    
    public void modificarVehiculo(Vehiculo vehiculo) throws Exception
    {
        
        try 
        {
            this.conectar();
            String sql="update vehiculo set marca=?,color=?,tipoVehiculo=?,anio=?,capacidad=?,numMotor=?,"
                    + "numChasis=?,numPlacas=?,tarjetaVencimiento=?, paisProcedencia=?,idAgencia=?,precioAlquiler=?,estado=?  "
                    + "where idVehiculo=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, vehiculo.getMarca());
            pre.setString(2, vehiculo.getColor());
            pre.setString(3, vehiculo.getTipoVehiculo());
            pre.setInt(4, vehiculo.getAño());
            pre.setInt(5, vehiculo.getCapacidad());
            pre.setString(6, vehiculo.getNumMotor());
            pre.setString(7, vehiculo.getNumChasis());
            pre.setString(8, vehiculo.getNumPlacas());
            pre.setString(9, vehiculo.getTarjetaVencimiento());
            pre.setString(10, vehiculo.getPaisProcedencia());
            pre.setInt(11, vehiculo.getIdAgencia());
            pre.setDouble(12, vehiculo.getPrecioAlquiler());
            pre.setString(13, vehiculo.getEstado());
            pre.setInt(14, vehiculo.getIdVehiculo());
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
    
    public void eliminarVehiculo(Vehiculo vehiculo) throws Exception
    {
        try 
        {
            this.conectar();
            String sql="delete from vehiculo where idVehiculo=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, vehiculo.getIdVehiculo());
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
    
    public ArrayList<Vehiculo> mostrarVehiculo() throws Exception
    {
        ArrayList<Vehiculo> vehiculos = new ArrayList();
        ResultSet res=null;
        try {
            this.conectar();
            String sql="select * from vehiculo";
            PreparedStatement pre=this.getCon().prepareCall(sql);
            res = pre.executeQuery();
            while (res.next())
            {
                Vehiculo vehiculo=new Vehiculo();
                vehiculo.setIdVehiculo(res.getInt("idVehiculo"));
                vehiculo.setMarca(res.getString("marca"));
                vehiculo.setColor(res.getString("color"));
                vehiculo.setTipoVehiculo(res.getString("tipoVehiculo"));
                vehiculo.setAño(res.getInt("anio"));
                vehiculo.setCapacidad(res.getInt("capacidad"));
                vehiculo.setNumMotor(res.getString("numMotor"));
                vehiculo.setNumChasis(res.getString("numChasis"));
                vehiculo.setNumPlacas(res.getString("numPlacas"));
                vehiculo.setTarjetaVencimiento(res.getString("tarjetaVencimiento"));
                vehiculo.setPaisProcedencia(res.getString("paisProcedencia"));
                vehiculo.setIdAgencia(res.getInt("idAgencia"));
                vehiculo.setPrecioAlquiler(res.getDouble("precioAlquiler"));
                vehiculo.setEstado(res.getString("estado"));
                vehiculos.add(vehiculo);
            }
            
        } catch (Exception e) {
        }
     return vehiculos;   
    }
    
    
    
}
