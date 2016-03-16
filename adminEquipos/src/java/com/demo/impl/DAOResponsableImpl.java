/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.impl;

import com.demo.db.DbConnectionFactory;
import com.demo.model.DAOResponsable;
import com.demo.model.Responsable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos Alberto
 */
public class DAOResponsableImpl implements DAOResponsable<Responsable>{
    
    public DAOResponsableImpl() {
        try {
            DbConnectionFactory.connect();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAOResponsableImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void guardar(Responsable responsable) {
        Connection connection = DbConnectionFactory.getConnection();
        try {
            PreparedStatement pst = connection.prepareStatement("Insert into responsable values(?,?,?,?)");
            pst.setInt(1,responsable.getIdentificacion());
            pst.setString(2, responsable.getNombre());
            pst.setString(3, responsable.getApellido());
            pst.setString(4, responsable.getCargo());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DaoEquipoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actualizar(Responsable responsable) {
        
    }

    @Override
    public List<Responsable> listar() {
        List<Responsable> lista=new ArrayList<>();
        try {
            Connection connection = DbConnectionFactory.getConnection();
            PreparedStatement pst = connection.prepareStatement("Select identificacion,nombre,apellido,cargo from responsable"); 
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Responsable reponsable=new Responsable();
                reponsable.setIdentificacion(rs.getInt("identificacion"));
                reponsable.setNombre(rs.getString("nombre"));
                reponsable.setApellido(rs.getString("apellido"));
                reponsable.setCargo(rs.getString("cargo"));
                lista.add(reponsable);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoEquipoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
         return lista;
    }

    @Override
    public void eliminar(Responsable responsable) {
        
    }
    
}
