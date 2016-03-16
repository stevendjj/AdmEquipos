/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.demo.impl;

import com.demo.db.DbConnectionFactory;
import com.demo.model.Equipo;
import com.demo.model.DaoEquipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DaoEquipoImpl implements DaoEquipo<Equipo> {

    public DaoEquipoImpl() {
        try {
            DbConnectionFactory.connect();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DaoEquipoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void guardar(Equipo equipo) {
        Connection connection = DbConnectionFactory.getConnection();
        try {
            PreparedStatement pst = connection.prepareStatement("Insert into equipo values(?,?,?,?,?)");
            pst.setInt(1,equipo.getId());
            pst.setString(2, equipo.getMarca());
            pst.setString(3, equipo.getModelo());
            pst.setString(4, equipo.getTipo());
            pst.setString(5, equipo.getEstado());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DaoEquipoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void actualizar(Equipo equipo) {
       
    }

    @Override
    public List<Equipo> listar() {
        List<Equipo> lista=new ArrayList<>();
        try {
            Connection connection = DbConnectionFactory.getConnection();
            PreparedStatement pst = connection.prepareStatement("Select * from equipo"); 
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Equipo equipo=new Equipo();
                equipo.setId(rs.getInt("codigo"));
                equipo.setMarca(rs.getString("marca"));
                equipo.setModelo(rs.getString("modelo"));
                equipo.setTipo(rs.getString("tipo"));
                equipo.setEstado(rs.getString("estadoInicial"));
                lista.add(equipo);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoEquipoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
         return lista;
    }

    @Override
    public void eliminar(Equipo equipo) {
        
    }
    
}
