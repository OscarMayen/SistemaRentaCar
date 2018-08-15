/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.conexion.Conexion;
import com.modelo.TipoMantenimiento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Nombre de la clase : DaoTipoMantenimiento
 * Fecha : 26JUN2018.
 * CopyRight : ITCA-FEPADE
 * @author Grupo#3
 */
public class DaoTipoMantenimiento extends Conexion{
    
    /*Insertar*/
    public void insertarTipoMantenimiento (TipoMantenimiento tipoM) throws Exception 
    { 
        try {
         this.conectar();
            String sql="insert into tipomantenimiento(idtipomantenimiento, tipomanteniento) values(?, ?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1,tipoM.getIdTipoMantenimiento());
            pre.setString(2,tipoM.getTipoManteniento());
            pre.executeUpdate();
               
        }
        catch (Exception e){
            throw e;
            
        }
        finally{
            this.desconectar();
        }
    }
    
    /*Modificar*/
    public void modificarTipoMantenimiento(TipoMantenimiento tipoM) throws Exception
    {
        try {
            this.conectar();
            String sql="update tipomantenimiento set tipomanteniento=? where idtipomantenimiento=?";
            PreparedStatement pre =this.getCon().prepareStatement(sql);
            pre.setString(1,tipoM.getTipoManteniento());
            
            pre.setInt(2,tipoM.getIdTipoMantenimiento());
            
            pre.executeUpdate();
        }
        catch (Exception e) {
            throw e;
        }
        finally{
        this.desconectar();
    }
    }
    
    /* Eliminar */
    public void eliminarTipoMantenimiento(TipoMantenimiento tipoM) throws Exception
    {
        try {
            this.conectar();
            String sql="delete from tipomantenimiento where idtipomantenimiento=? ";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1, tipoM.getIdTipoMantenimiento());
            pre.executeUpdate();
        } catch (Exception e) {
        }
    }
    /* Mostrar */
    public List MostrarTipoMantenimiento() throws Exception
    {
        List tipoMantenimientos = new ArrayList();
        ResultSet res;
        
        try {
            this.conectar();
            String sql="Select * from tipomantenimiento";
            PreparedStatement pre= this.getCon().prepareStatement(sql);
            res = pre.executeQuery();
            while (res.next())
            {
                TipoMantenimiento tipoM= new TipoMantenimiento();
                tipoM.setIdTipoMantenimiento(res.getInt("idTipoMantenimiento"));
                tipoM.setTipoManteniento(res.getString("tipoManteniento"));
                tipoMantenimientos.add(tipoM);
                
            }
        } catch (Exception e) {
        }
        return tipoMantenimientos;
    }
    
    
}
    

