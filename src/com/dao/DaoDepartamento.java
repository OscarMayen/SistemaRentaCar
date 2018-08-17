/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.conexion.Conexion;
import com.modelo.Departamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author luism
 */
public class DaoDepartamento extends Conexion {
    
    public void insertarDepartamento (Departamento dpto) throws Exception {
        try {
            this.conectar();
            String sql="insert into departamento(nombre) value(?)";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setString(1,dpto.getNombre());
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally
        {
            this.desconectar();
        }
        
    }
    public void modificarDepartamento (Departamento dpto) throws Exception{
        try {
            this.conectar();
            String sql="update departamento set nombre=? where idDepartamento=?";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setString(1,dpto.getNombre());
            pre.setInt(2,dpto.getIdDepartamento());
            pre.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        finally{
            this.desconectar();
            
        }
    }
    public void eliminarDepartamento (Departamento dpto) throws Exception {
        try {
            this.conectar();
            String sql="delete from departamento where idDepartamento=?";
            PreparedStatement pre=this.getCon().prepareStatement(sql);
            pre.setInt(1,dpto.getIdDepartamento());
            pre.executeUpdate();
        } catch (Exception e) {
        }
        finally{
            this.desconectar();
            
        }
    }
    public ArrayList<Departamento> mostrarDepartamento() throws Exception
    {
        ArrayList<Departamento> departamentos = new ArrayList();
        ResultSet res=null;
        try {
            this.conectar();
            String sql="select * from departamento";
            PreparedStatement pre=this.getCon().prepareCall(sql);
            res = pre.executeQuery();
            while (res.next()){
                Departamento dpto=new Departamento();
                dpto.setIdDepartamento(res.getInt("idDepartamento"));
                dpto.setNombre(res.getString("nombre"));
                departamentos.add(dpto);
                
            }
            
        } catch (Exception e) {
        }
     return departamentos;   
    }
    
    
    public Departamento getDepto(int depto) throws Exception{
     Departamento dep = new Departamento();
      
     ResultSet res = null;
        try {
            this.conectar();
            String sql = "select * from departamento where idDepartamento = ?";
            PreparedStatement pre = this.getCon().prepareCall(sql);
              pre.setInt(1, depto);   
            res = pre.executeQuery();
                   
            while (res.next()) {              
                dep.setIdDepartamento(res.getInt("idDepartamento"));
                dep.setNombre(res.getString("nombre"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            throw e;
        } finally {
            this.desconectar();
        }
        return dep;
    
    }

    
    
}
