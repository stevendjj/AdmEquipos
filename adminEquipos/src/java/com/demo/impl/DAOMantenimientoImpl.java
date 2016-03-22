/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.impl;

import com.demo.db.DbConnectionFactory;
import com.demo.model.DAOMantenimiento;
import com.demo.model.Mantenimiento;
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
 * @author 
 */
public class DAOMantenimientoImpl implements DAOMantenimiento<Mantenimiento> {
    public DAOMantenimientoImpl() {
        try {
            DbConnectionFactory.connect();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DAOMantenimientoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String fecha(java.util.Date dt){
        java.text.SimpleDateFormat sdf= new java.text.SimpleDateFormat("yyyy-MM-dd");
        String currentTime = sdf.format(dt);
        return currentTime;
    }
    public String fechaBD(java.util.Date dt){
        java.text.SimpleDateFormat sdf= new java.text.SimpleDateFormat("dd-MM-yyyy");
        String currentTime = sdf.format(dt);
        return currentTime;
    }
    @Override
    public void guardar(Mantenimiento mantenimiento) {
         Connection connection = DbConnectionFactory.getConnection();
        try {
            PreparedStatement pst = connection.prepareStatement("Insert into mantenimiento values(?,?,?,?,?,?,?)");
            pst.setInt(1,mantenimiento.getCodigo());
            pst.setString(2, fecha(mantenimiento.getFechaIngreso()));
            pst.setString(3, mantenimiento.getTipo());
            pst.setString(4, mantenimiento.getDescripcion());
            pst.setString(5, mantenimiento.getResultado());
            pst.setInt(6, mantenimiento.getEquipo());
            pst.setInt(7, mantenimiento.getRes());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOMantenimientoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Mantenimiento> listar() {
        List<Mantenimiento> lista=new ArrayList<>();
        try {
            Connection connection = DbConnectionFactory.getConnection();
            PreparedStatement pst = connection.prepareStatement("Select m.codigo,m.fechaIngreso,m.tipo,m.descripcion,m.resultado,m.equipo_codigo,r.nombre,r.apellido from mantenimiento m, responsable r WHERE m.responsable_identificacion=r.identificacion"); 
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Mantenimiento mantenimiento=new Mantenimiento();
                mantenimiento.setCodigo(rs.getInt("m.codigo"));
                mantenimiento.setFechaIngresoBD(fechaBD(rs.getDate("m.fechaIngreso")));
                mantenimiento.setTipo(rs.getString("m.tipo"));
                mantenimiento.setDescripcion(rs.getString("m.descripcion"));
                mantenimiento.setResultado(rs.getString("m.resultado"));
                mantenimiento.setEquipo(rs.getInt("m.equipo_codigo"));
                mantenimiento.setResponsable(rs.getString("r.nombre")+" "+ rs.getString("r.apellido"));
                lista.add(mantenimiento);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOMantenimientoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
         return lista;
    }
    
     
    
}
