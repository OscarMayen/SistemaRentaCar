
package com.dao;

import com.conexion.Conexion;
import com.modelo.Agencia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *Nombre de la clase: DaoAgencia
 Fecha:17-08-2018
 Version: 1.0
 CopyTight: ITCA-FEPADE
 * @Author: GRUPO#3
 */
public class DaoAgencia extends Conexion 
{
    public void insertarAgencia(Agencia agen) throws Exception
    {
        try 
        {
            this.conectar();
            String sql="insert into agencia(nombreAgencia,telefonoAgencia,direccion,emailAgencia) " +
                        "values(?,?,?,?);";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1,agen.getNombreAgencia());
            pre.setString(2, agen.getTelefonoAgencia());
            pre.setString(3, agen.getDireccionAgencia());
            pre.setString(4,agen.getEmailAgencia());
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
    
    public void modificarAgencia(Agencia agen) throws Exception
    {
        
        try 
        {
            this.conectar();
            String sql="update agencia set nombreAgencia=?,telefonoAgencia=?,direccion=?,emailAgencia=? "
                    + "where idAgencia=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, agen.getNombreAgencia());
            pre.setString(2, agen.getTelefonoAgencia());
            pre.setString(3, agen.getDireccionAgencia());
            pre.setString(4, agen.getEmailAgencia());
            pre.setInt(5, agen.getIdAgencia());
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
    
    public void eliminarAgencia(Agencia agen) throws Exception
    {
        try 
        {
            this.conectar();
            String sql="delete from agencia where idAgencia=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, agen.getIdAgencia());
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
    
    public ArrayList<Agencia> mostrarAgencia() throws Exception
    {
        ArrayList<Agencia> agencias = new ArrayList();
        ResultSet res=null;
        try {
            this.conectar();
            String sql="select * from agencia";
            PreparedStatement pre=this.getCon().prepareCall(sql);
            res = pre.executeQuery();
            while (res.next())
            {
                Agencia agen=new Agencia();
                agen.setIdAgencia(res.getInt("idAgencia"));
                agen.setNombreAgencia(res.getString("nombreAgencia"));
                agen.setTelefonoAgencia(res.getString("telefonoAgencia"));
                agen.setDireccionAgencia(res.getString("direccion"));
                agen.setEmailAgencia(res.getString("emailAgencia"));
                agencias.add(agen);
            }
            
        } catch (Exception e) {
        }
     return agencias;   
    }
    
    public Agencia getAgencia(int agencia) throws Exception{
     Agencia agen = new Agencia();
      
     ResultSet res = null;
        try {
            this.conectar();
            String sql = "select * from agencia where idAgencia = ?";
            PreparedStatement pre = this.getCon().prepareCall(sql);
              pre.setInt(1, agencia);   
            res = pre.executeQuery();
                   
            while (res.next()) {              
                agen.setIdAgencia(res.getInt("idAgencia"));
                agen.setNombreAgencia(res.getString("nombreAgencia"));
                agen.setTelefonoAgencia(res.getString("telefonoAgencia"));
                agen.setDireccionAgencia(res.getString("direccion"));
                agen.setEmailAgencia(res.getString("emailAgencia"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            throw e;
        } finally {
            this.desconectar();
        }
        return agen;
    
    }
    
    
    
}
